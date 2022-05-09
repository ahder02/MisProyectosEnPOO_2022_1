package Desafio_3_Facturacion.dominio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FacturaVencida extends Factura {
    public static final int VLR_DIA_VENCIDO = 10000;

    public FacturaVencida(String cliente, long valor, LocalDate fechaVencimiento) {
        super(cliente, valor, fechaVencimiento);
    }

    @Override
    public long calcularTotal() {
        return this.getValor() + (VLR_DIA_VENCIDO * getDiasVencidos());
    }

    public int getDiasVencidos() { // retorna dias en funcion del dia inicial y el dia final
        if (this.getFechaVencimiento().isBefore(LocalDate.now()))
            return (int) ChronoUnit.DAYS.between(this.getFechaVencimiento(), LocalDate.now());
        else
            return 0;
    }
}