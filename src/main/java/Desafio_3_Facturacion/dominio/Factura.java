package Desafio_3_Facturacion.dominio;

import java.time.LocalDate;

public abstract class Factura {
    private String cliente;
    private long valor;
    private LocalDate fechaVencimiento;

    public Factura(String cliente, long valor, LocalDate fechaVencimiento) {
        this.cliente = cliente;
        this.valor = valor;
        this.fechaVencimiento = fechaVencimiento;
    }

    public abstract long calcularTotal();

    public String getCliente() {
        return cliente;
    }

    public long getValor() {
        return valor;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    @Override
    public String toString() {
        return this.cliente;
    }
}
