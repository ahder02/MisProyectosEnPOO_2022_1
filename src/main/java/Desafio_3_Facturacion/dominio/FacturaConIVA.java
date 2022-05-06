package Desafio_3_Facturacion.dominio;

import static Desafio_3_Facturacion.app.AppFacturacion.IVA;

public class FacturaConIVA extends Factura{

    public FacturaConIVA(String cliente, long valor) {
        super(cliente, valor);
    }

    @Override
    public long calcularTotal() {
        return this.valor + (IVA * this.valor)/100;
    }
}
