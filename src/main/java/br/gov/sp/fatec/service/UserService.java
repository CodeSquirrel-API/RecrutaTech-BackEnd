package br.gov.sp.fatec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.entity.user.IUserService;
import br.gov.sp.fatec.entity.user.User;
import br.gov.sp.fatec.repository.IUserRepository;

public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepo;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
