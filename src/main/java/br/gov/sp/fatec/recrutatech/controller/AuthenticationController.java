package br.gov.sp.fatec.recrutatech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.recrutatech.dto.Login;
import br.gov.sp.fatec.recrutatech.entity.User;
import br.gov.sp.fatec.recrutatech.service.authentication.TokenService;

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

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);


    @PostMapping("/login")
    public String login (@RequestBody Login login){

        logger.info("Received Login object: {}-{}", login.getEmail(),login.getPassword());



        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login.getEmail(),login.getPassword());
        Authentication authentication =  this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var usuario = (User) authentication.getPrincipal();
        
        return tokenService.gerarToken(usuario);
    }
}
