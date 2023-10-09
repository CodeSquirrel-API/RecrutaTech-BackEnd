package br.gov.sp.fatec.recrutatech.service.user;

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
                user.getCpf_cnpj() == null ||
                user.getEmail() == null ||
                user.getUserType() == null) {
            throw new IllegalArgumentException("Informações do usuário incompletas.");
        }

        return userRepo.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User updateUser(User user) {
        Optional<User> userOp = userRepo.findById(user.getId());

        if (userOp.isPresent()) {
            User existingUser = userOp.get();
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setCpf_cnpj(user.getCpf_cnpj());
            existingUser.setPassword(user.getPassword());
            existingUser.setUserType(user.getUserType());
            
            return userRepo.save(existingUser);
        } else {
            throw new IllegalArgumentException("ID de usuário inválido");
        }
    }

    @Override
    public User deleteUser(Long id) {
        Optional<User> userOp = userRepo.findById(id);

        if (userOp.isPresent()) {
            userRepo.deleteById(id);
            return userOp.get();
        } else {
            throw new IllegalArgumentException("ID de usuário inválido");
        }
    }
}
