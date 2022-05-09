package Desafio_3_Facturacion.dominio;

import java.time.LocalDate;

public class FacturaConDescuento extends FacturaConIVA{
    public static final short porcDescuento = 30;
    public FacturaConDescuento(String cliente, long valor, LocalDate fechaVencimiento) {
        super(cliente, valor, fechaVencimiento);
    }

    public long calcularDescuento() {
        return porcDescuento * this.getValor()/100;
    }

    @Override
    public long calcularTotal() {
        return super.calcularTotal() + calcularDescuento();
    }
}
