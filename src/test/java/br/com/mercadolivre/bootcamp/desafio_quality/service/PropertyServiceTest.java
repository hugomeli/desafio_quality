package br.com.mercadolivre.bootcamp.desafio_quality.service;

import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.District;
import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.Property;
import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.Room;
import br.com.mercadolivre.bootcamp.desafio_quality.model.forms.PropertyFormDTO;
import br.com.mercadolivre.bootcamp.desafio_quality.model.repository.DistrictRepository;
import br.com.mercadolivre.bootcamp.desafio_quality.model.service.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PropertyServiceTest {

    private PropertyService propertyService;
    private DistrictRepository districtRepository;

    @BeforeEach
    public void init(){
        this.districtRepository = new DistrictRepository();
        this.propertyService = new PropertyService(districtRepository);
    }

    @Test
    void shouldReturnARoomArea_WidthMultiplyByLength(){
        Room room = new Room("Quarto", 5, 6);
        double expectedResult = 30.0;
        double result = propertyService.getTotalAreaRoom(room);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void deveriaRetornarAAreaDeUmaPropriedadeComDiversosComodosComAtributosValidos(){
        Property property = createProperty();
        double expectedResult = 81.0;
        double result = propertyService.getTotalAreaProperty(property);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void deveriaRetornarOValorDeUmaPropriedadeComTodosAtributosValidos(){
        Property property = createProperty();
        BigDecimal expectedResult = new BigDecimal("486.00");
        BigDecimal result = propertyService.getTotalPriceProperty(property);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void deveriaRetornarOMaiorComodoQueUmaPropriedadePossuiComTodosAtributosValidos(){
        Property property = createProperty();
        Room expectedResult = new Room("Sala", 5, 6);
        Room result = propertyService.getLargestRoom(property);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void deveriaIndicarCasoOBairroIndicadoExistaNoRepositorioNomesDeBairros(){
        District result = this.districtRepository.findByName("Tatuapé");
        Assertions.assertEquals("Tatuapé", result.getName());
    }

    private List<Room> createRooms(){
        return new ArrayList<>(Arrays.asList(
                new Room("Quarto", 4, 5),
                new Room("Sala", 5, 6),
                new Room("Cozinha", 5, 5),
                new Room("Banheiro", 3, 2)
        ));
    }

    private Property createProperty(){
        return new Property(
                "Casa Verde Com Jardim",
                new District("Liberdade", new BigDecimal("6.0")),
                createRooms()
        );
    }
}
