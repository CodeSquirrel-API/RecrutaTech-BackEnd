package br.gov.sp.fatec.recrutatech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.recrutatech.entity.Candidate;
import br.gov.sp.fatec.recrutatech.enums.ExperienceType;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

@Query("SELECT c FROM Candidate c WHERE c.currentProfession = :cnd_current_profession AND c.experience = :cnd_experience")
List<Candidate> findByProfessionAndExperience(@Param("cnd_current_profession") String profession, @Param("cnd_experience") ExperienceType experience);

    
}
