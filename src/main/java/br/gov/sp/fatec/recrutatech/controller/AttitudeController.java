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

import br.gov.sp.fatec.recrutatech.entity.Attitude;
import br.gov.sp.fatec.recrutatech.service.attitude.IAttitudeService;
import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping(value = "/attitude") 
@Api(tags = "Attitude") 

public class AttitudeController {

    @Autowired
    private IAttitudeService service;

    @GetMapping(value = "/getAll")
    public List<Attitude> findAttitudes() {
        return service.getAllAttitudes();
    }

    @GetMapping(value = "/getById/{id}")
    public Attitude findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(value = "/create")
    public List<Attitude> addAttitudes(@RequestBody List<Attitude> attitudes) {
        return service.addAttitudes(attitudes);
    }

    @PutMapping(value = "/update")
    public List<Attitude> updateAttitudes(@RequestBody List<Attitude> attitudes) {
        return service.updateAttitudes(attitudes);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Attitude deleteAttitude(@PathVariable("id") Long id) {
        return service.deleteAttitude(id);
    }
}

