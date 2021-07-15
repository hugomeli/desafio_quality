package br.com.mercadolivre.bootcamp.desafio_quality.model.service;

import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.Property;
import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.Room;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PropertyService {

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
        return valueM2.multiply(BigDecimal.valueOf(totalAreaProperty));
    }

    public Room getLargestRoom(Property property){
        return property.getRooms()
                .stream()
                .max(Comparator.comparing(this::getTotalAreaRoom)).orElse(null);
    }
}
