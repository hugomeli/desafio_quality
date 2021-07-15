package br.com.mercadolivre.bootcamp.desafio_quality.model.entities;

public class Room {

    private String name;
    private double width;
    private double length;

    public Room() {
    }

    public Room(String name, double width, double length) {
        this.name = name;
        this.width = width;
        this.length = length;
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

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()){
            return false;
        }
        Room anotherRoom = (Room) obj;
        return (this.getName().equals(anotherRoom.getName())
                && this.getLength() == anotherRoom.getLength()
                && this.getWidth() == anotherRoom.getWidth());
    }
}
