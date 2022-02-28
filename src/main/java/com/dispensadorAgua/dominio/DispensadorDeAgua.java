package com.dispensadorAgua.dominio;

public class DispensadorDeAgua {
    public String marca;
    public double capacidadDeAgua;
    public short capacidadDeHielos;
    public Agua agua;
    public double cantidadDeAguaActual;
    public short cantidadDeHielosActual;
    public short temperaturaActual;
    public boolean botonDeSuministroDeAgua;
    public boolean botonDeSuministroDeHielos;

    public DispensadorDeAgua(String marca, double capacidadDeAgua, short capacidadDeHielos) {
        this.marca = marca;
        this.capacidadDeAgua = capacidadDeAgua;
        this.capacidadDeHielos = capacidadDeHielos;
    }

    public boolean servirAgua(double cantidadDeAguaAServir) {
        if (cantidadDeAguaAServir <= this.cantidadDeAguaActual) {
            this.botonDeSuministroDeAgua = true;
            this.cantidadDeAguaActual -= cantidadDeAguaAServir;
            this.botonDeSuministroDeAgua = false;
            System.out.println("Se ha servido!");
            System.out.println("Quedan " + this.cantidadDeAguaActual + " de agua sabor a " + this.agua.sabor);
            return true;
        }
        System.out.println("No hay cantidad suficiente de Agua.");
        return false;
    }

    public void cambiarAgua(Agua nuevaAgua) {
        this.vaciarDepositoDeAgua();
        this.agua = nuevaAgua;
        this.llenarDepositoDeAgua();
        System.out.println("Se ha cambiado el agua, ahora es sabor a " + this.agua.sabor);
    }

    public boolean servirHielos(short cantidadDeHielosAServir) {
        if (cantidadDeHielosAServir <= this.cantidadDeHielosActual) {
            this.botonDeSuministroDeHielos = true;
            this.cantidadDeHielosActual -= cantidadDeHielosAServir;
            this.botonDeSuministroDeHielos = false;
            System.out.println("Se ha servido!");
            System.out.println("Quedan " + this.cantidadDeHielosActual + " hielos.");
            return true;
        }
        System.out.println("No hay cantidad suficiente de Hielos.");
        return false;
    }

    public boolean cambiarTemperatura(short nuevaTemperatura) {
        if (this.temperaturaActual != nuevaTemperatura) {
            this.temperaturaActual = nuevaTemperatura;
            System.out.println("Se ha cambiado la Temperatura a " + this.temperaturaActual + " °C.");
            return true;
        }
        System.out.println("La Temperatura permanece igual en " + this.temperaturaActual + " °C.");
        return false;
    }

    public void vaciarDepositoDeAgua() {
        this.cantidadDeAguaActual = 0;
        System.out.println("Se ha vaciado el deposito de agua.");
    }

    public void llenarDepositoDeAgua() {
        this.cantidadDeAguaActual = this.capacidadDeAgua;
        System.out.println("Se ha llenado el deposito de agua sabor a " + this.agua.sabor);
    }
}
