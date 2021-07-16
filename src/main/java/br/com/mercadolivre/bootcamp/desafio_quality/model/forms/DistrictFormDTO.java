package br.com.mercadolivre.bootcamp.desafio_quality.model.forms;

import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.District;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class DistrictFormDTO {

    @NotBlank(message = "O nome do bairro não pode estar vazio.")
    @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    private String prop_name;

    @NotNull(message = "O valor do metro quadrado no bairro não pode estar vazio.")
    @Min(value = 1, message = "O valor não pode ser inferior a 1.")
    @Max(value = 999999999, message = "O valor máximo do metro quadrado é de 999999999.")
    @Digits(integer = 13, fraction = 2, message = "O valor não pode possuir mais do que 13 dígitos.")
    private BigDecimal value_district_m2;

    public DistrictFormDTO() {
    }

    public DistrictFormDTO(String prop_name, BigDecimal value_district_m2) {
        this.prop_name = prop_name;
        this.value_district_m2 = value_district_m2;
    }

    public static District converte(DistrictFormDTO districtFormDTO){
        return new District(
                districtFormDTO.getProp_name(),
                districtFormDTO.getValue_district_m2()
        );
    }

    public String getProp_name() {
        return prop_name;
    }

    public void setProp_name(String prop_name) {
        this.prop_name = prop_name;
    }

    public BigDecimal getValue_district_m2() {
        return value_district_m2;
    }

    public void setValue_district_m2(BigDecimal value_district_m2) {
        this.value_district_m2 = value_district_m2;
    }
}
