package Desafio_3.dominio;

public class TrianguloRectangulo extends FiguraGeometrica {
    private double cateto1;
    private double cateto2;
    private double hipotenusa;

    public TrianguloRectangulo(double cateto1, double cateto2) {
        this.cateto1 = cateto1;
        this.cateto2 = cateto2;
        this.hipotenusa = Math.sqrt(Math.pow(cateto1,2) + Math.pow(cateto2,2));
    }

    @Override
    public double calcularArea() {
        return (this.cateto1 * this.cateto2)/2;
    }

    @Override
    public double calcularPerimetro() {
        return this.cateto1 + this.cateto2 + this.hipotenusa;
    }

    @Override
    public String toString() {
        return "Triangulo Rectangulo";
    }
}
