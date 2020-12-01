package com.javi.Buscaminas;

import com.javi.Get.GetsAndPostsOfTheAPIREST;
import com.javi.ProjectoFinal.MineSquare;
import com.javi.ProjectoFinal.SquareState;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Ventana extends JFrame implements ActionListener {

    JPanel panelControl = new JPanel();
    JLabel etiqueta1 = new JLabel();
    JLabel etiqueta2 = new JLabel();
    JButton comenzar = new JButton();

    JLabel uno = new JLabel();
    JLabel dos = new JLabel();
    JLabel tres = new JLabel();
    JLabel cuatro = new JLabel();
    JLabel cinco = new JLabel();
    JLabel seis = new JLabel();
    JLabel siete = new JLabel();
    JLabel ocho = new JLabel();

    JLabel cuadriculaImagen = new JLabel();

    GetsAndPostsOfTheAPIREST pruebaArray = new GetsAndPostsOfTheAPIREST();
    MineSquare[][] matriz = pruebaArray.getGameGrid();
    SquareState estadoMina;
    JButton[][] boton = new JButton[matriz.length][matriz[0].length];
    int matrizPrincipal[][] = new int[matriz.length][matriz[0].length];
    JOptionPane avisoTexto = new JOptionPane();
    int x = 10, y = 10, ancho = 25, alto = 25;

    public Ventana() throws Exception {
        setTitle("Buscaminas");
        setSize(matriz.length * ancho + 33, matriz[0].length * alto + 55);
        //setLocation(int,int); //establece la posicion incial de la ventana
        //setBounds(100,200,500,500); //para establecer primero la ubicacion y luego el tamaño
        setLocationRelativeTo(null); //establecemos la ventana en el centro de la pantalla
        //setResizable(false); //establecemos si se puede modificar el tamaño de la ventana
        setMinimumSize(new Dimension(matriz.length * ancho + 33, matriz[0].length * alto + 55)); //establecemos el tamaño minimo de esta ventana
        //this.getContentPane().setBackground(Color.blue); //para darle color a la ventana

        iniciarComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE); // para que le programa termine al tocar la X
    }

    private void iniciarComponentes() throws Exception {
        establecerPanel();
        establecerBotones();
        //establecerEtiquetas();
        inicializarMatriz();
        mostrarUnCuadradoVacio();
    }

    private void establecerPanel() throws Exception {
        panelControl = new JPanel(); //creacion de un panel
        panelControl.setBackground(Color.YELLOW); //apra darle color al panel
        this.getContentPane().add(panelControl); //agregamos el panel a la ventana
        panelControl.setLayout(null);
        panelControl.setSize(50, 50); //para que sirve?
    }

    private void establecerBotones() throws Exception {
        comenzar = new JButton("reiniciar");
        comenzar.setBounds(160, 10, 100, 50);
        comenzar.addActionListener(this);
        //panelControl.add(comenzar);

        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {

                boton[i][j] = new JButton();
                boton[i][j].setBounds(x, y, ancho, alto);

                
                if (matriz[i][j].getSquareState().equals(estadoMina.QUESTION_MARK)) {
                    boton[i][j].setBackground(Color.blue);
                }
                
                boton[i][j].addActionListener(this);
                panelControl.add(boton[i][j]);
                x += 25;
            }
            y += 25;
            x = 10;
        }
    }

    private void establecerEtiquetas() {
        //creo los las etiquetas que tambien puedo aplicarlarle los valores como constructor
        etiqueta1 = new JLabel();
        etiqueta1.setBounds(10, 20, 125, 30); //para establecer la ubicacion de la etiqueta y cuantos pixeles dispondra
        etiqueta1.setHorizontalAlignment(SwingConstants.CENTER); //para centrar las letras en su propio fondo
        etiqueta1.setForeground(Color.BLACK); //para darle color a las letras
        etiqueta1.setFont(new Font("arial", Font.PLAIN, 30)); //establecemos el tipo de letra, estilo y tamaño
        etiqueta1.setOpaque(true); // permitimos cambiar el diseño por defecto del fondo
        etiqueta1.setBackground(Color.YELLOW); //cambiamos el color del fondo de la etiqueta
        etiqueta1.setText("");
        panelControl.add(etiqueta1); //agregamos las etiquetas al panel

        etiqueta2 = new JLabel();
        etiqueta2.setBounds(300, 20, 100, 30); //para establecer la ubicacion de la etiqueta y cuantos pixeles dispondra
        etiqueta2.setHorizontalAlignment(SwingConstants.CENTER); //para centrar las letras en su propio fondo
        etiqueta2.setForeground(Color.BLACK); //para darle color a las letras
        etiqueta2.setFont(new Font("arial", Font.PLAIN, 30)); //establecemos el tipo de letra, estilo y tamaño
        etiqueta2.setOpaque(true); // permitimos cambiar el diseño por defecto del fondo
        etiqueta2.setBackground(Color.YELLOW); //cambiamos el color del fondo de la etiqueta
        etiqueta2.setText("");
        panelControl.add(etiqueta2); //agregamos las etiquetas al panel
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (e.getSource().equals(boton[i][j])) {
                    if (matriz[i][j].getSquareMined().equals(false) && matriz[i][j].getSquareState().equals(estadoMina.NOT_REVEALED)) {
                        boton[i][j].setEnabled(false);
                        uno = new JLabel();
                        int prueba = matrizPrincipal[i][j];
                        boton[i][j].setIcon(new ImageIcon("imagenesBuscaminasSinColor/" + prueba + ".png"));
                        
                    } else if (matriz[i][j].getSquareMined().equals(true)) {
                        JOptionPane.showMessageDialog(this, "Game Over");
                        boton[i][j].setEnabled(false);
                        uno = new JLabel();
                        int prueba = matrizPrincipal[i][j];
                        boton[i][j].setIcon(new ImageIcon("imagenesBuscaminasSinColor/" + prueba + ".png"));
                    }

                }
                
            }
        }
    }

    public void inicializarMatriz() throws Exception {
        //se encarga de encontrar las minas y ubicarlas en la matriz de prueba con un valor de -2
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j].getSquareMined().equals(true)) {
                    matrizPrincipal[i][j] = -2;
                }
            }
        }
        //para incrementar el valor de los cuadrados alrededor de una mina
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matrizPrincipal[i][j] == -2) {
                    //hacia arriba
                    if (i > 0 && matrizPrincipal[i - 1][j] != -2) {
                        matrizPrincipal[i - 1][j]++;
                    }
                    //hacia abajo
                    if (i < matriz.length - 1 && matrizPrincipal[i + 1][j] != -2) {
                        matrizPrincipal[i + 1][j]++;
                    }
                    // hacia izquierda
                    if (j > 0 && matrizPrincipal[i][j - 1] != -2) {
                        matrizPrincipal[i][j - 1]++;
                    }
                    // hacia derecha
                    if (j < matriz[0].length - 1 && matrizPrincipal[i][j + 1] != -2) {
                        matrizPrincipal[i][j + 1]++;
                    }
                    //esquina superior izquierda
                    if (i > 0 && j > 0 && matrizPrincipal[i - 1][j - 1] != -2) {
                        matrizPrincipal[i - 1][j - 1]++;
                    }
                    //esquina inferior izquierda
                    if (i < matriz.length - 1 && j > 0 && matrizPrincipal[i + 1][j - 1] != -2) {
                        matrizPrincipal[i + 1][j - 1]++;
                    }
                    //esquina superior derecha
                    if (i > 0 && j < matriz[0].length - 1 && matrizPrincipal[i - 1][j + 1] != -2) {
                        matrizPrincipal[i - 1][j + 1]++;
                    }
                    //esquina inferior derecha
                    if (i < matriz.length - 1 && j < matriz[0].length - 1 && matrizPrincipal[i + 1][j + 1] != -2) {
                        matrizPrincipal[i + 1][j + 1]++;
                    }
                }
            }
        }

    }
    public void mostrarUnCuadradoVacio(){
        int prueba = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matrizPrincipal[i][j] == 0 && prueba == 0) {
                    boton[i][j].setEnabled(false);
                    uno = new JLabel();
                    int imagen = matrizPrincipal[i][j];
                    boton[i][j].setIcon(new ImageIcon("imagenesBuscaminasSinColor/" + imagen + ".png"));
                    prueba++;
                }
            }
        }
    }
}
// actualmente puedo mostrar la cuadricula y hacer que reacciones segun un valor por lo tanto
// ahora tendria que hacer que cada cuadricula se comporte segun como yo queiera
// y para eso tengo enlazar el actionPerformed con las tres matrices
// primero la matriz de botones, luego la matriz de la API y luego la que establece la cuadriula.
//
