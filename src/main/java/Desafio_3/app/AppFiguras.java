package Desafio_3.app;

import Desafio_3.dominio.*;

import java.util.ArrayList;
import java.util.List;

public class AppFiguras {
    public static final int ANGULOCENTRAL = 72; // 360/5 para el pentagono regular.

    public static void main(String[] args) {
        Circulo circulo = new Circulo(10);
        Cuadrado cuadrado = new Cuadrado(2, 3);
        TrianguloRectangulo trianguloRectangulo = new TrianguloRectangulo(3,4,5);
        PentagonoRegular pentagonoRegular = new PentagonoRegular(5, ANGULOCENTRAL);

        List<FiguraGeometrica> figuras = new ArrayList<>();
        figuras.add(circulo);
        figuras.add(cuadrado);
        figuras.add(trianguloRectangulo);
        figuras.add(pentagonoRegular);

        figuras.forEach(figuraGeometrica -> {
            System.out.println("El área del " + figuraGeometrica + " es: " + figuraGeometrica.calcularArea());
            System.out.println("El perímetro del " + figuraGeometrica+ " es: " + figuraGeometrica.calcularPerimetro());
        });
    }
}
