package br.com.mercadolivre.bootcamp.desafio_quality.model.DTO;

import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.Property;

import java.math.BigDecimal;

public class TotalValueDTO {

    private String prop_name;
    private String prop_district;
    private int amount_rooms;
    private BigDecimal price;

    public TotalValueDTO() {
    }

    public TotalValueDTO(String prop_name, String prop_district, int amount_rooms, BigDecimal price) {
        this.prop_name = prop_name;
        this.prop_district = prop_district;
        this.amount_rooms = amount_rooms;
        this.price = price;
    }

    public static TotalValueDTO converte(Property property, BigDecimal price){
        return new TotalValueDTO(
                property.getPropName(),
                property.getDistrict().getName(),
                property.getRooms().size(),
                price
        );
    }

    public int getAmount_rooms() {
        return amount_rooms;
    }

    public String getProp_name() {
        return prop_name;
    }

    public void setProp_name(String prop_name) {
        this.prop_name = prop_name;
    }

    public String getProp_district() {
        return prop_district;
    }

    public void setProp_district(String prop_district) {
        this.prop_district = prop_district;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
