package com.mutantes.Mutantes.repository;

import com.mutantes.Mutantes.model.Stats;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MutanteRepository extends JpaRepository<Stats, Long>{
    
   // Stats buscarPorId(long id);
}
