package com.mutantes.Mutantes.service.imple;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.mutantes.Mutantes.dto.StatsResponse;
import com.mutantes.Mutantes.model.Stats;
import com.mutantes.Mutantes.repository.MutanteRepository;
import com.mutantes.Mutantes.service.MutanteService;

@SpringBootTest
public class MutantServiceTest {
    
    @Mock
    private MutanteRepository mutanteRepository;

    private MutanteService mutanteService;

    Stats stats = Stats.builder().id(1L).humano(2).mutante(1).build();

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mutanteService = new MutanteServiceImpl(mutanteRepository);
    }

    @Test
    public void validarMutanteTest(){
        String[] adn = {"ATGCGA",
                        "CAGTGC",
                        "TATTGT",
                        "ATAAGG",
                        "CCCCTA",
                        "TCACTG"};
        Optional<Stats> optionalStats = Optional.ofNullable(stats);
        Mockito.when(mutanteRepository.findById(1L)).thenReturn(optionalStats);
        boolean validar = mutanteService.validarMutante(adn);

        Assertions.assertThat(validar).isTrue();
    }

    @Test
    public void estadisticaTest() {
        Optional<Stats> optionalStats = Optional.ofNullable(stats);
        Mockito.when(mutanteRepository.findById(1L)).thenReturn(optionalStats);

        StatsResponse statsResponse = mutanteService.estadistica();
        Assertions.assertThat(statsResponse.getConteoHumanos()).isEqualTo(stats.getHumano());
    }
}
