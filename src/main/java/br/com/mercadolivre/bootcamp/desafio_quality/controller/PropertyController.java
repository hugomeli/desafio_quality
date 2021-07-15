package br.com.mercadolivre.bootcamp.desafio_quality.controller;

import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.Property;
import br.com.mercadolivre.bootcamp.desafio_quality.model.forms.PropertyFormDTO;
import br.com.mercadolivre.bootcamp.desafio_quality.model.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/property")
public class PropertyController {

    private PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    public ResponseEntity<?> calcTotalSquareMeters(@RequestBody PropertyFormDTO propertyFormDTO){
        Property property = this.propertyService.converteFormParaProperty(propertyFormDTO);
        return new ResponseEntity<>(this.propertyService.getTotalAreaProperty(property), HttpStatus.OK);
    }
}
