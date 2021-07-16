package br.com.mercadolivre.bootcamp.desafio_quality.controller;


import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.District;
import br.com.mercadolivre.bootcamp.desafio_quality.model.service.DistrictService;
import br.com.mercadolivre.bootcamp.desafio_quality.model.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/district")
public class DistrictController {

    private DistrictService districtService;

    @Autowired
    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createDistrict(@RequestBody District district){
        this.districtService.create(district);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
