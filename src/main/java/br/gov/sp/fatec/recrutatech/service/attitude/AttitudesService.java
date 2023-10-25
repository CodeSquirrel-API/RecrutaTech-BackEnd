package br.gov.sp.fatec.recrutatech.service.attitude;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.recrutatech.entity.Attitude;
import br.gov.sp.fatec.recrutatech.enums.ExperienceType;
import br.gov.sp.fatec.recrutatech.repository.AttitudeRepository;

@Service
public class AttitudesService implements IAttitudeService {

    @Autowired
    private AttitudeRepository attitudeRepo;

    public Attitude findById(Long id) {
        Optional<Attitude> skillOp = attitudeRepo.findById(id);

        return skillOp.orElse(null);
    }

    public List<Attitude> getAllAttitudes() {
        return attitudeRepo.findAll();
    }

    public List<Attitude> addAttitudes(List<Attitude> attitudes) {
        if (attitudes == null || attitudes.isEmpty()) {
            throw new IllegalArgumentException("Lista de atitudes vazia ou nula.");
        }

        return attitudeRepo.saveAll(attitudes);
    }

    public List<Attitude> updateAttitudes(List<Attitude> attitudes) {
        if (attitudes == null || attitudes.isEmpty()) {
            throw new IllegalArgumentException("Lista de atitudes vazia ou nula.");
        }

        return attitudeRepo.saveAll(attitudes);
    }

    public Attitude deleteAttitude(Long id) {
        Optional<Attitude> attitudeOp = attitudeRepo.findById(id);

        if (attitudeOp.isPresent()) {
            attitudeRepo.deleteById(id);
            return attitudeOp.get();
        } else {
            throw new IllegalArgumentException("ID de atitudes inválido");
        }
    }

    public List<Attitude>getAttitudeByExperienceType(ExperienceType experienceType) {
        List<Attitude> result = new ArrayList<>();

        for (Attitude Attitude : attitudeRepo.findAll()) {
            if (Attitude.getExperience().equals(experienceType)) {
                result.add(Attitude);
            }
        }

        return result;
}
}