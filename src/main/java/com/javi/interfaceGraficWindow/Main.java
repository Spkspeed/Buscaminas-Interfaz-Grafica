package com.javi.interfaceGraficWindow;

import com.javi.service.apiConnectionService;
import com.javi.squaresProperties.MineSquare;

public class Main {
    public static void main(String[] args) throws Exception {
        Window prueba = new Window();

        apiConnectionService pruebaArray = new apiConnectionService();
        MineSquare[][] matriz = pruebaArray.getGameGrid();
        if (matriz.length > 50 || matriz[0].length > 50) {
            System.out.println("ERROR: LA CUADRICULA NO PUEDE TENER MAS DE 15 FILAS O DE 50 COLUMNAS");
        } else {
            prueba.setVisible(true);
        }
    }
}

