package com.mutantes.Mutantes.service.imple;

import java.util.Optional;

import com.mutantes.Mutantes.dto.StatsResponse;
import com.mutantes.Mutantes.model.Stats;
import com.mutantes.Mutantes.repository.MutanteRepository;
import com.mutantes.Mutantes.service.MutanteService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MutanteServiceImpl implements MutanteService{

    private final MutanteRepository mutanteRepository;


    @Override
    public boolean validarMutante(String[] adn) {
        
        char[][] matrix = convertirStringaChar(adn);
        boolean isHuman = true;

        //Implementar el codigo
        //horizontales
        String letra = "";
        String letraAnterior = "";
        String letraSiguiente ="";
        int palabra = 0;
        int PalabraEncontrada = 0;
        int longitud = matrix[0].length;
        for (int i = 0; i < longitud; i++){
            for (int j = 0; j < longitud; j++){
                letra = Character.toString(matrix[i][j]).toLowerCase();
                if (letra.equals(letraAnterior) ){
                    palabra = palabra + 1;
                    if(palabra == 3){
                        PalabraEncontrada = PalabraEncontrada + 1;
                        palabra = 0;
                    }
                }else{
                    palabra = 0;
                }
                letraAnterior = letra; 
            }
            letraAnterior = "";
        }

        //Vertical
        boolean recorrer = true;
        for(int i = 0; i < longitud; i++){
            int iAux = i;
            for(int j = 0; j < longitud; j++){
                letra = Character.toString(matrix[i][j]);
                while(recorrer){
                    iAux = iAux +1;
                    if(iAux < longitud){
                        letraSiguiente = Character.toString(matrix[iAux][j]).toLowerCase();
                    }else{
                        recorrer = false;
                        palabra = 0;
                    }
                    if(letra.equals(letraSiguiente)){
                        palabra = palabra + 1;
                        if(palabra == 3){
                            PalabraEncontrada = PalabraEncontrada + 1;
                            palabra = 0;
                            recorrer = false;
                        }
                    }else{
                        palabra = 0;
                        recorrer = false;
                    }
                    letra = letraSiguiente;
                }
                recorrer = true;
                iAux = i;
            }
        }

        //Diagonales
        
        //fin implementacion

        //Guardar datos
        Stats stats = mutanteRepository.findById(1L).get();
        
        if(isHuman){
            stats.setHumano(stats.getHumano() + 1);
        } else {
            stats.setMutante(stats.getMutante() + 1);
        }
        
        mutanteRepository.save(stats);

        return isHuman;
    }

    @Override
    public StatsResponse estadistica() {
        Stats stats = mutanteRepository.findById(1L).get();

        StatsResponse estadiResponse = StatsResponse.builder()
                                                    .conteoHumanos(stats.getHumano())
                                                    .conteoMuntantes(stats.getMutante())
                                                    .ratio(stats.getMutante()/stats.getHumano())
                                                    .build();

        return estadiResponse;
    }
    

    public static char[][] convertirStringaChar(String[] adn){
        char[][] matrix = null;
        try {
            int row     = 0,
            column  = 0;

            row = adn.length;
            column = adn[0].length();
        
            matrix = new char[row][column];

            for (int i = 0; i < row; i++) {
                String data = adn[i].toUpperCase();
                for (int j = 0; j < column; j++) {
                    matrix[i][j] = data.charAt(j);
                }
            }
        } catch (Exception e) {
            return null;
        }
        
        return matrix;
    }

    @Override
    public String validarLetras(String[] adn) {
        String mensaje = "";
        try {
            int filas = adn.length;
            int columnas = adn[0].length();
            if(filas != columnas){
                mensaje ="Las matriz debe ser NxN";
                return mensaje;
            }
        } catch (Exception e) {
            mensaje ="Las matriz debe ser NxN";
            return mensaje;
        }
       
        

        //validar letas de la matriz
        char[][] matrix = convertirStringaChar(adn);
        int longitud = matrix[0].length;
        for (int i = 0; i < longitud; i++){
            for (int j = 0; j < longitud; j++){
               String letra = Character.toString(matrix[i][j]).toLowerCase();
               if(!letra.equals("a")||!letra.equals("t")||!letra.equals("c")||!letra.equals("g")){
                    mensaje = "Solo se permiten las letras A, T, C, G";
               }
            }
        }
        return mensaje;
    }


    
}
