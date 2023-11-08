package br.gov.sp.fatec.recrutatech.service.user;

import java.util.List;

import br.gov.sp.fatec.recrutatech.dto.EmailDto;
import br.gov.sp.fatec.recrutatech.entity.User;

public interface IUserService {

    public User findById(Long id);

    public User findByEmail(String email);

    public void changePassword(EmailDto email);


    public User addUser(User user);
    
    public User updateUser(User user);
    
    public User deleteUser(Long id);

    public List<User> findAll();
}
