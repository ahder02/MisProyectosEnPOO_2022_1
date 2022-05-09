package Desafio_3_Facturacion.dominio;

import java.time.LocalDate;


public class FacturaConIVA extends Factura{
    public static final short valorIVA = 19;

    public FacturaConIVA(String cliente, long valor, LocalDate fechaVencimiento) {
        super(cliente, valor, fechaVencimiento);
    }

    public long calcularIva() {
        return this.getValor() * valorIVA / 100;
    }

    @Override
    public long calcularTotal() {
        return this.getValor() + calcularIva();
    }
}
