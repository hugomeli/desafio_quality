package br.com.mercadolivre.bootcamp.desafio_quality.model.service;

import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.Property;
import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.Room;
import org.springframework.stereotype.Service;


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

}
