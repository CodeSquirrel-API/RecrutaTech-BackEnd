package br.gov.sp.fatec.recrutatech.service.position;

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
                position.getCha() == null ||
                position.getExperience() == null) {
            throw new IllegalArgumentException("Informações do usuário incompletas.");
        }

        return positionRepo.save(position);
    }

    @Override
    public Position findByName(String name) {
        Optional<Position> positionOp = positionRepo.findByName(name);

        if (positionOp.isPresent()) {
            return positionOp.get();
        }

        throw new IllegalArgumentException("Nome inválido");
    }

    @Override
    public Position updatePosition(Position position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePosition'");
    }

    @Override
    public Position deletePosition(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePosition'");
    }

}
