package br.gov.sp.fatec.recrutatech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.recrutatech.Security.TokenService;
import br.gov.sp.fatec.recrutatech.dto.Login;
import br.gov.sp.fatec.recrutatech.entity.User;
import br.gov.sp.fatec.recrutatech.repository.UserRepository;
import br.gov.sp.fatec.recrutatech.service.user.UserService;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin
@RestController
@RequestMapping(value = "/login") 
public class AuthenticationController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    //private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);


    @PostMapping("/login")
    public String login (@RequestBody Login login) throws UsernameNotFoundException{

    

        //logger.info("Received Login object: {}-{}", login.getEmail(),login.getPassword());

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login.getEmail(),login.getPassword());
        Authentication authentication =  this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var usuario = (User) authentication.getPrincipal();
        
        return tokenService.gerarToken(usuario);
    }

     @PostMapping("/register")
    public User register(@RequestBody User user){

        String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encryptedPassword);
        user.setUserType("ROLE_USER");

        userService.addUser(user);

        return user;
    }
}
