package com.dispensadorCerveza.dominio;

public class DispensadorDeCerveza {
    public String marca;
    public double capacidad;
    public double cantidadActual;
    public Cerveza cerveza;
    
    public DispensadorDeCerveza(String marca, double capacidad) {
        this.marca = marca;
        this.capacidad = capacidad;
    }
    
    public boolean sevir(double cantidadAservir) {
        if (cantidadAservir <= cantidadActual) {
            this.cantidadActual -= cantidadAservir;
            System.out.println("Se ha servido!");
            System.out.println("Quedan " + this.cantidadActual + " de cerveza " + this.cerveza.marca);
            return true;
        }

        System.out.println("No hay cantidad suficiente de Cerveza.");
        return false;
    }

    public void cambiarCerveza(Cerveza nuevaCerveza) {
        this.vaciar();
        this.cerveza = nuevaCerveza;
        this.llenar();
    }

    public void llenar() {
        this.cantidadActual = this.capacidad;
        System.out.println("Se ha llenado con " + this.cerveza.marca);
    }

    public void vaciar() {
        this.cantidadActual = 0;
        System.out.println("Se ha vaciado el dispensador.");
    }
}
