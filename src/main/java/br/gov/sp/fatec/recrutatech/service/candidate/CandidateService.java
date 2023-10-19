package br.gov.sp.fatec.recrutatech.service.candidate;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.recrutatech.entity.Candidate;
import br.gov.sp.fatec.recrutatech.repository.CandidateRepository;

@Service
public class CandidateService implements ICandidateService{

    @Autowired
    private CandidateRepository candidateRepo;

    public Candidate findById(Long id) {
        Optional<Candidate> candidateOp = candidateRepo.findById(id);

        if (candidateOp.isPresent()) {
            return candidateOp.get();
        }

        throw new IllegalArgumentException("Id inválido");
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepo.findAll();
    }

    public Candidate addCandidates(Candidate candidates) {
        if (candidates == null ) {
            throw new IllegalArgumentException("Lista de candidatos vazia ou nula.");
        }

        return candidateRepo.save(candidates);
    }

    public Candidate updateCandidates(Candidate candidates) {
        if (candidates == null) {
            throw new IllegalArgumentException("Lista de candidatos vazia ou nula.");
        }

        return candidateRepo.save(candidates);
    }

    public Candidate deleteCandidate(Long id) {
        Optional<Candidate> candidateOp = candidateRepo.findById(id);

        if (candidateOp.isPresent()) {
            candidateRepo.deleteById(id);
            return candidateOp.get();
        } else {
            throw new IllegalArgumentException("ID de candidato inválido");
        }
    }
}
