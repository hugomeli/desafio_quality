package br.com.mercadolivre.bootcamp.desafio_quality.model.repository;


import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.District;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class DistrictRepository {

    private final List<District> districtList;

    public DistrictRepository(){
        this.districtList = new ArrayList<>(Arrays.asList(
                new District("Vila Olímpia", new BigDecimal("12310.00")),
                new District("Tatuapé", new BigDecimal("6800.00")),
                new District("Vila Madalena", new BigDecimal("11340.00")),
                new District("Pinheiros", new BigDecimal("13170.00"))
        ));
    }

    public District findByName(String districtName){
        return this.districtList.stream().filter(district -> district.getName()
                .equalsIgnoreCase(districtName))
                .findFirst()
                .orElse(null);
    }
}
