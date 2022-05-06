package Desafio_3_Facturacion.dominio;

public abstract class Factura {
    String cliente;
    long valor;

    public Factura(String cliente, long valor) {
        this.cliente = cliente;
        this.valor = valor;
    }

    public abstract long calcularTotal();
}
