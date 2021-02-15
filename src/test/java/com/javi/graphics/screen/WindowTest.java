package com.javi.graphics.screen;

import com.javi.service.ApiConnectionService;
import com.javi.squaresProperties.MineSquare;

import static org.junit.Assert.assertThat;

public class WindowTest{
    public static void main(String[] args) throws Exception {

        ApiConnectionService service = new ApiConnectionService();
        service.PostCreateGame("1");

        Window prueba = new Window();

        ApiConnectionService pruebaArray = new ApiConnectionService();
        MineSquare[][] matriz = pruebaArray.getGameGrid();
        if (matriz.length > 50 || matriz[0].length > 50) {
            System.out.println("ERROR: LA CUADRICULA NO PUEDE TENER MAS DE 15 FILAS O DE 50 COLUMNAS");
        } else {
            prueba.setVisible(true);
        }
    }

}