package com.javi.TutorialDeBuscaminas.ejercicios.prueba;

public class Testing {
    Object message(){
        return "hello";
    }
    public static void main(String[] args) {
        System.out.println(new Testing().message());
        System.out.println(new main2().message());
    }
}

class main2 extends Testing{
    Object message(){
        return "world";
    }
}
