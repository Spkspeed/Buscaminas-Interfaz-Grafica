package com.javi.Buscaminas;

import com.javi.Get.GetsAndPostsOfTheAPIREST;
import com.javi.ProjectoFinal.MineSquare;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Ventana extends JFrame{

    JPanel panelControl = new JPanel();
    JLabel etiqueta1 = new JLabel();
    JLabel etiqueta2 = new JLabel();
    JButton comenzar = new JButton();

    JButton boton1 = new JButton();
    JButton boton2 = new JButton();
    JButton boton3 = new JButton();
    JButton boton4 = new JButton();
    JButton boton5 = new JButton();
    JButton boton6 = new JButton();
    JButton boton7 = new JButton();
    JButton boton8 = new JButton();
    JButton boton9 = new JButton();
    JButton boton10 = new JButton();
    JButton boton11 = new JButton();
    JButton boton12 = new JButton();
    JButton boton13 = new JButton();
    JButton boton14 = new JButton();
    JButton boton15 = new JButton();
    JButton boton16 = new JButton();
    JButton boton17 = new JButton();
    JButton boton18 = new JButton();
    JButton boton19 = new JButton();
    JButton boton20 = new JButton();

    public Ventana() throws Exception{
        setTitle("Buscaminas");
        setSize(435, 465);
        //setLocation(int,int); //establece la posicion incial de la ventana
        //setBounds(100,200,500,500); //para establecer primero el tamaño de la ventana y luego la ubicacion
        setLocationRelativeTo(null); //establecemos la ventana en el centro de la pantalla
        //setResizable(false); //establecemos si se puede modificar el tamaño de la ventana
        setMinimumSize(new Dimension(435, 465)); //establecemos el tamaño minimo de esta ventana
        //this.getContentPane().setBackground(Color.blue); //para darle color a la ventana

        iniciarComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE); // para que le programa termine al tocar la X
    }

    private void iniciarComponentes() throws Exception{
        establecerPanel();
        establecerBotones();
        establecerEtiquetas();
        eventos();

    }

    private void establecerPanel() throws Exception{
        panelControl = new JPanel(); //creacion de un panel
        panelControl.setBackground(Color.YELLOW); //apra darle color al panel
        this.getContentPane().add(panelControl); //agregamos el panel a la ventana
        panelControl.setLayout(null);
        panelControl.setSize(50, 50); //para que sirve?
    }

    private void establecerBotones() throws Exception{
        comenzar = new JButton();
        comenzar.setBounds(160, 10, 100, 50);
        comenzar.setText("Reiniciar");
        panelControl.add(comenzar);

        GetsAndPostsOfTheAPIREST pruebaArray = new GetsAndPostsOfTheAPIREST();

        MineSquare prueba = new MineSquare();


        for(int i = 0; i<=20; i++){
            for (int j = 0; j<=20; j++){

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

    private void eventos() {
        ActionListener fallo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControl.setBackground(Color.red); //apra darle color al panel
                etiqueta1.setBackground(Color.RED);
                etiqueta2.setBackground(Color.RED);
                etiqueta1.setText("¡Fallaste!");
                etiqueta2.setText("");
                boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                boton5.setEnabled(false);
                boton6.setEnabled(false);
                boton7.setEnabled(false);
                boton8.setEnabled(false);
                boton9.setEnabled(false);
                boton10.setEnabled(false);
                boton11.setEnabled(false);
                boton12.setEnabled(false);
                boton13.setEnabled(false);
                boton14.setEnabled(false);
                boton15.setEnabled(false);
                boton16.setEnabled(false);
                boton17.setEnabled(false);
                boton18.setEnabled(false);
                boton19.setEnabled(false);
                boton20.setEnabled(false);
            }
        };

        ActionListener botonA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControl.setBackground(Color.BLUE); //apra darle color al panel
                etiqueta2.setBackground(Color.BLUE);
                etiqueta2.setText("¡Bien!");
                etiqueta1.setBackground(Color.BLUE);
                etiqueta1.setText("");
                boton2.setEnabled(false);
            }
        };
        ActionListener botonB = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControl.setBackground(Color.BLUE); //apra darle color al panel
                etiqueta2.setBackground(Color.BLUE);
                etiqueta2.setText("¡Bien!");
                etiqueta1.setBackground(Color.BLUE);
                etiqueta1.setText("");
                boton4.setEnabled(false);
            }
        };
        ActionListener botonC = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControl.setBackground(Color.BLUE); //apra darle color al panel
                etiqueta2.setBackground(Color.BLUE);
                etiqueta2.setText("¡Bien!");
                etiqueta1.setBackground(Color.BLUE);
                etiqueta1.setText("");
                boton5.setEnabled(false);
            }
        };
        ActionListener botonD = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControl.setBackground(Color.BLUE); //apra darle color al panel
                etiqueta2.setBackground(Color.BLUE);
                etiqueta2.setText("¡Bien!");
                etiqueta1.setBackground(Color.BLUE);
                etiqueta1.setText("");
                boton6.setEnabled(false);
            }
        };
        ActionListener botonE = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControl.setBackground(Color.BLUE); //apra darle color al panel
                etiqueta2.setBackground(Color.BLUE);
                etiqueta2.setText("¡Bien!");
                etiqueta1.setBackground(Color.BLUE);
                etiqueta1.setText("");
                boton8.setEnabled(false);
            }
        };
        ActionListener botonF = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControl.setBackground(Color.BLUE); //apra darle color al panel
                etiqueta2.setBackground(Color.BLUE);
                etiqueta2.setText("¡Bien!");
                etiqueta1.setBackground(Color.BLUE);
                etiqueta1.setText("");
                boton9.setEnabled(false);
            }
        };
        ActionListener botonG = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControl.setBackground(Color.BLUE); //apra darle color al panel
                etiqueta2.setBackground(Color.BLUE);
                etiqueta2.setText("¡Bien!");
                etiqueta1.setBackground(Color.BLUE);
                etiqueta1.setText("");
                boton10.setEnabled(false);
            }
        };
        ActionListener botonH = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControl.setBackground(Color.BLUE); //apra darle color al panel
                etiqueta2.setBackground(Color.BLUE);
                etiqueta2.setText("¡Bien!");
                etiqueta1.setBackground(Color.BLUE);
                etiqueta1.setText("");
                boton11.setEnabled(false);
            }
        };
        ActionListener botonI = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControl.setBackground(Color.BLUE); //apra darle color al panel
                etiqueta2.setBackground(Color.BLUE);
                etiqueta2.setText("¡Bien!");
                etiqueta1.setBackground(Color.BLUE);
                etiqueta1.setText("");
                boton12.setEnabled(false);
            }
        };
        ActionListener botonJ = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControl.setBackground(Color.BLUE); //apra darle color al panel
                etiqueta2.setBackground(Color.BLUE);
                etiqueta2.setText("¡Bien!");
                etiqueta1.setBackground(Color.BLUE);
                etiqueta1.setText("");
                boton13.setEnabled(false);
            }
        };
        ActionListener botonK = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControl.setBackground(Color.BLUE); //apra darle color al panel
                etiqueta2.setBackground(Color.BLUE);
                etiqueta2.setText("¡Bien!");
                etiqueta1.setBackground(Color.BLUE);
                etiqueta1.setText("");
                boton15.setEnabled(false);
            }
        };
        ActionListener botonM = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControl.setBackground(Color.BLUE); //apra darle color al panel
                etiqueta2.setBackground(Color.BLUE);
                etiqueta2.setText("¡Bien!");
                etiqueta1.setBackground(Color.BLUE);
                etiqueta1.setText("");
                boton16.setEnabled(false);
            }
        };
        ActionListener botonN = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControl.setBackground(Color.BLUE); //apra darle color al panel
                etiqueta2.setBackground(Color.BLUE);
                etiqueta2.setText("¡Bien!");
                etiqueta1.setBackground(Color.BLUE);
                etiqueta1.setText("");
                boton17.setEnabled(false);
            }
        };
        ActionListener botonO = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControl.setBackground(Color.BLUE); //apra darle color al panel
                etiqueta2.setBackground(Color.BLUE);
                etiqueta2.setText("¡Bien!");
                etiqueta1.setBackground(Color.BLUE);
                etiqueta1.setText("");
                boton18.setEnabled(false);
            }
        };
        ActionListener botonP = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControl.setBackground(Color.BLUE); //apra darle color al panel
                etiqueta2.setBackground(Color.BLUE);
                etiqueta2.setText("¡Bien!");
                etiqueta1.setBackground(Color.BLUE);
                etiqueta1.setText("");
                boton19.setEnabled(false);
            }
        };

        ActionListener reiniciar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControl.setBackground(Color.YELLOW); //apra darle color al panel
                etiqueta1.setBackground(Color.YELLOW);
                etiqueta1.setText("");
                etiqueta2.setBackground(Color.YELLOW);
                etiqueta2.setText("");
                boton1.setEnabled(true);
                boton2.setEnabled(true);
                boton3.setEnabled(true);
                boton4.setEnabled(true);
                boton5.setEnabled(true);
                boton6.setEnabled(true);
                boton7.setEnabled(true);
                boton8.setEnabled(true);
                boton9.setEnabled(true);
                boton10.setEnabled(true);
                boton11.setEnabled(true);
                boton12.setEnabled(true);
                boton13.setEnabled(true);
                boton14.setEnabled(true);
                boton15.setEnabled(true);
                boton16.setEnabled(true);
                boton17.setEnabled(true);
                boton18.setEnabled(true);
                boton19.setEnabled(true);
                boton20.setEnabled(true);
            }
        };

        comenzar.addActionListener(reiniciar);
        boton1.addActionListener(fallo);
        boton3.addActionListener(fallo);
        boton7.addActionListener(fallo);
        boton14.addActionListener(fallo);
        boton20.addActionListener(fallo);
        boton2.addActionListener(botonA);
        boton4.addActionListener(botonB);
        boton5.addActionListener(botonC);
        boton6.addActionListener(botonD);
        boton8.addActionListener(botonE);
        boton9.addActionListener(fallo);
        boton10.addActionListener(botonG);
        boton11.addActionListener(botonH);
        boton12.addActionListener(fallo);
        boton13.addActionListener(botonJ);
        boton15.addActionListener(botonK);
        boton16.addActionListener(fallo);
        boton17.addActionListener(botonN);
        boton18.addActionListener(botonO);
        boton19.addActionListener(botonP);
    }
}
