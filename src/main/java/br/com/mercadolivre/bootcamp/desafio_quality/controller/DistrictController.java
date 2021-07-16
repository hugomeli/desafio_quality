package br.com.mercadolivre.bootcamp.desafio_quality.controller;


import br.com.mercadolivre.bootcamp.desafio_quality.model.DTO.DistrictDTO;
import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.District;
import br.com.mercadolivre.bootcamp.desafio_quality.model.forms.DistrictFormDTO;
import br.com.mercadolivre.bootcamp.desafio_quality.model.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictController {

    private DistrictService districtService;

    @Autowired
    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createDistrict(@Valid @RequestBody DistrictFormDTO districtFormDTO){
        District district = DistrictFormDTO.converte(districtFormDTO);
        this.districtService.create(district);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateDistrict(@Valid @RequestBody DistrictFormDTO districtFormDTO){
        District district = DistrictFormDTO.converte(districtFormDTO);
        this.districtService.update(district);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete/{districtname}")
    public ResponseEntity<?> deleteDistrict(@PathVariable String districtname){
        this.districtService.delete(districtname);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/read/{districtname}")
    public ResponseEntity<DistrictDTO> readDistrict(@PathVariable String districtname){
        District district = this.districtService.read(districtname);
        return new ResponseEntity<>(DistrictDTO.converte(district), HttpStatus.OK);
    }

    @GetMapping("/readall")
    public ResponseEntity<List<DistrictDTO>> readDistricts(){
        List<DistrictDTO> districtsDTO = this.districtService.readAll();
        return new ResponseEntity<>(districtsDTO, HttpStatus.OK);
    }
}
