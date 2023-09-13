package br.gov.sp.fatec.entity.user;

import java.util.List;

public interface IUserService {

    public User findById(Long id);

    public User addUser(User user);

    public List<User> findAll();
}
