package br.gov.sp.fatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.entity.user.User;

public interface IUserRepository extends JpaRepository<User, Long>{
    
}
