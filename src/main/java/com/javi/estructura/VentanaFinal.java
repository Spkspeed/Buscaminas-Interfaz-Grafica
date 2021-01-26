package com.javi.estructura;

import java.awt.Dimension;
import javax.swing.JFrame;


public class VentanaFinal extends JFrame{
    public VentanaFinal() {
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
    
    private void iniciarComponentes() {
        
    }
}
