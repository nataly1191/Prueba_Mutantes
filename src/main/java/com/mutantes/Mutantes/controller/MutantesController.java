package com.mutantes.Mutantes.controller;

import com.mutantes.Mutantes.dto.AdnRequest;
import com.mutantes.Mutantes.dto.StatsResponse;
import com.mutantes.Mutantes.service.MutanteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MutantesController {

    @Autowired
    private MutanteService mutanteService;
    
    @PostMapping("/mutant")
    public ResponseEntity<?> validarMutante(@RequestBody AdnRequest adn){
        try {
            String mensaje = mutanteService.validarLetras(adn.getAdn());
            if(mensaje.equals("")){
            boolean isHumano = mutanteService.validarMutante(adn.getAdn());
            if(isHumano){
                return new ResponseEntity<>("Humano", HttpStatus.FORBIDDEN);
            } else {
                return new ResponseEntity<>("Mutante", HttpStatus.OK);
            }
        }else {
            return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
        }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<?> consultarStats(){
        try {
            StatsResponse respuesta = mutanteService.estadistica();
            if(respuesta != null ){
                return new ResponseEntity<>(respuesta, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Humano", HttpStatus.FORBIDDEN);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

