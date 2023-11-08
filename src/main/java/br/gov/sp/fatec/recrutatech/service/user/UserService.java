package br.gov.sp.fatec.recrutatech.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.recrutatech.dto.EmailDto;
import br.gov.sp.fatec.recrutatech.entity.User;
import br.gov.sp.fatec.recrutatech.exception.UserNotFoundException;
import br.gov.sp.fatec.recrutatech.repository.UserRepository;
import br.gov.sp.fatec.recrutatech.service.email.EmailService;
import br.gov.sp.fatec.recrutatech.util.RandomStringGenerator;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepo;
    
    private RandomStringGenerator randomS =new RandomStringGenerator();

    @Autowired
    private EmailService emailService;

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

    @Override
    public void changePassword(EmailDto email){

        Optional<User> userOp = userRepo.findByEmail(email.getEmail());

        if(userOp.isPresent()){

            User user = userOp.get();
            String newPassword=randomS.gerarStringAleatoria(12);
            String encryptedPassword = new BCryptPasswordEncoder().encode(newPassword);
            emailService.sendNewPassword(email,newPassword);

            user.setPassword(encryptedPassword);
            userRepo.save(user);

        } else {
            throw new UserNotFoundException("Usuário não encontrado.");
        }

    }
}
