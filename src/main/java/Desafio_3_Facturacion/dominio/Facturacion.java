package Desafio_3_Facturacion.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Facturacion { // >100mil factura con iva, <100mil sin iva
    private List<Factura> facturas = new ArrayList<>();
    private Factura facturaMasCara;

    public void generarFactura(String cliente, long valor, LocalDate fecha){
        Factura facturaActual;

        if (fecha.isBefore(LocalDate.now()))
            facturaActual = new FacturaVencida(cliente, valor, fecha);
        else {
            if (valor >= 100000)
                facturaActual = new FacturaConIVA(cliente, valor, fecha);
            else
                facturaActual = new FacturaSinIVA(cliente, valor, fecha);
        }

        facturas.add(facturaActual);
    }

    public long getTotalFacturacion(){
        //facturas.forEach(facturaActual -> totalFacturacion += facturaActual.getValor());
        return facturas.stream().mapToLong(facturaActual -> facturaActual.calcularTotal()).sum();
    }

    public Factura getFacturaMasCara(){
        facturaMasCara = facturas.get(0);
        facturas.forEach(facturaActual -> {
            if (facturaActual.calcularTotal() >= facturaMasCara.calcularTotal())
            {facturaMasCara = facturaActual;}
        });
        return facturaMasCara;
    }

    public List<FacturaSinIVA> getFacturasSinIva() {
        return this.facturas.stream()
                .filter(facturaActual -> facturaActual instanceof FacturaSinIVA)
                .map(facturaActual -> (FacturaSinIVA) facturaActual)
                .collect(Collectors.toList());
    }
}
