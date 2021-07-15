package br.com.mercadolivre.bootcamp.desafio_quality.model.entities;

import java.util.List;

public class Property {

    private String propName;
    private District district;
    private List<Room> rooms;

    public Property() {
    }

    public Property(String propName, District district, List<Room> rooms) {
        this.propName = propName;
        this.district = district;
        this.rooms = rooms;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
