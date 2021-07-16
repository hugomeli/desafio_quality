package br.com.mercadolivre.bootcamp.desafio_quality.service;

import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.District;
import br.com.mercadolivre.bootcamp.desafio_quality.model.repository.DistrictRepository;
import br.com.mercadolivre.bootcamp.desafio_quality.model.service.DistrictService;
import br.com.mercadolivre.bootcamp.desafio_quality.validations.exceptions.DistrictAlreadySavedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.math.BigDecimal;

public class DistrictServiceTest {

    private DistrictService districtService;
    private DistrictRepository districtRepository;


    @BeforeEach
    public void init(){
        districtRepository = Mockito.mock(DistrictRepository.class);
        this.districtService = new DistrictService(districtRepository);
    }

    @Test
    void shouldBeAbleToCreateADistrict(){
        Mockito.when(districtRepository.findByName(ArgumentMatchers.any(String.class))).thenReturn(null);

        District mockDistrict = new District("Lapa", new BigDecimal("9850.00"));
        this.districtService.create(mockDistrict);

        Mockito.verify(districtRepository).save(mockDistrict);
    }

    @Test
    void shouldNotCreateADistrictIfItsAlreadyExists(){
        District districtFounded = new District("Alvim", new BigDecimal("6530.00"));

        // Encontramos o bairro, ou seja, já está cadastrado
        Mockito.when(districtRepository.findByName(ArgumentMatchers.any(String.class))).thenReturn(districtFounded);

        District mockDistrict = new District("Alvim", new BigDecimal("9850.00"));

        Exception exception = Assertions.assertThrows(DistrictAlreadySavedException.class, () ->
                this.districtService.create(mockDistrict));

        // Verifica se um método nunca foi chamado no teste. Estamos verificando se o método de salvar foi chamado.
        Mockito.verify(this.districtRepository, Mockito.never()).save(mockDistrict);

        String exceptionMessageExpected = "O bairro Alvim já está cadastrado no sistema!";

        Assertions.assertEquals(exceptionMessageExpected ,exception.getMessage());
    }

}
