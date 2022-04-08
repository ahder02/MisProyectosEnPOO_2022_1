package Taller2_Calculadora.dominio;

import javax.swing.*;

public class Calculadora {
    public static boolean redondear;

    // Método auxiliar para mostrar mensaje de resultado de cada operación
    public static void Mensaje(double primerNumero, double segundoNumero, double resultado, String operacion, String tituloDeMensaje){
        if (redondear) // Aplica el redondeo del resultado
            resultado = Math.round(resultado);

        JOptionPane.showMessageDialog(null, primerNumero + operacion + segundoNumero
                + ") = " + resultado, tituloDeMensaje, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void Sumar(){
        double primerNumero = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el primer numero: "));
        double segundoNumero = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el segundo numero: "));
        Calculadora.Mensaje(primerNumero, segundoNumero, primerNumero + segundoNumero, " + (", "Suma");
    }

    public static void Restar(){
        double primerNumero = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el minuendo (cantidad total): "));
        double segundoNumero = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el sustraendo (cantidad a restar): "));
        Calculadora.Mensaje(primerNumero, segundoNumero, primerNumero - segundoNumero, " - (", "Resta");
    }

    public static void Multiplicar(){
        double primerNumero = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el primer numero: "));
        double segundoNumero = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el segundo numero: "));
        Calculadora.Mensaje(primerNumero, segundoNumero, primerNumero * segundoNumero, " x (", "Multiplicacion");
    }

    public static void Dividir(){
        double primerNumero = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el dividendo (cantidad total): "));
        double segundoNumero = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el divisor (cantidad que divide): "));
        Calculadora.Mensaje(primerNumero, segundoNumero, primerNumero / segundoNumero, " / (", "Division");
    }
}
