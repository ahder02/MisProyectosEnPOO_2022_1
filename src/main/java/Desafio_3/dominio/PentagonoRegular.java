package Desafio_3.dominio;

public class PentagonoRegular extends FiguraGeometrica{
    // La apotema (distancia del centro del pentágono al punto medio de un lado)
    // se puede calcular mediante el ángulo central.

    private double lado;
    private double apotema;

    public PentagonoRegular(double lado, double anguloCentral) {
        this.lado = lado;
        this.apotema = (lado/2*Math.tan(anguloCentral/2));
    }

    @Override
    public double calcularArea() {
        return (5 * this.lado * this.apotema)/2;
    }

    @Override
    public double calcularPerimetro() {
        return 5 * this.lado;
    }

    @Override
    public String toString() {
        return "Pentágono regular";
    }

}
