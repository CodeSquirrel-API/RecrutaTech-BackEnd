package br.gov.sp.fatec.recrutatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.recrutatech.entity.Attitude;

@Repository
public interface AttitudeRepository extends JpaRepository<Attitude, Long> {
  

}
    