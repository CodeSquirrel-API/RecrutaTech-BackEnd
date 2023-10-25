package br.gov.sp.fatec.recrutatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.recrutatech.entity.Knowledge;
import br.gov.sp.fatec.recrutatech.enums.ExperienceType;
import br.gov.sp.fatec.recrutatech.service.knowledge.IKnowledgeService;
import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping(value = "/knowledge")
@Api(tags = "Knowledge")

public class KnowledgeController {

    @Autowired
    private IKnowledgeService service;

    @GetMapping(value = "/getAll")
    public List<Knowledge> findKnowledges() {
        return service.getAllKnowledges();
    }

    @GetMapping(value = "/getById/{id}")
    public Knowledge findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(value = "/create")
    public List<Knowledge> addKnowledges(@RequestBody List<Knowledge> knowledges) {
        return service.addKnowledges(knowledges);
    }

    @PutMapping(value = "/update")
    public List<Knowledge> updateKnowledges(@RequestBody List<Knowledge> knowledges) {
        return service.updateKnowledges(knowledges);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Knowledge deleteKnowledge(@PathVariable("id") Long id) {
        return service.deleteKnowledge(id);
    }

    @GetMapping(value = "/getByExperienceType/{experienceType}")
    public List<Knowledge> getKnowledgesByExperienceType(
            @PathVariable("experienceType") ExperienceType experienceType) {
        return service.getKnowledgesByExperienceType(experienceType);
    }

}
