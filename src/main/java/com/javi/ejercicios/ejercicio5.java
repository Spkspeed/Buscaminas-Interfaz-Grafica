package com.javi.ejercicios;

import java.util.Scanner;

/**
 * Arrays: Para almacenar una palabra con primitivos hay que usar los Arrays
 * Primitivos y arrays:
 *      int, int[], char, char[], boolean, boolean[], long, float, etc...
 * Objetos y arrays:
 *      Integer[], String[], Boolean, Long, Float, BigDecimal...
 *
 * Listas
 *      Padres(List, Set, Map) -> Hijos(HashMap, ConcurrencyMap, HashSet, ArraySet, ArrayList, VectorList, etc...)
 * POO
 * 1.- Propiedad de igualdad de un objeto se define con los metodos (.equals .hashCode)
 *     1.1.- Objeto String para compararlo con otro String se utilizo el metodo equals
 */
public class ejercicio5{

    public static void main(String args[]){

        Scanner entrada = new Scanner(System.in);

        System.out.print("Escriba una palabra: ");
        String palabra = entrada.nextLine();

        int incrementador = 0;
        char palabraInversa[] = new char[palabra.length()];

        for(int i = (palabra.length() - 1); i >= 0; i--) {
   
        }

        String resultado = new String(palabraInversa);
        System.out.println("El resultado es : "+ resultado);


        if(palabra.equals(resultado)){
            
        } else {
           
        }
    }
}