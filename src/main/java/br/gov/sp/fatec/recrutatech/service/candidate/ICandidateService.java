package br.gov.sp.fatec.recrutatech.service.candidate;

import java.util.List;

import br.gov.sp.fatec.recrutatech.entity.Candidate;

public interface ICandidateService {
    Candidate findById(Long id);

    List<Candidate> getAllCandidates();

    Candidate addCandidates(Candidate candidates);

    Candidate updateCandidates(Candidate candidates);

    Candidate deleteCandidate(Long id);
}