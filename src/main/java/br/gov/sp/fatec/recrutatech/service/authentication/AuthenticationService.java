package br.gov.sp.fatec.recrutatech.service.authentication;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOp = userRepository.findByEmail(email);

        logger.info("email:{}",email);

        if(userOp.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
            
        }
        User user = userOp.get();

        return (User) user;
}
    
    }

