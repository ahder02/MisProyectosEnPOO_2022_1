package Taller1.dispensador.app;

import Taller1.dispensador.dominio.DispensadorDeSnacks;
import Taller1.dispensador.dominio.Snack;
import com.dispensadorAgua.dominio.DispensadorDeAgua;

public class AppDispensadorSnacks {
    public static void main(String[] args) {
        DispensadorDeSnacks dispensador = new DispensadorDeSnacks();
        Snack snackDePrueba1 = new Snack("Papitas de pollo", 02, 2000.0, (short) 2);
        Snack snackDePrueba2 = new Snack("No estoy", 07, 2000.0, (short) 2);

        dispensador.agregar("Doritos", 01, 2500.0, (short) 4);
        dispensador.agregar("Papitas de pollo", 02, 2000.0, (short) 2);
        dispensador.agregar("Coca-Cola", 03, 3000.0, (short) 6);
        dispensador.agregar("Barra Tosh", 04, 1500.0, (short) 3);
        dispensador.agregar("Chocolatina Jumbo", 05, 2800.0, (short) 10);
        dispensador.agregar("Choquis", 05, 2800.0, (short) 0);

        System.out.println("----- IMPRIMIR SNACKS AGREGADOS ----- ");
        dispensador.imprimirDispensador();

        System.out.println("----- SACAR UN SNACK POR CODIGO ----- ");
        dispensador.sacarPorCodigo(03);

        System.out.println("----- IMPRIMIR CANTIDAD DEL SNACK SACADO ----- ");
        dispensador.obtenerCantidad("Coca-Cola");

        System.out.println("----- SACAR UN SNACK POR NOMBRE ----- ");
        dispensador.sacarPorNombre("Chocolatina Jumbo");

        System.out.println("----- IMPRIMIR CANTIDAD DEL SNACK SACADO ----- ");
        dispensador.obtenerCantidad("Chocolatina Jumbo");

        System.out.println("----- AUMENTAR CANTIDAD ----- ");
        dispensador.aumentarCantidad("Barra Tosh", 04, (short) 8);

        System.out.println("\n----- IMPRIMIR CANTIDAD DEL SNACK AGREGADO ----- ");
        dispensador.obtenerCantidad("Barra Tosh");

        System.out.println("----- QUITAR SNACK ----- ");
        dispensador.quitar(snackDePrueba1);
        dispensador.quitar(snackDePrueba2);

        System.out.println("----- IMPRIMIR CANTIDAD DEL SNACK QUITADO ----- ");
        dispensador.obtenerCantidad(snackDePrueba1.getNombre());
        dispensador.obtenerCantidad(snackDePrueba2.getNombre());

        System.out.println("----- OBTENER SNACKS AGOTADOS ----- ");
        dispensador.obtenerAgotados().forEach(c -> System.out.println(c));

        System.out.println("----- OBTENER NOMBRE Y CANTIDAD DE LOS SNACKS DEL DISPENSADOR ----- ");
        dispensador.obtenerInventario().forEach(c -> System.out.println(c));

        System.out.println("----- OBTENER DISPENSADOR ORDENADO DE MAYOR A MENOR VALOR ----- ");
        dispensador.obtenerValorMayorAMenor().forEach(c -> System.out.println(c.getNombre() + " "
                + c.getCodigo() + " " + c.getValor() + " " + c.getCantidadDeUnidades()));

        System.out.println("----- OBTENER DISPENSADOR ORDENADO DE MENOR A MAYOR ----- ");
        dispensador.obtenerCantidadMenorAMayor().forEach(c -> System.out.println(c.getNombre() + " "
                + c.getCodigo() + " " + c.getValor() + " " + c.getCantidadDeUnidades()));
    }
}
