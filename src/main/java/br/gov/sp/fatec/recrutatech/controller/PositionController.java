package br.gov.sp.fatec.recrutatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.recrutatech.entity.Position;
import br.gov.sp.fatec.recrutatech.service.position.IPositionService;
import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping(value = "/position")
@Api(tags = "Cargo")

public class PositionController {

    @Autowired
    private IPositionService service;

    @GetMapping(value = "/getByName/{name}")
    public Position findByName(@PathVariable("name") String name) {
        return service.findByName(name);
    }

    @GetMapping(value = "/getById/{id}")
    public Position findByName(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/getAll")
    public List<Position> findAllPositions() {
        return service.findAll();
    }

    @PostMapping(value = "/create")
    public Position addPosition(@RequestBody Position position) {
        return service.addPosition(position);
    }

}
