package br.com.mercadolivre.bootcamp.desafio_quality.model.entities;

import java.math.BigDecimal;

public class District {

    private String name;
    private BigDecimal valueM2;

    public District() {
    }

    public District(String name, BigDecimal valueM2) {
        this.name = name;
        this.valueM2 = valueM2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValueM2() {
        return valueM2;
    }

    public void setValueM2(BigDecimal valueM2) {
        this.valueM2 = valueM2;
    }
}
