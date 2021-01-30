package com.javi.ejercicios;

import java.util.Scanner;

public class Ejercicio6v2 {

    public static void main(String args[]) {
        String oracion = "";
        String confirmacion = "";
        int num_caracteres = 0, incrementador = 0, contadordepalindromos = 0;
        int longitudPalabraInvertida = 0;

        Scanner entrada = new Scanner(System.in);

        System.out.println("-----------------------------------");
        System.out.println("¡LA ORACION DEBE TENER PUNTO FINAL!");
        System.out.println("-----------------------------------");

        for (int ars = 1; ars >= 1; ars++) {
            System.out.print("Escriba una oracion: ");
            oracion = entrada.nextLine();
            num_caracteres = oracion.length();

            /*
        //metodo para verificar el utlimo caracter utilizando primitivos
        char[] oracionArray = oracion.toCharArray();
        int posicionFinalOracion = oracionArray.length;
        if (oracionArray[posicionFinalOracion - 1] != '.') {
            System.out.println("La oracion no tiene punto final");
        }
        //metodo  para verificar el ultimo caracter utilizando un objeto
        if (!oracion.endsWith(".")) {
            System.out.println("La oracion no tiene punto final");
        }
             */
            //el signo "!" sirve para realizar la inversa de la base en la que se lleva a cabo una operacion
            // al usar doble comilla estoy usando un objeto String y cuando uso doble apostrofe estoy usando un Char
            // al usar un metodo equals debo devolver un String ("")
            if (!oracion.substring(num_caracteres - 1, num_caracteres).equals(".")) {
                ars = 1;
                System.out.println("-----------------------------------");
                System.out.println("LA ORACION NO TIENE PUNTO FINAL");
                System.out.println("-----------------------------------");

            } else {
                ars = -1;
                //en este caso no utilzare este array para guardar caracteres sino por para utilizarlo como un contador de caracteres
                char palabra[] = new char[oracion.length()];
                //se inicia con un bucle que terminara al llegar hasta el ultimo caracter de la oracion escrita
                for (int i = 0; i <= (num_caracteres - 1); i++) {
                    //utilizo el incrementador para contar cuantos caracteres tiene una palabra.
                    palabra[incrementador] = oracion.charAt(i);
                    //una estructura condicional que
                    if (oracion.charAt(i) == ' ' || oracion.charAt(i) == '.') {
                        //el ((i - incrementador), i) nos posiciona desde el lugar donde se empezo a escribir la palabra hasta donde se encontro el ultimo espacio o punto final.
                        confirmacion = oracion.substring((i - incrementador), i);
                        //una vez obtenido la palabra con el metodo anterior se guarda la cantidad de caracteres que posee la palabra
                        longitudPalabraInvertida = confirmacion.length();
                        //se crea un atributo con valor a decidir y automaticamente volvera a tener el valor a decidir al repetirse el proceso.
                        String palabraInvertida = "";
                        //utilizo este bucle para escribir la palabra obtenida al revez
                        while (longitudPalabraInvertida != 0) {
                            //utilizo el atributo con el signo de acumulacion "+="
                            //el substring utilizado logra abarcar apartir del ultimo caracter de la palabra hasta la primera.
                            palabraInvertida += confirmacion.substring(longitudPalabraInvertida - 1, longitudPalabraInvertida);
                            //decremento continuo necesario para que la anterior operacion funcione correctamente
                            longitudPalabraInvertida--;
                        }
                        //estructura condicional que se activa al detectar una palabra palindromo
                        if (confirmacion.equals(palabraInvertida)) {
                            //al detectar que una palabra es palindroma aumenta su valor
                            contadordepalindromos++;

                            //ajusta el conteo de palindromos cuando se encuentra un solo caracter.
                            if (palabraInvertida.length() == 1) {

                                contadordepalindromos--;
                            } else {
                                System.out.println("(" + confirmacion + ")" + " y " + "(" + palabraInvertida + ")");
                            }
                        }
                        //el incrementador es llevado al valor "-1" para que coincida en el siguiente conteo
                        incrementador = -1;
                    }
                    //el incrementador es llevado al valor "0" y de este forma vuelva a contar cuantos caracteres posee una palabra
                    incrementador++;
                }
                System.out.println("La cantidad de palindromos encontrados es de: " + contadordepalindromos);
            }
        }
    }
}