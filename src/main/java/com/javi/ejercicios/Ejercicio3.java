package com.javi.ejercicios;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String args[]){
        String oracion = "";
        String confirmacion = "";
        int num_caracteres = 0, incrementador = 0, b = 0, c = 0, d = 0, f = 0, contadordepalindromos = 0;
        
        Scanner entrada = new Scanner(System.in);

        System.out.print("Escriba una oracion: ");
        System.out.println("(La oracion debe tener punto final)");
        oracion = entrada.nextLine();

        num_caracteres = oracion.length();
        
        
        
        for(int i = 0; i <= (num_caracteres - 1); i++){
            c = oracion.charAt(i);
            
            if(oracion.charAt(i) == ' ' || oracion.charAt(i) == '.'){
                confirmacion = oracion.substring((i - f),i);
                
                char palabra[] = new char[confirmacion.length()];
                
                for(int j = 0; (j <= confirmacion.length() - 1); j++){
                       palabra[d] = confirmacion.charAt(j);
                       d++;
                       
                }
                System.out.println(palabra);
                System.out.println(confirmacion);
                d = 0;
                f = -1;
                if(confirmacion.equals(palabra)){
                    System.out.println("funciono");
                }
            }
            f++;
        }
    }
}