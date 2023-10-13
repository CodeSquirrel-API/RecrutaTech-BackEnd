package br.gov.sp.fatec.recrutatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.recrutatech.entity.User;
import br.gov.sp.fatec.recrutatech.repository.UserRepository;
import br.gov.sp.fatec.recrutatech.service.user.IUserService;
import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
@Api(tags = "User")

public class UserController {

    @Autowired
    private IUserService service;
    @Autowired
    private PasswordEncoder encoder;

    @GetMapping(value = "/getAll")
    public List<User> findUsers() {
        return service.findAll();
    }

    @GetMapping(value = "/getById/{id}")
    public User findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(value = "/create")
    public User addUser(@RequestBody User user) {
        return service.addUser(user);
    }
    
      @PostMapping(value = "/createsenhacrip")
    public User addUserCrip(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return service.addUser(user);
    }

    @PutMapping(value = "/update")
    public User updateUser(User user) {
        return service.updateUser(user);
    }

    @DeleteMapping(value = "/delete/{id}")
    public User deleteUser(@PathVariable("id") Long id) {
        return service.deleteUser(id);
    }
}