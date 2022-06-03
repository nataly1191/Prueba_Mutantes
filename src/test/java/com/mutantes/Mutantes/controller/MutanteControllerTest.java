package com.mutantes.Mutantes.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.print.attribute.standard.Media;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mutantes.Mutantes.dto.StatsResponse;
import com.mutantes.Mutantes.service.MutanteService;

import net.bytebuddy.implementation.bytecode.Throw;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MutantesController.class)
public class MutanteControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MutanteService mutanteService;


    StatsResponse statsResponse = StatsResponse.
                                    builder().
                                    conteoHumanos(2).
                                    conteoMuntantes(1).
                                    build();

    @Test
    public void validarMutanteTest() throws Exception{
        String[] adn = {"ATGCGA",
                        "CAGTGC",
                        "TATTGT",
                        "ATAAGG",
                        "CCCCTA",
                        "TCACTG"};
        mockMvc.perform(
            post("/mutant", 1L)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsBytes(adn))
        ).andExpect(status().isForbidden());    
    }

    @Test
    public void consultarStatsTest() throws Exception{

        when(mutanteService.estadistica()).thenReturn(statsResponse);

        mockMvc.perform(
            get("/stats", 1L)
            .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$.conteoMuntantes").value(1));    
    }
}
