package br.gov.sp.fatec.recrutatech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @PostMapping(value = "/create")
    public Position addPosition(@RequestBody Position position) {
        return service.addPosition(position);
    }

}
