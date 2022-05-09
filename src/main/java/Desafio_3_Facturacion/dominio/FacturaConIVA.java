package Desafio_3_Facturacion.dominio;

import java.time.LocalDate;

import static Desafio_3_Facturacion.app.AppFacturacion.valorIVA;

public class FacturaConIVA extends Factura{
    public FacturaConIVA(String cliente, long valor, LocalDate fechaVencimiento) {
        super(cliente, valor, fechaVencimiento);
    }

    public long calcularIva() {
        return this.getValor() * valorIVA / 100;
    }

    @Override
    public long calcularTotal() {
        return this.getValor() + (valorIVA * this.getValor())/100;
    }
}
