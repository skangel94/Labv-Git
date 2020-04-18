package com.utn;

public class BeerProducter extends Thread {
    private String productorNombre;
    private BeerHouse cerveceria;

    public BeerProducter(String productorNombre, BeerHouse cerveceria) {
        super();
        this.productorNombre = productorNombre;
        this.cerveceria = cerveceria;
    }

    public String getProductorNombre() {
        return productorNombre;
    }

    public void setProductorNombre(String productorNombre) {
        productorNombre = productorNombre;
    }

    public BeerHouse getCerveceria() {
        return cerveceria;
    }

    public void setCerveceria(BeerHouse cerveceria) {
        this.cerveceria = cerveceria;
    }

    //METODOS

    //Devuelve un número aleatorio entre 1 y 100
    public int cervezasAProducir(){
        return (int) (Math.random() * 100) + 1;
    }

    //Envía centidad de cervezas a la cervecería
    public void producirCerveza(){
        int cntCervezas = cervezasAProducir();
        this.cerveceria.setCerveza(cntCervezas);
        System.out.println("El productor "+ this.getProductorNombre()+" entrego un total de " +cntCervezas+ " a la cerveceria " + this.cerveceria.getNombreCerveceria());
    }

    public void run() {
        while(this.cerveceria.isDisponible()){
            this.producirCerveza();
        }
        System.out.println("La cervecería superó el límite disponible");
    }

}
