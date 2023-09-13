package br.gov.sp.fatec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.entity.user.IUserService;
import br.gov.sp.fatec.entity.user.User;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@CrossOrigin
@RequestMapping(value = "/user")
@Api(value="API")

public class UserController {
    @Autowired
    private IUserService service;

    
    @GetMapping
    @ApiOperation(value="Retorna um todos os usuarios")
    public List<User> findUsers() {
        return service.findAll();
    }

    @GetMapping(value = "/{user}")
    public User buscarPorId(@PathVariable("user") Long id) {
        return service.findById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return service.addUser(user);
    }

}