package br.gov.sp.fatec.recrutatech.service.candidate;

import java.util.List;

import br.gov.sp.fatec.recrutatech.entity.Candidate;

public interface ICandidateService {
    Candidate findById(Long id);

    List<Candidate> getAllCandidates();

    List<Candidate> addCandidates(List<Candidate> candidates);

    List<Candidate> updateCandidates(List<Candidate> candidates);

    Candidate deleteCandidate(Long id);
}