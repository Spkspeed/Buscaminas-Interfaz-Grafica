package com.javi.Buscaminas;

import com.javi.Get.GetsAndPostsOfTheAPIREST;
import com.javi.ProjectoFinal.MineSquare;
import com.javi.ProjectoFinal.SquareState;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Ventana extends JFrame {

    JPanel panelControl = new JPanel();
    JLabel etiqueta1 = new JLabel();
    JLabel etiqueta2 = new JLabel();
    JButton comenzar = new JButton();

    GetsAndPostsOfTheAPIREST pruebaArray = new GetsAndPostsOfTheAPIREST();
    MineSquare[][] matriz = pruebaArray.getGameGrid();
    JButton[][] boton = new JButton[matriz.length][matriz[0].length];

    public Ventana() throws Exception {
        setTitle("Buscaminas");
        setSize(435, 465);
        //setLocation(int,int); //establece la posicion incial de la ventana
        //setBounds(100,200,500,500); //para establecer primero la ubicacion y luego el tamaño
        setLocationRelativeTo(null); //establecemos la ventana en el centro de la pantalla
        //setResizable(false); //establecemos si se puede modificar el tamaño de la ventana
        setMinimumSize(new Dimension(435, 465)); //establecemos el tamaño minimo de esta ventana
        //this.getContentPane().setBackground(Color.blue); //para darle color a la ventana

        iniciarComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE); // para que le programa termine al tocar la X
    }

    private void iniciarComponentes() throws Exception {
        establecerPanel();
        establecerBotones();
        //establecerEtiquetas();
    }

    private void establecerPanel() throws Exception {
        panelControl = new JPanel(); //creacion de un panel
        panelControl.setBackground(Color.YELLOW); //apra darle color al panel
        this.getContentPane().add(panelControl); //agregamos el panel a la ventana
        panelControl.setLayout(null);
        panelControl.setSize(50, 50); //para que sirve?
    }

    private void establecerBotones() throws Exception {
        comenzar = new JButton();
        comenzar.setBounds(160, 10, 100, 50);
        comenzar.setText("Reiniciar");
        //panelControl.add(comenzar);



        int x = 10, y = 10, ancho = 45, alto = 45;
        SquareState obj = null;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                boton[i][j] = new JButton();
                boton[i][j].setBounds(x,y,ancho,alto);
                panelControl.add(boton[i][j]);
                x += 45;
            }
            y += 45;
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
}
