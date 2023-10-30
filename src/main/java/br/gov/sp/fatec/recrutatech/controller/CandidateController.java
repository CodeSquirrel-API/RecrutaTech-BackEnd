package br.gov.sp.fatec.recrutatech.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.recrutatech.dto.CandidateRequestDto;
import br.gov.sp.fatec.recrutatech.entity.Attitude;
import br.gov.sp.fatec.recrutatech.entity.Candidate;
import br.gov.sp.fatec.recrutatech.entity.Knowledge;
import br.gov.sp.fatec.recrutatech.entity.Skill;
import br.gov.sp.fatec.recrutatech.service.attitude.AttitudesService;
import br.gov.sp.fatec.recrutatech.service.candidate.CandidateService;
import br.gov.sp.fatec.recrutatech.service.knowledge.KnowledgeService;
import br.gov.sp.fatec.recrutatech.service.skill.SkillService;

@RestController
@RequestMapping("/candidates")
@CrossOrigin
public class CandidateController {

    @Autowired
    private CandidateService service;

    @Autowired
    private KnowledgeService knowledgeService;

    @Autowired
    private SkillService skillService;

    @Autowired
    private AttitudesService attitudeService;

    @GetMapping(value = "/getAll")
    public List<Candidate> findCandidates() {
        return service.getAllCandidates();
    }

    @GetMapping(value = "/getById/{id}")
    public Candidate findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> addCandidate(@RequestBody CandidateRequestDto candidateRequest) {
        Candidate candidate = new Candidate();
        candidate.setName(candidateRequest.getName());
        candidate.setEmail(candidateRequest.getEmail());
        candidate.setAge(candidateRequest.getAge());
        candidate.setCurrentProfession(candidateRequest.getCurrentProfession());
        candidate.setExperiences(candidateRequest.getExperiences());

        List<Knowledge> knowledgeList = new ArrayList<>();
        for (Long knowledgeId : candidateRequest.getKnowledgeList()) {
            Knowledge knowledge = knowledgeService.findById(knowledgeId);
            if (knowledge != null) {
                knowledgeList.add(knowledge);
            } else {
                return ResponseEntity.badRequest().body("Conhecimento com ID " + knowledgeId + " não encontrado.");
            }
        }
        candidate.setKnowledgeList(knowledgeList);

        List<Skill> skillList = new ArrayList<>();
        for (Long skillId : candidateRequest.getSkillsList()) {
            Skill skill = skillService.findById(skillId);
            if (skill != null) {
                skillList.add(skill);
            } else {
                return ResponseEntity.badRequest().body("Habilidade com ID " + skillId + " não encontrada.");
            }
        }
        candidate.setSkillsList(skillList);

        List<Attitude> attitudeList = new ArrayList<>();
        for (Long attitudeId : candidateRequest.getAttitudeList()) {
            Attitude attitude = attitudeService.findById(attitudeId);
            if (attitude != null) {
                attitudeList.add(attitude);
            } else {
                return ResponseEntity.badRequest().body("Atitude com ID " + attitudeId + " não encontrada.");
            }
        }
        candidate.setAttitudeList(attitudeList);

        Candidate savedCandidate = service.addCandidates(candidate);

        return ResponseEntity.ok(savedCandidate);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> updateCandidate(@RequestBody CandidateRequestDto candidateRequest) {
        Candidate candidate = new Candidate();
        candidate.setId(candidateRequest.getId());
        candidate.setName(candidateRequest.getName());
        candidate.setAge(candidateRequest.getAge());
        candidate.setEmail(candidateRequest.getEmail());
        candidate.setCurrentProfession(candidateRequest.getCurrentProfession());
        candidate.setExperiences(candidateRequest.getExperiences());

        List<Knowledge> knowledgeList = new ArrayList<>();
        for (Long knowledgeId : candidateRequest.getKnowledgeList()) {
            Knowledge knowledge = knowledgeService.findById(knowledgeId);
            if (knowledge != null) {
                knowledgeList.add(knowledge);
            } else {
                return ResponseEntity.badRequest().body("Conhecimento com ID " + knowledgeId + " não encontrado.");
            }
        }
        candidate.setKnowledgeList(knowledgeList);

        List<Skill> skillList = new ArrayList<>();
        for (Long skillId : candidateRequest.getSkillsList()) {
            Skill skill = skillService.findById(skillId);
            if (skill != null) {
                skillList.add(skill);
            } else {
                return ResponseEntity.badRequest().body("Habilidade com ID " + skillId + " não encontrada.");
            }
        }
        candidate.setSkillsList(skillList);

        List<Attitude> attitudeList = new ArrayList<>();
        for (Long attitudeId : candidateRequest.getAttitudeList()) {
            Attitude attitude = attitudeService.findById(attitudeId);
            if (attitude != null) {
                attitudeList.add(attitude);
            } else {
                return ResponseEntity.badRequest().body("Atitude com ID " + attitudeId + " não encontrada.");
            }
        }
        candidate.setAttitudeList(attitudeList);

        Candidate updatedCandidate = service.updateCandidates(candidate);

        return ResponseEntity.ok(updatedCandidate);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Candidate deleteCandidate(@PathVariable("id") Long id) {
        return service.deleteCandidate(id);
    }
}
