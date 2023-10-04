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

import br.gov.sp.fatec.recrutatech.entity.Skill;
import br.gov.sp.fatec.recrutatech.service.skill.ISkillService;
import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping(value = "/skill") 
@Api(tags = "Skill") 
public class SkillController {

    @Autowired
    private ISkillService service;

    @GetMapping(value = "/getAll")
    public List<Skill> findSkills() {
        return service.getAllSkills();
    }

    @GetMapping(value = "/getById/{id}")
    public Skill findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(value = "/create")
    public List<Skill> addSkills(@RequestBody List<Skill> skills) {
        return service.addSkills(skills);
    }

    @PutMapping(value = "/update")
    public List<Skill> updateSkills(@RequestBody List<Skill> skills) {
        return service.updateSkills(skills);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Skill deleteSkill(@PathVariable("id") Long id) {
        return service.deleteSkill(id);
    }
}

