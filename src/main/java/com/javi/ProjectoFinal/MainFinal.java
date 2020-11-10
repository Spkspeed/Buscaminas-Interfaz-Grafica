package com.javi.ProjectoFinal;

import com.google.gson.Gson;

public class MainFinal {
    public static void main(String[] args) {
        Gson g = new Gson();
        VentanaFinal prueba = new VentanaFinal();
        //prueba.setVisible(true);
        
        System.out.println(g.toJson(prueba));
    }
}
