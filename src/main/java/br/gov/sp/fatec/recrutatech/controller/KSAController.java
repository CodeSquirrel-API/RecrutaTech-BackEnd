package br.gov.sp.fatec.recrutatech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.recrutatech.dto.KsaReponseDto;
import br.gov.sp.fatec.recrutatech.enums.ExperienceType;
import br.gov.sp.fatec.recrutatech.service.ksa.KsaService;
import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping(value = "/cha")
@Api(tags = "Cha")

public class KSAController {

    @Autowired
    private KsaService service;

    @GetMapping(value = "/getByExperienceType/{experienceType}")
    public KsaReponseDto getKSAByExperienceType(@PathVariable("experienceType") ExperienceType experienceType) {
        return service.getKSAByExperienceType(experienceType);
    }

}
