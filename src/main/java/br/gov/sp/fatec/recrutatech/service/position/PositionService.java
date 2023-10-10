package br.gov.sp.fatec.recrutatech.service.position;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.recrutatech.entity.Position;
import br.gov.sp.fatec.recrutatech.repository.PositionRepository;

@Service
public class PositionService implements IPositionService {

    @Autowired
    private PositionRepository positionRepo;

    @Override
    public Position addPosition(Position position) {
        if (position == null ||
                position.getName() == null ||
                position.getKnowledge() == null ||
                position.getSkill() == null ||
                position.getAttitude() == null ||
                position.getExperience() == null) {
            throw new IllegalArgumentException("Informações do usuário incompletas.");
        }

        return positionRepo.save(position);
    }

    @Override
    public Position findByName(String name) {
        Optional<Position> positionOp = positionRepo.findByNameContaining(name);

        if (positionOp.isPresent()) {
            return positionOp.get();
        }

        throw new IllegalArgumentException("Nome inválido");
    }

    @Override
    public Position updatePosition(Position updatedPosition) {
        Long id = updatedPosition.getId();

        Position existingPosition = positionRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Posição não encontrada com o ID fornecido: " + id));

        existingPosition.setName(updatedPosition.getName());
        existingPosition.setKnowledge(updatedPosition.getKnowledge());
        existingPosition.setSkill(updatedPosition.getSkill());
        existingPosition.setAttitude(updatedPosition.getAttitude());
        existingPosition.setExperience(updatedPosition.getExperience());

        return positionRepo.save(existingPosition);
    }

    @Override
    public Position deletePosition(Long id) {
        Position existingPosition = positionRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Posição não encontrada com o ID fornecido: " + id));

        positionRepo.delete(existingPosition);

        return existingPosition;
    }

    @Override
    public List<Position> findAll() {
        return positionRepo.findAll();
    }

    @Override
    public Position findById(Long id) {
        Optional<Position> positionOp = positionRepo.findById(id);

        if (positionOp.isPresent()) {
            return positionOp.get();
        }

        throw new IllegalArgumentException("Id inválido");
    }

}
