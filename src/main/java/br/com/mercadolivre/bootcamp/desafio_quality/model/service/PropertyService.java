package br.com.mercadolivre.bootcamp.desafio_quality.model.service;

import br.com.mercadolivre.bootcamp.desafio_quality.model.DTO.RoomSquareDTO;
import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.District;
import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.Property;
import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.Room;
import br.com.mercadolivre.bootcamp.desafio_quality.model.forms.PropertyFormDTO;
import br.com.mercadolivre.bootcamp.desafio_quality.model.forms.RoomFormDTO;
import br.com.mercadolivre.bootcamp.desafio_quality.model.repository.DistrictRepository;
import br.com.mercadolivre.bootcamp.desafio_quality.validations.exceptions.DistrictNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;


@Service
public class PropertyService {

    private final DistrictRepository districtRepository;

    @Autowired
    public PropertyService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }


    public double getTotalAreaProperty(Property property){
        // Para cada cômodo, vamos calcular a sua área, depois somar e assim teremos a área da propriedade
        return property.getRooms().stream().map(this::getTotalAreaRoom)
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public Double getTotalAreaRoom(Room room){
        return (room.getWidth() * room.getLength());
    }

    public BigDecimal getTotalPriceProperty(Property property){
        double totalAreaProperty = getTotalAreaProperty(property);
        BigDecimal valueM2 = property.getDistrict().getValueM2();
        return valueM2.multiply(BigDecimal.valueOf(totalAreaProperty)).setScale(2, RoundingMode.HALF_DOWN);
    }

    public Room getLargestRoom(Property property){
        return property.getRooms()
                .stream()
                .max(Comparator.comparing(this::getTotalAreaRoom)).orElse(null);
    }

    public Property convertFormToProperty(PropertyFormDTO propertyFormDTO){
        if (this.districtRepository.findByName(propertyFormDTO.getProp_district()) == null){
            throw new DistrictNotFoundException("Bairro " + propertyFormDTO.getProp_district() + " inexistente");
        }
        return new Property(
                propertyFormDTO.getProp_name(),
                new District(
                        propertyFormDTO.getProp_district(),
                        this.districtRepository.findByName(propertyFormDTO.getProp_district()).getValueM2()),
                        RoomFormDTO.converteRooms(propertyFormDTO.getRooms()
                        )
        );
    }

    public List<RoomSquareDTO> getSquareAllRooms(Property property){
        return RoomSquareDTO.converte(property.getRooms());
    }
}
