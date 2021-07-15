package br.com.mercadolivre.bootcamp.desafio_quality.model.forms;

import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.Room;

import java.util.List;
import java.util.stream.Collectors;

public class RoomFormDTO {

    private String room_name;
    private double room_width;
    private double room_length;

    public RoomFormDTO() {
    }

    public RoomFormDTO(String room_name, double room_width, double room_length) {
        this.room_name = room_name;
        this.room_width = room_width;
        this.room_length = room_length;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public double getRoom_width() {
        return room_width;
    }

    public void setRoom_width(double room_width) {
        this.room_width = room_width;
    }

    public double getRoom_length() {
        return room_length;
    }

    public void setRoom_length(double room_length) {
        this.room_length = room_length;
    }

    public static Room converteRoom(RoomFormDTO roomFormDTO){
        return new Room(
                roomFormDTO.getRoom_name(),
                roomFormDTO.getRoom_width(),
                roomFormDTO.getRoom_length());
    }

    public static List<Room> converteRooms(List<RoomFormDTO> roomFormDTOS){
        return roomFormDTOS.stream()
                .map(RoomFormDTO::converteRoom)
                .collect(Collectors.toList());
    }
}
