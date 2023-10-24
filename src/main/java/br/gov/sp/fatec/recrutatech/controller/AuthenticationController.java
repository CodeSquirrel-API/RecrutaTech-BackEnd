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
    private UserRepository userRepository;

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
    public Login register(@RequestBody Login login){

        String encryptedPassword = new BCryptPasswordEncoder().encode(login.getPassword());
        User newUser = new User(login.getEmail(), encryptedPassword,"ROLE_USER");

        userRepository.save(newUser);

        return login;
    }
}
