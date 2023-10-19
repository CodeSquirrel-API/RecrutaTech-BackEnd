package br.gov.sp.fatec.recrutatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.recrutatech.entity.Candidate;
import br.gov.sp.fatec.recrutatech.service.candidate.CandidateService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateService service;

    @GetMapping(value = "/getAll")
    public List<Candidate> findCandidates() {
        return service.getAllCandidates();
    }

    @GetMapping(value = "/getById/{id}")
    public Candidate findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(value = "/create")
    public List<Candidate> addCandidates(@RequestBody List<Candidate> candidates) {
        return service.addCandidates(candidates);
    }

    @PutMapping(value = "/update")
    public List<Candidate> updateCandidates(@RequestBody List<Candidate> candidates) {
        return service.updateCandidates(candidates);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Candidate deleteCandidate(@PathVariable("id") Long id) {
        return service.deleteCandidate(id);
    }
}
