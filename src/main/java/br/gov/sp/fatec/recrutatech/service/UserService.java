package br.gov.sp.fatec.recrutatech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.recrutatech.entity.User;
import br.gov.sp.fatec.recrutatech.repository.UserRepository;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepo;

    public User findById(Long id) {
        Optional<User> userOp = userRepo.findById(id);

        if (userOp.isPresent()) {
            return userOp.get();
        }

        throw new IllegalArgumentException("Id inválido");
    }

    public User addUser(User user) {
        if (user == null ||
                user.getName() == null ||
                user.getPassword() == null ||
                user.getCompany() == null) {
            throw new IllegalArgumentException("Informações do usuário incompletas.");
        }

        return userRepo.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }
}
