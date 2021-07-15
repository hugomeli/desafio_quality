package br.com.mercadolivre.bootcamp.desafio_quality.model.forms;


import org.springframework.validation.annotation.Validated;

import java.util.List;


public class PropertyFormDTO {

    private String prop_name;
    private String prop_district;
    private List<RoomFormDTO> rooms;

    public PropertyFormDTO() {
    }

    public PropertyFormDTO(String prop_name, String prop_district, List<RoomFormDTO> rooms) {
        this.prop_name = prop_name;
        this.prop_district = prop_district;
        this.rooms = rooms;
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

    public List<RoomFormDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomFormDTO> rooms) {
        this.rooms = rooms;
    }
}
