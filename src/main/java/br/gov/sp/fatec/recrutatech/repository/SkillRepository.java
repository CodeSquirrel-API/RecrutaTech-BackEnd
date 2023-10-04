package br.gov.sp.fatec.recrutatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.recrutatech.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
  

}
    