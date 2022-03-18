package Taller1.dispensador.dominio;

import Taller1.agenda.dominio.Contacto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class DispensadorDeSnacks {
    private List<Snack> snacks = new ArrayList<>();

    private Snack buscarPorCodigo(int codigo) {
        if (codigo >= 0){
            return this.snacks.stream().filter(c -> c
                    .getCodigo() == codigo).findFirst().orElse(null);
        } else {
            return null;
        }
    }

    private Snack buscarPorNombre(String nombre) {
        if(nombre != null){
            return this.snacks.stream().filter(s -> nombre
            .equals(s.getNombre())).findFirst().orElse(null);
        } else {
            return null;
        }
    }

    private void snackASacar(Snack snackASacar) { // saca una unidad disminuyendo la cantidad uno a uno
        if(snackASacar != null) {
            if (snackASacar.getCantidadDeUnidades() > 0) {
                int posicionAReemplazar = this.snacks.indexOf(snackASacar);
                snackASacar.setCantidadDeUnidades((short) (snackASacar.getCantidadDeUnidades() - 1));
                this.snacks.set(posicionAReemplazar, snackASacar);
                System.out.println("Se ha sacado un snack de: "
                        + snackASacar.getNombre());
            } else {
                System.out.printf("El snack esta agotado.");
            }
        } else {
            System.out.printf("No hay este snack en el dispensador.");
        }
    }

    private void aumentarCantidadPorSnack(int nuevaCantidad, Snack snackAAumentar) {
        int posicionAReemplazar = this.snacks.indexOf(snackAAumentar);
        int cantidadAReemplazar = snackAAumentar.getCantidadDeUnidades() + nuevaCantidad;
        if (snackAAumentar != null) {
            if (cantidadAReemplazar < 6) {
                snackAAumentar.setCantidadDeUnidades((short) cantidadAReemplazar);
            } else {
                snackAAumentar.setCantidadDeUnidades((short) 6);
            }
            this.snacks.set(posicionAReemplazar, snackAAumentar);
            System.out.printf("Se ha aumentado la cantidad del snack: " + snackAAumentar.getNombre());
        } else {
            System.out.printf("No hay este snack en el dispensador.");
        }
    }

    public void agregar(String nombre, int codigo, double valor, short cantidadDeUnidades) {
        if (snacks.size() < 12) {
            Snack snackAAgregar = new Snack(nombre, codigo, valor, cantidadDeUnidades);
            this.snacks.add(snackAAgregar);
            System.out.println("Se agregó el Snack " + snackAAgregar.getNombre());
            if (cantidadDeUnidades > 6) {
                snackAAgregar.setCantidadDeUnidades((short) 6);
            }
        } else {
            System.out.println("No se agregó el Snack " + nombre
                    + " porque el dispensador está lleno.");
        }
    }

    public void imprimirDispensador() {
        this.snacks.forEach(c -> System.out.println(c.getNombre() + " " + c.getCodigo()
                + " - " + c.getValor() + " - " + c.getCantidadDeUnidades()));
    }

    public void sacarPorCodigo(int codigo){
        Snack snackASacar = buscarPorCodigo(codigo);
        snackASacar(snackASacar);
    }

    public void sacarPorNombre(String nombre){
        Snack snackASacar = buscarPorNombre(nombre);
        snackASacar(snackASacar);
    }

    public void aumentarCantidad(String nombre, int codigo, int nuevaCantidad) {
        Snack snackASacar = buscarPorNombre(nombre);
        if (snackASacar.getNombre() != null) {
            Snack snackAAumentar = buscarPorNombre(nombre);
            aumentarCantidadPorSnack(nuevaCantidad, snackAAumentar);
        } else {
            Snack snackAAumentar = buscarPorCodigo(codigo);
            aumentarCantidadPorSnack(nuevaCantidad, snackAAumentar);
        }
    }

    public void quitar(Snack snackAQuitar) {
        Snack snackBuscado = buscarPorNombre(snackAQuitar.getNombre());
        if (snackBuscado != null) {
            this.snacks.remove(snackAQuitar);
            System.out.println("Se han eliminado el siguiente snack: "
                    + snackAQuitar.getNombre());
        } else {
            System.out.println("No se puede eliminar el snack: "
                    + snackAQuitar.getNombre() + ", porque no existe.");
        }
    }

    public void obtenerCantidad(String nombre) {
        Snack snackABuscar = buscarPorNombre(nombre);
        if (snackABuscar != null) {
            System.out.println("Hay " + snackABuscar.getCantidadDeUnidades()
                    + " unidades del snack: " + snackABuscar.getNombre());
        } else {
            System.out.println("El snack ingresado no existe.");
        }
    }

    public List<String> obtenerAgotados() {
        List<String> agotados = new ArrayList<>();
        this.snacks.stream()
                .filter(s -> s.getCantidadDeUnidades() == 0)
                .collect(Collectors.toList())
                .forEach(c -> agotados.add(c.getNombre()));
        return agotados;
    }

    public List<String> obtenerInventario() {
        List<String> inventario = new ArrayList<>();
        this.snacks.forEach(c -> inventario.add(c.getNombre()
                + " " + c.getCantidadDeUnidades()));
        return inventario;
    }

    public List<Snack> obtenerValorMayorAMenor() {
        List<Snack> ordenada = new ArrayList<>();
        ordenada = snacks;
        ordenada.sort(Comparator.comparing(Snack::getValor).reversed());
        return ordenada;
    }

    public List<Snack> obtenerCantidadMenorAMayor() {
        List<Snack> ordenada = new ArrayList<>();
        ordenada = snacks;
        ordenada.sort(Comparator.comparing(Snack::getCantidadDeUnidades));
        return ordenada;
    }
}
