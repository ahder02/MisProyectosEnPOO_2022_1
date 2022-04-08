package Taller2_Calculadora.app;

import Taller2_Calculadora.dominio.Calculadora;

import javax.swing.*;
import java.util.Arrays;

public class AppCalculadora {
    public static void main(String[] args) {
        while (true) {
            JCheckBox checkBox = new JCheckBox("Redondear?");
            int operacionElegida = JOptionPane.showOptionDialog(null,
                    "Que quieres hacer?","POO", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, Arrays.asList("Sumar",
                    "Restar", "Multiplicar", "Dividir", checkBox).toArray(), "Sumar");

            Calculadora.redondear = checkBox.isSelected(); // Opción de redonéo

            if (operacionElegida == 0) { // Sumar
                Calculadora.Sumar();
            } else if (operacionElegida == 1) { // Restar
                Calculadora.Restar();
            } else if (operacionElegida == 2) { // Multiplicar
                Calculadora.Multiplicar();
            } else if (operacionElegida == 3) { // Dividir
                Calculadora.Dividir();
            } else if (operacionElegida == JOptionPane.CLOSED_OPTION) {
                break;
            } //else if (operacionElegida == JOptionPane.CANCEL_OPTION){
            //continue;
            //}
        }
    }
}
