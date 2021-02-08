package com.javi.ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Tareas {
    static int count = 0;

    public static void main(String[] args) {
        String[] array = {"abc","2","10","0","1","3","4","5","1pato","22","21"};
        List<String> list = Arrays.asList(array);
        Collections.sort(list);
        System.out.println(Arrays.toString(array));
    }
    public void tarea1(){
        if(count < 3){
            count++;
            main(null);
        } else{
            return;
        }
        System.out.println("hello world");
    }
    public void tarea4(){
        int a = 1, b = 0, c = a / b;
        System.out.println(c);
    }
    public void tarea5(){
        double a = Math.PI;
        System.out.println(a);

    }
    public void tarea9(){
        String menssage = "hello";

        for(int i = 0; i<menssage.length();i++){
            System.out.println(menssage.charAt(i+1));
        }
    }
    public void tarea10(){
        System.out.println("ninfty" instanceof String);
    }

    public void tarea11(){
        try {
            System.out.println("Hello World");
        }catch (Exception e){
            System.out.println("e");
        //}catch (ArithmeticException e){
        //    System.out.println("e");
        }finally {
            System.out.println("!");
        }
    }
    public void tarea12(){
        int x = 5;
        x=10;
        System.out.println(x);
    }
    //tarea13 wtf is: Object message(){ return "hello":}
    //tarea17 System.out.println(Integer.parseInt("21") + 1);
     //tarea22 char smooch = 'x';
     //        System.out.println((int)smooch);

    public void tarea22(){
        List<Boolean> list = new ArrayList<>();
        list.add(true);
        list.add(Boolean.parseBoolean("False"));
        list.add(Boolean.TRUE);
        System.out.println(list.size());
        System.out.println(list.get(1) instanceof Boolean);
    }

    public void tarea27(){
        String[] array = {"abc","2","10","0","1","3","4","5","1pato","22","21"};
        List<String> list = Arrays.asList(array);
        Collections.sort(list);
        System.out.println(Arrays.toString(array));
    }
}

