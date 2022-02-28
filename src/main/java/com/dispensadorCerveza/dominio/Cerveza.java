package com.dispensadorCerveza.dominio;

public class Cerveza {
    public String marca;
    public double porcAlcohol;

    public Cerveza(String marca) {
        this.marca = marca;
    }

    public Cerveza(String marca, double gradoAlcohol) {
        this.marca = marca;
        this.porcAlcohol = gradoAlcohol;
    }
}
