package br.gov.sp.fatec.recrutatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.recrutatech.entity.Knowledge;

@Repository
public interface KnowledgeRepository extends JpaRepository<Knowledge, Long> {
  

}
    