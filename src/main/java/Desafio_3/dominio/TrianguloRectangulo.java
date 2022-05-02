package Desafio_3.dominio;

public class TrianguloRectangulo extends FiguraGeometrica {
    private int cateto1;
    private int cateto2;
    private int hipotenusa;

    public TrianguloRectangulo(int cateto1, int cateto2, int hipotenusa) {
        this.cateto1 = cateto1;
        this.cateto2 = cateto2;
        this.hipotenusa = hipotenusa;
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
