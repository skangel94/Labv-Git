package com.utn;

public class BeerConsumer extends Thread {
    private String nombreConsumidor;
    private BeerHouse cerveceria;

    public BeerConsumer(String nombreConsumidor, BeerHouse cerveceria) {
        super();
        this.nombreConsumidor = nombreConsumidor;
        this.cerveceria = cerveceria;
    }

    public String getNombreConsumidor() {
        return nombreConsumidor;
    }

    public void setNombreConsumidor(String nombreConsumidor) {
        this.nombreConsumidor = nombreConsumidor;
    }

    public BeerHouse getCerveceria() {
        return cerveceria;
    }

    public void setCerveceria(BeerHouse cerveceria) {
        this.cerveceria = cerveceria;
    }

    //METODOS

    public int cervezasAConsumir(){
        return (int) (Math.random() * 10) + 1; //Analizar si devuelve lo esperado
    }

    public void consumirCerveza(){
        int cntCervezas=cervezasAConsumir();
        this.cerveceria.getCerveza(cntCervezas);
        System.out.println("El consumidor "+ this.getNombreConsumidor() + " consumió un total de " +cntCervezas+ " cervazas en " +this.cerveceria.getNombreCerveceria());

    }

    public void run() {
        while(this.cerveceria.isDisponible()){
            this.consumirCerveza();
        }
        System.out.println("La cervecería no cuenta con stock disponible");
    }
}
