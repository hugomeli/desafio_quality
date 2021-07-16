package br.com.mercadolivre.bootcamp.desafio_quality.model.DTO;

import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.District;

import java.math.BigDecimal;

public class DistrictDTO {
    private String district_name;
    private BigDecimal value_district_m2;

    public DistrictDTO() {
    }

    public DistrictDTO(String district_name, BigDecimal value_district_m2) {
        this.district_name = district_name;
        this.value_district_m2 = value_district_m2;
    }

    public static DistrictDTO converte(District district){
        return new DistrictDTO(
                district.getName(),
                district.getValueM2()
        );
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public BigDecimal getValue_district_m2() {
        return value_district_m2;
    }

    public void setValue_district_m2(BigDecimal value_district_m2) {
        this.value_district_m2 = value_district_m2;
    }
}
