package com.dispensadorAgua.dominio;

public class Agua {
    public String proveedor;
    public String tipoDeGasificacion;
    public String sabor;

    public Agua(String proveedor) {this.proveedor = proveedor;}
    public Agua(String proveedor, String tipoDeGasificacion) {
        this.proveedor = proveedor;
        this.tipoDeGasificacion = tipoDeGasificacion;
    }
    public Agua(String proveedor, String tipoDeGasificacion, String sabor) {
        this.proveedor = proveedor;
        this.tipoDeGasificacion = tipoDeGasificacion;
        this.sabor = sabor;
    }
}
