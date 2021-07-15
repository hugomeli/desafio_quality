package br.com.mercadolivre.bootcamp.desafio_quality.model.DTO;

import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.Room;

public class LargestRoomDTO {
    private String name;
    private double width;
    private double length;
    private double area;

    public LargestRoomDTO() {
    }

    public LargestRoomDTO(String name, double width, double length) {
        this.name = name;
        this.width = width;
        this.length = length;
        this.area = width * length;
    }

    public static LargestRoomDTO converte(Room room){
        return new LargestRoomDTO(
                room.getName(),
                room.getWidth(),
                room.getLength()
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return area;
    }

}
