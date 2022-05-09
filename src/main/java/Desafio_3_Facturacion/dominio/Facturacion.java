package Desafio_3_Facturacion.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Facturacion { // >100mil factura con iva, <100mil sin iva
    private List<Factura> facturas = new ArrayList<>();
    private Factura facturaMasCara;

    public void generarFactura(String cliente, long valor, LocalDate fecha){
        Factura facturaActual = null;

        if (fecha.isBefore(LocalDate.now()))
            facturaActual = new FacturaVencida(cliente, valor, fecha);
        else {
            if (valor >= 100000) {
                if ("aeiouAEIOU".indexOf(cliente.charAt(0)) != -1)
                    facturaActual = new FacturaConDescuento(cliente, valor, fecha);
                else
                    facturaActual = new FacturaConIVA(cliente, valor, fecha);
            } else
                facturaActual = new FacturaSinIVA(cliente, valor, fecha);
        }
        facturas.add(facturaActual);
    }

    public long getTotalFacturacion(){
        //facturas.forEach(facturaActual -> totalFacturacion += facturaActual.getValor());
        return facturas.stream().mapToLong(facturaActual -> facturaActual.calcularTotal()).sum();
    }

    public Factura getFacturaMasCara(){
        return facturas.stream().max(Comparator.comparing(Factura::calcularTotal)).orElse(null);
    }

    public List<FacturaSinIVA> getFacturasSinIva() {
        return this.facturas.stream()
                .filter(facturaActual -> facturaActual instanceof FacturaSinIVA)
                .map(facturaActual -> (FacturaSinIVA) facturaActual)
                .collect(Collectors.toList());
    }

    public List<FacturaConDescuento> getFacturasConDescuento() {
        return this.facturas.stream()
                .filter(facturaActual -> facturaActual instanceof FacturaConDescuento)
                .map(facturaActual -> (FacturaConDescuento) facturaActual)
                .collect(Collectors.toList());
    }
}
