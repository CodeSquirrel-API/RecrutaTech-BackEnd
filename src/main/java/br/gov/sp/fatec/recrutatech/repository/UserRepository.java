package br.gov.sp.fatec.recrutatech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.recrutatech.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User>  findByEmail(String email);
    
}
