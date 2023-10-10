package br.gov.sp.fatec.recrutatech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.recrutatech.entity.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    @Query("SELECT p FROM Position p WHERE p.name LIKE %:name%")
    Optional<Position> findByNameContaining(@Param("name") String name);

}
