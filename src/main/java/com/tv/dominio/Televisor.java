package com.tv.dominio;

public class Televisor {

    // Atributos (datos) en minuscula. tipos de datos: fundamentales (primitivos) y derivados.

    public String marca;
    public String color;
    public float tamano;
    public String serial;
    public String resolucion;
    public byte volumen;
    public boolean encendido;
    public int canalActual;

    // Metodos (operaciones que manipulan los datos) primera en minuscula y segunda en mayuscula:

    public void subirVolumen() {
        if (this.volumen < 100) {
            this.volumen++;
        }
    }

    public void bajarVolumen() {
        if (this.volumen > 0) {
            this.volumen--;
        }
    }

    public void encender() {
        if (this.encendido == false) { // que diferencia hay entre tener este metodo y tener ambos
            this.encendido = true;
        } else {
            this.encendido = false;
        }
    }

    /*public void apagar() {
        this.encendido = false;
    }*/

    public void cambiarCanal(int nuevoCanal) {
        if (this.canalActual != nuevoCanal) {
            this.canalActual = nuevoCanal;
        }
    }

    public String obtenerInfoCanalSwitch() {
        String nombreCanal = null;

        switch (this.canalActual) {
            case 5:
                nombreCanal = "Teleantioquia";
                break;
            default:
                nombreCanal = "NO SE :(";
        }
        return "El canal actual es " + nombreCanal;
    }

    public String obtenerInfoCanal() {
        String nombreCanal = null;

        if (this.canalActual == 5) {
            nombreCanal = "Teleantioquia";
        } else {
            nombreCanal = "NO IDENTIFICADO";
        }
        return "El canal actual es " + nombreCanal;
    }

}






