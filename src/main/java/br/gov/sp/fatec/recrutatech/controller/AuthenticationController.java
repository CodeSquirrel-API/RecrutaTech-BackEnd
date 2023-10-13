package br.gov.sp.fatec.recrutatech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.recrutatech.dto.Login;
import br.gov.sp.fatec.recrutatech.entity.User;
import br.gov.sp.fatec.recrutatech.service.authentication.TokenService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
public class AuthenticationController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
    @PostMapping("/login")
    public String login (@RequestBody Login login){


        
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login.email(),login.password());
        Authentication authentication =  this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var usuario = (User) authentication.getPrincipal();
        
        return tokenService.gerarToken(usuario);
    }
}
