package com.javi.prototypeMineswapper.ejercicios;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String args[]){
        String oracion = "";
        String confirmacion = "";
        int num_caracteres = 0, incrementador = 0, b = 0, c = 0, d = 0, contadordepalindromos = 0;
        
        Scanner entrada = new Scanner(System.in);

        System.out.print("Escriba una oracion: ");
        oracion = entrada.nextLine();

        num_caracteres = oracion.length();
        
        char palabra[] = new char[oracion.length()];
        char palabraInversa[] = new char[confirmacion.length()];
        int i = 0;
        while(i <= (num_caracteres - 1)){
            palabra[incrementador] = oracion.charAt(i);
            if(i == ' '){
                i--;
                confirmacion = oracion.substring((i - incrementador),i);
                
                for(int j = 0; j <= (confirmacion.length() - 1); j++) {
                  palabraInversa[d] = confirmacion.charAt(j);
                  d++;
                 }
                if(confirmacion.equals(palabraInversa)){
                    contadordepalindromos++;
                    System.out.println("Funciono");
                }
                incrementador = 0;
            }
          i++;
          b++;
        }
        System.out.println(contadordepalindromos);
        
    }
}