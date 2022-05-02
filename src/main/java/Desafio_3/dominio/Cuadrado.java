package Desafio_3.dominio;

public class Cuadrado extends FiguraGeometrica {
    private int lado1;
    private int lado2;

    public Cuadrado(int lado1, int lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    @Override
    public double calcularArea() {
        return lado1 * lado2;
    }

    @Override
    public double calcularPerimetro() {
        return (lado1 * 2) + (lado2 * 2);
    }

    @Override
    public String toString() {
        return "Cuadrado";
    }
}
