package com.javi.Buscaminas;

import com.javi.Get.GetsAndPostsOfTheAPIREST;
import com.javi.estructura.MineSquare;
import com.javi.estructura.SquareState;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Ventana extends JFrame implements ActionListener, MouseListener {

    JPanel panelControl = new JPanel();
    JLabel etiqueta1 = new JLabel();
    JLabel etiqueta2 = new JLabel();
    JButton comenzar = new JButton();

    JLabel uno = new JLabel();

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
        setSize(matriz.length * ancho + 37, matriz[0].length * alto + 65);
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
        inicializarMatriz();
        establecerBotones();

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
        x = 10;
        y = 10;
        ancho = 25;
        alto = 25;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                boton[i][j] = new JButton();
                boton[i][j].setBounds(x, y, ancho, alto);
                if (matriz[i][j].getSquareState().equals(estadoMina.QUESTION_MARK)) {
                    boton[i][j].setBackground(Color.black);
                } else if (matriz[i][j].getSquareState().equals(estadoMina.RED_MARK)){
                    boton[i][j].setBackground(Color.red);
                } else if (matriz[i][j].getSquareState().equals(estadoMina.REVEALED)){
                    if(matriz[i][j].getSquareMined().equals(true)){
                        boton[i][j].setEnabled(false);
                        int prueba = matrizPrincipal[i][j];
                        boton[i][j].setIcon(new ImageIcon("imagenesBuscaminasSinColor/" + prueba + ".png"));
                    } else if (matriz[i][j].getSquareMined().equals(false)){
                        boton[i][j].setEnabled(false);
                        int prueba = matrizPrincipal[i][j];
                        boton[i][j].setIcon(new ImageIcon("imagenesBuscaminasSinColor/" + prueba + ".png"));
                    }
                }
                boton[i][j].addActionListener(this);
                boton[i][j].addMouseListener(this);
                boton[i][j].setVisible(true);
                panelControl.add(boton[i][j]);
                x += 25;
            }
            y += 25;
            x = 10;
        }
        for (int refresh1 = 0; refresh1 < matriz.length; refresh1++){
            for (int refresh2 = 0; refresh2 < matriz[0].length; refresh2++){
                boton[refresh1][refresh2].validate();
                boton[refresh1][refresh2].repaint();
            }
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
                    if (matriz[i][j].getSquareMined().equals(false)) {
                        boton[i][j].setEnabled(false);
                        matriz[i][j].setSquareState(estadoMina.REVEALED);
                        int prueba = matrizPrincipal[i][j];
                        boton[i][j].setIcon(new ImageIcon("imagenesBuscaminasSinColor/" + prueba + ".png"));
                        try {
                            pruebaArray.getSquareReveal(j,i);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        for (int borrador1 = 0; borrador1 < matriz.length; borrador1++){
                            for (int borrador2 = 0; borrador2 < matriz[0].length; borrador2++){
                                boton[borrador1][borrador2].setVisible(false);
                            }
                        }
                        try {
                            setMatrizDeLaApi(pruebaArray.getGameGrid());
                            x = 10;
                            y = 10;
                            ancho = 25;
                            alto = 25;
                            iniciarComponentes();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    } else if (matriz[i][j].getSquareMined().equals(true)) {
                        JOptionPane.showMessageDialog(this, "Game Over");
                        boton[i][j].setEnabled(false);
                        matriz[i][j].setSquareState(estadoMina.REVEALED);
                        uno = new JLabel();
                        int prueba = matrizPrincipal[i][j];
                        boton[i][j].setIcon(new ImageIcon("imagenesBuscaminasSinColor/" + prueba + ".png"));
                        try {
                            pruebaArray.getSquareReveal(j,i);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
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
                } else if (matriz[i][j].getSquareMined().equals(false)){
                    matrizPrincipal[i][j] = 0;
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

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = 10, y = 10;
        if (SwingUtilities.isRightMouseButton(e)){
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if (e.getSource().equals(boton[i][j])) {
                        //si la mina esta con la marca negra, con el siguiente click izquierdo la transforma en estado normal sin revelar
                        if (matriz[i][j].getSquareState().equals(estadoMina.QUESTION_MARK)){
                            boton[i][j].setVisible(false);
                            boton[i][j] = new JButton();
                            boton[i][j].setBounds(x, y, ancho, alto);
                            boton[i][j].addActionListener(this);
                            boton[i][j].setVisible(true);
                            matriz[i][j].setSquareState(estadoMina.NOT_REVEALED);
                            boton[i][j].addMouseListener(this);
                            panelControl.add(boton[i][j]);
                            try {
                                pruebaArray.getSquareNotRevealMark(j,i);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                            //para hacer que la cuadricula se borre (desabilite) y poder poner otra adecuadamente
                            for (int borrador1 = 0; borrador1 < matriz.length; borrador1++){
                                for (int borrador2 = 0; borrador2 < matriz[0].length; borrador2++){
                                    boton[borrador1][borrador2].setVisible(false);
                                }
                            }
                            //ejecuta de nuevo la aplicacion para se traiga la cuadricula actualizada
                            try {
                                setMatrizDeLaApi(pruebaArray.getGameGrid());
                                iniciarComponentes();
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                            //si el estado de la marca es normal la transforma en marca roja
                        } else if (matriz[i][j].getSquareState().equals(estadoMina.NOT_REVEALED)){
                            matriz[i][j].setSquareState(estadoMina.RED_MARK);
                            boton[i][j].setBackground(Color.red);
                            try {
                                pruebaArray.getRedMark(j,i);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                            //para hacer que la cuadricula se borre (desabilite) y poder poner otra adecuadamente
                            for (int borrador1 = 0; borrador1 < matriz.length; borrador1++){
                                for (int borrador2 = 0; borrador2 < matriz[0].length; borrador2++){
                                    boton[borrador1][borrador2].setVisible(false);
                                }
                            }
                            //ejecuta de nuevo la aplicacion para se traiga la cuadricula actualizada
                            try {
                                setMatrizDeLaApi(pruebaArray.getGameGrid());
                                iniciarComponentes();
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                            //cuando se clickea una marka roja la transforma en question mark
                        } else if (matriz[i][j].getSquareState().equals(estadoMina.RED_MARK)){
                            matriz[i][j].setSquareState(estadoMina.QUESTION_MARK);
                            boton[i][j].setBackground(Color.black);
                            try {
                                pruebaArray.getQuestionMark(j,i);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                            //funcion ya explicada
                            for (int borrador1 = 0; borrador1 < matriz.length; borrador1++){
                                for (int borrador2 = 0; borrador2 < matriz[0].length; borrador2++){
                                    boton[borrador1][borrador2].setVisible(false);
                                }
                            }
                            try {
                                setMatrizDeLaApi(pruebaArray.getGameGrid());
                                iniciarComponentes();
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                    x += 25;
                }
                y += 25;
                x = 10;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        panelControl.validate();
        panelControl.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public void setMatrizDeLaApi(MineSquare[][] matriz){this.matriz = matriz;}
}
// actualmente puedo mostrar la cuadricula y hacer que reacciones segun un valor por lo tanto
// ahora tendria que hacer que cada cuadricula se comporte segun como yo queiera
// y para eso tengo enlazar el actionPerformed con las tres matrices
// primero la matriz de botones, luego la matriz de la API y luego la que establece la cuadriula.
//
