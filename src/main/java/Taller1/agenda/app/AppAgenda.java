package Taller1.agenda.app;

import Taller1.agenda.dominio.Agenda;

public class AppAgenda {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        agenda.agregar("Georgina", "Ronaldo", 3113776458l);
        agenda.agregar("Ana", "Bedoya", 3219000174l);
        agenda.agregar("Berenice", "Zuluaga", 3219316174l);
        agenda.agregar("Carlos", "Mattos", 3002587496l);
        agenda.agregar("Carlos", "Maderos", 3022587496l);
        agenda.agregar("Alejandro", "Ramirez", 3104698710l);
        agenda.agregar("Yeison", "Ramirez", 3104696510l);

        System.out.println("----- IMPRIMIR CONTACTOS INGRESADOS ----- ");
        agenda.imprimirAgenda();

        System.out.println("----- EDITAR UN CONTACTO ----- ");
        agenda.editarCelular(3104698710l, 3110008796l);

        System.out.println("----- ORDENAR ALFABÉTICAMENTE ----- ");
        agenda.ordenarAlfabeticamente();

        System.out.println("----- IMPRIMIR CONTACTOS ORDENADOS ALFABETICAMENTE ----- ");
        agenda.imprimirAgenda();

        System.out.println("----- BUSCAR POR NOMBRE ----- ");
        agenda.buscarPorNombre("Carlos").forEach(c -> System.out
                .println(c.getNombre() + " " + c.getApellido() + " - " + c.getCelular()));
        //agenda.buscarPorNombre("Miguel").forEach(c -> System.out
          //      .println(c.getNombre() + " " + c.getApellido() + " - " + c.getCelular()));

        System.out.println("----- BUSCAR POR APELLIDO ----- ");
        agenda.buscarPorApellido("Ramirez").forEach(c -> System.out
                .println(c.getNombre() + " " + c.getApellido() + " - " + c.getCelular()));

        System.out.println("----- BUSCAR POR CELULAR ----- ");
        agenda.buscarPorCelular(3104696510l).forEach(c -> System.out
                .println(c.getNombre() + " " + c.getApellido() + " - " + c.getCelular()));

        System.out.println("----- ELIMINAR ----- ");
        agenda.eliminar(3002587496l);

        System.out.println("----- IMPRIMIR AGENDA FINAL ----- ");
        agenda.imprimirAgenda();
    }
}
