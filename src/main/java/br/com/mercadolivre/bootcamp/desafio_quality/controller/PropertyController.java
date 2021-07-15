package br.com.mercadolivre.bootcamp.desafio_quality.controller;

import br.com.mercadolivre.bootcamp.desafio_quality.model.DTO.RoomSquareDTO;
import br.com.mercadolivre.bootcamp.desafio_quality.model.DTO.TotalValueDTO;
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

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/property")
public class PropertyController {

    private PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("/squaremeters")
    public ResponseEntity<?> calcTotalSquareMeters(@Valid @RequestBody PropertyFormDTO propertyFormDTO){
        Property property = this.propertyService.convertFormToProperty(propertyFormDTO);
        return new ResponseEntity<>(this.propertyService.getTotalAreaProperty(property), HttpStatus.OK);
    }

    @PostMapping("/price")
    public ResponseEntity<?> calcPropertyTotalPrice(@Valid @RequestBody PropertyFormDTO propertyFormDTO){
        Property property = this.propertyService.convertFormToProperty(propertyFormDTO);
        BigDecimal price = this.propertyService.getTotalPriceProperty(property);
        return new ResponseEntity<>(
                TotalValueDTO.converte(property, price), HttpStatus.OK);
    }

    @PostMapping("/largestroom")
    public ResponseEntity<?> getLargestRoom(@Valid @RequestBody PropertyFormDTO propertyFormDTO){
        Property property = this.propertyService.convertFormToProperty(propertyFormDTO);
        RoomSquareDTO largestRoomDTO = RoomSquareDTO.converte(this.propertyService.getLargestRoom(property));
        return new ResponseEntity<>(largestRoomDTO, HttpStatus.OK);
    }

    @PostMapping("squaremetersrooms")
    public ResponseEntity<?> getSquareMetersAllRooms(@Valid @RequestBody PropertyFormDTO propertyFormDTO){
        Property property = this.propertyService.convertFormToProperty(propertyFormDTO);
        return new ResponseEntity<>(this.propertyService.getSquareAllRooms(property), HttpStatus.OK);
    }
}
