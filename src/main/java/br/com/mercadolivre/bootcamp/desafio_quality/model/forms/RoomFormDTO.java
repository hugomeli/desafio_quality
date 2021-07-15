package br.com.mercadolivre.bootcamp.desafio_quality.model.forms;

import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.Room;
import com.fasterxml.jackson.annotation.JsonSubTypes;

import javax.validation.constraints.*;
import java.util.List;
import java.util.stream.Collectors;

public class RoomFormDTO {

    @NotBlank(message = "O campo não pode estar vazio.")
    @Pattern(regexp = "^[A-Z][A-Za-z0-9_ ]*$", message = "O nome do cômodo deve começar com uma letra maiúscula.")
    @Size(max = 30, message = "O comprimento do cômodo não pode exceder 30 caracteres.")
    private String room_name;

    @NotBlank(message = "A largura do cômodo não pode estar vazia.")
    @Max(value = 25, message = "A largura máxima permitida por cômodo é de 25 metros.")
    @Min(value = 1, message = "A largura mínima é 1 metro.")
    private double room_width;

    @NotBlank(message = "O comprimento do cômodo não pode estar vazio.")
    @Max(value = 33, message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    @Min(value = 1, message = "O comprimento mínimo é 1 metro.")
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
