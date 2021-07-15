package br.com.mercadolivre.bootcamp.desafio_quality.model.DTO;

import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RoomSquareDTO {
    private String name;
    private double width;
    private double length;
    private double area;

    public RoomSquareDTO() {
    }

    public RoomSquareDTO(String name, double width, double length) {
        this.name = name;
        this.width = width;
        this.length = length;
        this.area = width * length;
    }

    public static RoomSquareDTO converte(Room room){
        return new RoomSquareDTO(
                room.getName(),
                room.getWidth(),
                room.getLength()
        );
    }

    public static List<RoomSquareDTO> converte(List<Room> rooms){
        return rooms.stream().map(RoomSquareDTO::converte).collect(Collectors.toList());
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

    public void setArea(double area) {
        this.area = area;
    }
}
