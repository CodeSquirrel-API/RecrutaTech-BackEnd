package br.gov.sp.fatec.recrutatech.service.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.recrutatech.entity.User;
import br.gov.sp.fatec.recrutatech.repository.UserRepository;


@Service
public class AuthenticationService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = (User) userRepository.findByEmail(email);
    if (user == null) {
        throw new UsernameNotFoundException("User not found with email: " + email);
    }
    return user;
}
    
    }

