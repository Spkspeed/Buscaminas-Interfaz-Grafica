package com.javi.TutorialDeBuscaminas;

import com.javi.servicioDeConexionConLaAPI.GetsAndPostsOfTheAPIREST;
import com.javi.estructura.MineSquare;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Juego {
    //atributos
    JFrame ventana;
    JPanel panelPresentacion;
    JLabel fondoPresentacion;
    
    //juego
    JLabel marcadoTiempo;
    JLabel marcadoBanderas;
    Timer tiempo;
    int min;
    int seg;
    int minas;
    
    
    public Juego() throws Exception{
        //ventana
        ventana = new JFrame("Buscaminas");
        ventana.setSize(650, 500);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);
        
        //jpanel presentacion
        
        panelPresentacion = new JPanel();
        panelPresentacion.setSize(ventana.getWidth(), ventana.getHeight());
        panelPresentacion.setLocation(0, 0);
        panelPresentacion.setLayout(null);
        panelPresentacion.setVisible(true);
        
        
        //fondro presentacion
        
        fondoPresentacion = new JLabel();
        fondoPresentacion.setIcon(new ImageIcon("imagenesBuscaminas/fondo.png"));
        fondoPresentacion.setBounds(0,0,panelPresentacion.getWidth(),panelPresentacion.getHeight());
        fondoPresentacion.setVisible(true);
        panelPresentacion.add(fondoPresentacion,0);
        
        
        inicializarMatriz();
        ventana.add(panelPresentacion);
        ventana.setVisible(true);
    }
    
    public void inicializarMatriz() throws Exception{
        GetsAndPostsOfTheAPIREST pruebaArray = new GetsAndPostsOfTheAPIREST();
        MineSquare[][] matriz = pruebaArray.getGameGrid();
        int matrizPrincipal[][] = new int[matriz.length][matriz[0].length];
        
        //se encarga de encontrar las minas y ubicarlas en la matriz de prueba con un valor de -2
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j].getSquareMined().equals(true)) {
                   matrizPrincipal[i][j] = -2;
                }
            }
        }
       //para incrementar el valor de los cuadrados alrededor de una mina
        for (int i = 0; i <matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matrizPrincipal[i][j] == -2) {
                    //hacia arriba
                    if (i>0 && matrizPrincipal[i-1][j]!= -2) {
                        matrizPrincipal[i-1][j]++;
                    }
                    //hacia abajo
                    if (i<matriz.length-1 && matrizPrincipal[i+1][j]!= -2 ) {
                        matrizPrincipal[i+1][j]++;
                    }
                    // hacia izquierda
                    if (j>0 && matrizPrincipal[i][j-1]!= -2) {
                        matrizPrincipal[i][j-1]++;
                    }
                    // hacia derecha
                    if (j<matriz[0].length-1 && matrizPrincipal[i][j+1]!= -2) {
                        matrizPrincipal[i][j+1]++;
                    }
                    //esquina superior izquierda
                    if (i>0 && j>0 && matrizPrincipal[i-1][j-1]!= -2) {
                        matrizPrincipal[i-1][j-1]++;
                    }
                    //esquina inferior izquierda
                    if (i<matriz.length-1 && j>0 && matrizPrincipal[i+1][j-1]!= -2) {
                        matrizPrincipal[i+1][j-1]++;
                    }
                    //esquina superior derecha
                    if (i>0 && j<matriz[0].length-1 && matrizPrincipal[i-1][j+1]!= -2) {
                        matrizPrincipal[i-1][j+1]++;
                    }
                    //esquina inferior derecha
                    if (i<matriz.length-1 && j<matriz[0].length-1 && matrizPrincipal[i+1][j+1]!= -2) {
                        matrizPrincipal[i+1][j+1]++;
                    }
                }
            }
        }
        
        //matriz principal para la cuadricula
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matrizPrincipal[i][j]);
                System.out.print("  ");
            }
            System.out.println("");
        }
    }
}
