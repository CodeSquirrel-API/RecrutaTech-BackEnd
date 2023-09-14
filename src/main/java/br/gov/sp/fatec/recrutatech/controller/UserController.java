package br.gov.sp.fatec.recrutatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.recrutatech.entity.User;
import br.gov.sp.fatec.recrutatech.service.IUserService;
import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
@Api(tags = "User")

public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping(value = "/getAll")
    public List<User> findUsers() {
        return service.findAll();
    }

    @GetMapping(value = "/getById/{id}")
    public User findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(value = "/create")
    public User addUser(User user) {
        return service.addUser(user);
    }

}