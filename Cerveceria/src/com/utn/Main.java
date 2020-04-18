package com.utn;

public class Main {

    public static void main (String[] args){
        BeerHouse cerveceria= new BeerHouse(10,true,"El bar de MOE");
        Thread Productor= new Thread(new BeerProducter("Carlos", cerveceria));
        Thread Consumidor= new Thread(new BeerConsumer("Homero", cerveceria));

        Productor.start();
        Consumidor.start();
    }
}