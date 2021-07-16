package br.com.mercadolivre.bootcamp.desafio_quality.integration;


import br.com.mercadolivre.bootcamp.desafio_quality.model.forms.DistrictFormDTO;
import br.com.mercadolivre.bootcamp.desafio_quality.validations.exceptions.DistrictAlreadySavedException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import java.math.BigDecimal;
import java.util.Objects;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class DistrictControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldCreateADistrict() throws Exception{
        DistrictFormDTO formDTO = new DistrictFormDTO("Tatuape", new BigDecimal("4536.00"));

        String payload = mapper.writeValueAsString(formDTO);

        mvc.perform(post("/district/create")
                .contentType("application/json")
                .content(payload))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldNotCreateADistrictWithInvalidParameters() throws Exception{
        DistrictFormDTO formDTO = new DistrictFormDTO("", new BigDecimal("0"));

        String payload = mapper.writeValueAsString(formDTO);

        mvc.perform(post("/district/create")
                .contentType("application/json")
                .content(payload))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldNotCreateADistrictIfItAlreadyExist() throws Exception{
        DistrictFormDTO formDTO = new DistrictFormDTO("Vila Madalena", new BigDecimal("9837.00"));


        String payload = mapper.writeValueAsString(formDTO);
        String expectedExceptionMessage = "O bairro Vila Madalena já está cadastrado no sistema!";

        mvc.perform(post("/district/create")
                .contentType("application/json")
                .content(payload))
                .andExpect(status().isBadRequest())
                .andExpect(result -> Assertions.assertTrue
                        (result.getResolvedException() instanceof DistrictAlreadySavedException))
                .andExpect(result -> Assertions.assertEquals
                        (expectedExceptionMessage, Objects.requireNonNull(result.getResolvedException()).getMessage()));
    }
}
