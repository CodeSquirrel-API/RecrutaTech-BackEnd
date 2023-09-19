package br.gov.sp.fatec.recrutatech.service.position;

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


}
