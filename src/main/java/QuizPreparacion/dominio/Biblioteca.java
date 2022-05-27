package QuizPreparacion.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Recurso> recursos = new ArrayList<>();

    public void addRecurso(Recurso r) {
        recursos.add(r);
        System.out.println("El recurso se agregó.");
    }

    public boolean prestarRecurso(Recurso r){
        if (r instanceof Prestable){
            if (!r.getPrestado()){
                ((Prestable) r).prestar();
                System.out.println("El recurso se ha prestado.");
                return true;
            } else {
                System.out.println("El recurso ya ha sido prestado.");
                return false;
            }
        } else {
            System.out.println("El recurso no se puede prestar.");
            return false;
        }
    }

    public boolean devolverRecurso(Recurso r){
        if (r instanceof Prestable){
            if (!r.getPrestado()){
                System.out.println("El recurso no está prestado.");
                return false;
            } else {
                ((Prestable) r).devolver();
                System.out.println("El recurso ha sido devuelto.");
                return true;
            }
        } else {
            System.out.println("El recurso no se puede prestar.");
            return false;
        }
    }

    public boolean fotocopiarRecurso(Recurso r){
        if (!(r instanceof Copiable)) {
            System.out.println("El recurso no es copiable");
            return false;
        } else {
            if (!r.getPrestado()){
                System.out.println("Es posible fotocopiar");
                ((Copiable) r).fotocopiar();
                return true;
            } else {
                System.out.println("No es posible fotocopiar porque está prestado");
                return false;
            }
        }

    }

    public List<Prestable> listarPrestados(){
        return this.recursos.stream()
                .filter(r -> r instanceof Prestable).map(r -> (Prestable) r)
                .collect(Collectors.toList());
    }

    public void listarCopiasPorRecurso(){
        this.recursos.stream().filter(r -> r instanceof Copiable)
                .forEach(r -> System.out.println(r.getNombre()
                + " se ha fotocopiado " + r.getCopias() + " veces.\n"));
    }
}
