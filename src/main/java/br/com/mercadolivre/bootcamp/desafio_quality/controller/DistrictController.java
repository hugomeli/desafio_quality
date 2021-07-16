package br.com.mercadolivre.bootcamp.desafio_quality.controller;


import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.District;
import br.com.mercadolivre.bootcamp.desafio_quality.model.forms.DistrictFormDTO;
import br.com.mercadolivre.bootcamp.desafio_quality.model.service.DistrictService;
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
    public ResponseEntity<?> createDistrict(@RequestBody DistrictFormDTO districtFormDTO){
        District district = DistrictFormDTO.converte(districtFormDTO);
        this.districtService.create(district);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
//
//    @PostMapping("/update")
//    public ResponseEntity<?> updateDistrict(@RequestBody District district){
//        this.districtService.update(district)
//    }
}
