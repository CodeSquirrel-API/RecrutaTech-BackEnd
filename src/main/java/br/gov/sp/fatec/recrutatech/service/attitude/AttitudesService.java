package br.gov.sp.fatec.recrutatech.service.attitude;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.recrutatech.entity.Attitude;
import br.gov.sp.fatec.recrutatech.repository.AttitudeRepository;

@Service
public class AttitudesService implements IAttitudeService {

    @Autowired
    private AttitudeRepository attitudeRepo;

    public Attitude findById(Long id) {
        Optional<Attitude> attitudeOp = attitudeRepo.findById(id);

        if (attitudeOp.isPresent()) {
            return attitudeOp.get();
        }

        throw new IllegalArgumentException("Id inválido");
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
}
