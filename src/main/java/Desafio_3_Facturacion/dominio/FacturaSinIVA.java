package Desafio_3_Facturacion.dominio;

import java.time.LocalDate;

public class FacturaSinIVA extends Factura {
    public FacturaSinIVA(String cliente, long valor, LocalDate fechaVencimiento) {
        super(cliente, valor, fechaVencimiento);
    }

    @Override
    public long calcularTotal() {
        return this.getValor();
    }
}
