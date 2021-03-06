package Desafio_2.Calculadora.dominio;

import org.jetbrains.annotations.NotNull;
import java.util.List;

public class Calculadora {
    // Método auxiliar para redondear el resultado de cada operación
    private static double redondear(boolean redondear, double resultado){
        if (redondear) // Aplica el redondeo del resultado
            return Math.round(resultado);
        else
            return resultado;
    }

    public static double sumar(@NotNull List<Double> numerosAOperar, boolean redondear){
        double resultado = numerosAOperar.stream().mapToDouble(n -> n).sum();
        return redondear(redondear, resultado);
    }

    public static double restar(@NotNull List<Double> numerosAOperar, boolean redondear){
        double resultado = numerosAOperar.stream().mapToDouble(nro -> nro)
                .reduce((left, right) -> left - right).getAsDouble();
        return redondear(redondear, resultado);
    }

    public static double multiplicar(@NotNull List<Double> numerosAOperar, boolean redondear){
        double resultado = numerosAOperar.get(0);
        for (int i = 1; i < numerosAOperar.size(); i++)
            resultado = resultado * numerosAOperar.get(i);
        return redondear(redondear, resultado);
    }

    public static double dividir(@NotNull List<Double> numerosAOperar, boolean redondear){
        double resultado = numerosAOperar.get(0);
        for (int i = 1; i < numerosAOperar.size(); i++) {
            resultado = resultado/numerosAOperar.get(i);
        }
        return redondear(redondear, resultado);
    }
}