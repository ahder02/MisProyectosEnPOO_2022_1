package Desafio_3_Facturacion.app;

import Desafio_3_Facturacion.dominio.FacturaSinIVA;
import Desafio_3_Facturacion.dominio.Facturacion;

import java.time.LocalDate;

public class AppFacturacion {
    public static final short valorIVA = 19;

    public static void  main(String[] args){
        Facturacion facturacion = new Facturacion();

        facturacion.generarFactura("Alejandro", 99900, LocalDate.of(2022, 6, 30));
        facturacion.generarFactura("Diana", 12000, LocalDate.of(2022, 4, 30));
        facturacion.generarFactura("Jorge", 100000, LocalDate.of(2022, 1, 1));

        System.out.println("El total facturacion es: " + facturacion.getTotalFacturacion());
        System.out.println("La Factura mas cara es de: \n" + facturacion.getFacturaMasCara().toString());
        System.out.println("Las facturas sin IVA son: ");
        facturacion.getFacturasSinIva().forEach(fsi -> System.out.println(fsi.getCliente()));

    }
}
