package br.gov.sp.fatec.recrutatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import br.gov.sp.fatec.recrutatech.Security.TokenService;
import br.gov.sp.fatec.recrutatech.dto.EmailDto;
import br.gov.sp.fatec.recrutatech.entity.User;
import br.gov.sp.fatec.recrutatech.exception.UserNotFoundException;
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

    @Autowired
    private TokenService ts;

    @GetMapping(value = "/getAll")
    public List<User> findUsers() {
        return service.findAll();
    }

    @GetMapping(value = "/getById/{id}")
    public User findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    
    
      @PostMapping(value = "/create")
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


    
    @PutMapping(value = "/changePassword/{token}/{senha}")
public ResponseEntity<String> changePassword(
        @PathVariable("token") String token,
        @PathVariable("senha") String senha) {
    EmailDto email = new EmailDto(ts.verificarToken(token));
    
    try {
        service.changePassword(email, senha);
        return ResponseEntity.ok("Senha alterada com sucesso para o usuário com o email: " + email.getEmail());
    } catch (UserNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
    }
}
}
    
