package Desafio_3_Facturacion.dominio;

import java.util.ArrayList;
import java.util.List;

public class Facturacion { // >100mil factura con iva, <100mil sin iva
    public long totalFacturacion;
    private Factura facturaMasCara;
    List<Factura> facturas = new ArrayList<>();

    public void generarFactura(String cliente, long valor){
        Factura facturaActual;

        if (valor >= 100000)
            facturaActual = new FacturaConIVA(cliente, valor);
        else
            facturaActual = new FacturaSinIVA(cliente, valor);

        facturaActual.valor = facturaActual.calcularTotal();
        facturas.add(facturaActual);
    }

    public long getTotalFacturacion(){
        facturas.forEach(facturaActual -> totalFacturacion += facturaActual.valor);
        return totalFacturacion;
    }

    public Factura getFacturaMasCara(){
        facturas.forEach(facturaActual -> {
            if (facturaActual.valor >= facturaMasCara.valor)
               facturaMasCara = facturaActual;
        });
        return facturaMasCara;
    }
}
