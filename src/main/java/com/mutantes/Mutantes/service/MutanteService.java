package com.mutantes.Mutantes.service;

import com.mutantes.Mutantes.dto.StatsResponse;

public interface MutanteService {
    
    public boolean validarMutante(String[] adn);

    public StatsResponse estadistica();
}
