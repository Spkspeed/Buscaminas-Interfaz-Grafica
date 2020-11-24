package com.javi.Buscaminas;

import com.javi.Get.GetsAndPostsOfTheAPIREST;
import com.javi.ProjectoFinal.MineSquare;

public class Main {
    public static void main(String[] args) throws Exception{
        Ventana prueba = new Ventana();
        
        GetsAndPostsOfTheAPIREST pruebaArray = new GetsAndPostsOfTheAPIREST();
        MineSquare[][] matriz = pruebaArray.getGameGrid();
        if(matriz.length > 15 || matriz[0].length > 15){
            System.out.println("ERROR: LA CUADRICULA NO PUEDE TENER MAS DE 15 FILAS O DE 15 COLUMNAS");
            System.out.println("ERROR: LA CUADRICULA NO PUEDE TENER MAS DE 15 FILAS O DE 15 COLUMNAS");
            System.out.println("ERROR: LA CUADRICULA NO PUEDE TENER MAS DE 15 FILAS O DE 15 COLUMNAS");
            System.out.println("ERROR: LA CUADRICULA NO PUEDE TENER MAS DE 15 FILAS O DE 15 COLUMNAS");
        } else{
            prueba.setVisible(true);
        }
    }
}

