package br.com.mercadolivre.bootcamp.desafio_quality.model.forms;



import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;


public class PropertyFormDTO {

    @NotBlank(message = "O nome da propriedade não pode estar vazio.")
    @Pattern(regexp = "^[A-Z][A-Za-z0-9_ ]*$", message = "O nome da propriedade deve começar com uma letra maiúscula")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    private String prop_name;

    @NotBlank(message = "O bairro não pode estar vazio.")
    @Size(max = 45, message= "O comprimento do bairro não pode exceder 45 caracteres.")
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
