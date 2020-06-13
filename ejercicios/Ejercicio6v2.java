package ejercicios;
import java.util.Scanner;

public class Ejercicio6v2 {
    public static void main(String args[]){
        String oracion = "";
        String confirmacion = "";
        int num_caracteres = 0, incrementador = 0, b = 0, c = 0, conteo3 = 0, conteo2 = 0, contadordepalindromos = 0;
        
        Scanner entrada = new Scanner(System.in);

        System.out.print("Escriba una oracion: ");
        System.out.println("(La oracion debe tener punto final)");
        oracion = entrada.nextLine();

        num_caracteres = oracion.length();
        
        char palabra[] = new char[oracion.length()];
        
        char palabraInversa[] = new char[oracion.length()];
        
        for(int i = 0; i <= (num_caracteres - 1); i++){
            
            palabra[incrementador] = oracion.charAt(i);
            
            if(oracion.charAt(i) == ' ' || oracion.charAt(i) == '.'){
                
                confirmacion = oracion.substring((i - incrementador),i);
                
                
                incrementador = -1;
            }
            conteo3 ++;
            incrementador++;
        }
    }
}