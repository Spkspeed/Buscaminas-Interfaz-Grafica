package com.javi.Buscaminas;

import com.javi.servicioDeConexionConLaAPI.GetsAndPostsOfTheAPIREST;
import com.javi.estructura.MineSquare;

public class Main {
    public static void main(String[] args) throws Exception{
        Ventana prueba = new Ventana();
        
        GetsAndPostsOfTheAPIREST pruebaArray = new GetsAndPostsOfTheAPIREST();
        MineSquare[][] matriz = pruebaArray.getGameGrid();
        if(matriz.length > 50 || matriz[0].length > 50){
            System.out.println("ERROR: LA CUADRICULA NO PUEDE TENER MAS DE 15 FILAS O DE 50 COLUMNAS");
            System.out.println("ERROR: LA CUADRICULA NO PUEDE TENER MAS DE 15 FILAS O DE 50 COLUMNAS");
            System.out.println("ERROR: LA CUADRICULA NO PUEDE TENER MAS DE 15 FILAS O DE 50 COLUMNAS");
            System.out.println("ERROR: LA CUADRICULA NO PUEDE TENER MAS DE 15 FILAS O DE 50 COLUMNAS");
        } else{
            prueba.setVisible(true);
        }
    }
}

