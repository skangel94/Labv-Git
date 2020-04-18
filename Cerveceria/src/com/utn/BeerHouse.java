package com.utn;

import java.sql.SQLOutput;

public class BeerHouse {
    private int stock;
    private static int capacidad = 100;
    private boolean disponible = false;
    private String nombreCerveceria;

    public BeerHouse(int stock, boolean disponible, String nombreCerveceria) {
        this.stock = stock;
        this.disponible = disponible;
        this.nombreCerveceria = nombreCerveceria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static int getCapacidad() {
        return capacidad;
    }

    public static void setCapacidad(int capacidad) {
        BeerHouse.capacidad = capacidad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getNombreCerveceria() {
        return nombreCerveceria;
    }

    public void setNombreCerveceria(String nombreCerveceria) {
        this.nombreCerveceria = nombreCerveceria;
    }

    public synchronized void setCerveza(int cantidadCervezas){
        int stockActual = this.getStock() + cantidadCervezas;
        while(stockActual > getCapacidad()){    //Se modifica control de disponibilidad por stock
            this.setStock(getCapacidad()); //Se completa el stock con el limite disponible
            System.out.println("Por el momento el stock llego a su límite, debe consumir para producir más cervezas");
            try{
                wait();
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
        this.setStock(stockActual);
        this.setDisponible(true);
        System.out.println("Se incorporaron un total de " + cantidadCervezas + " cervezas. Nuevo stock disponible: "+stockActual);
        notifyAll();
    }

    public synchronized int getCerveza(int cerveza){
        //System.out.println("Stock actual, antes de la consumición del cliente: "+ this.getStock());
        int stockActual = this.getStock() - cerveza;
        while(stockActual <= 0){
            this.setDisponible(false);
            System.out.println("Sin stock por el momento, esperando que el productor genere cervezas.. vuelva prontos");
            try {
                wait();
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
        this.setStock(stockActual);
        System.out.println("Stock actual, luego de la consumición del cliente: "+ stockActual);
        notifyAll();
        return cerveza; //VER RETORNO...
    }

}
