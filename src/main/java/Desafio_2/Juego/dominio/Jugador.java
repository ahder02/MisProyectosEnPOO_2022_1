package Desafio_2.Juego.dominio;

public class Jugador {
    private String nombre;
    private int ganadas;
    private int empates;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.ganadas = 0;
        this.empates = 0;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGanadas(int ganadas) {
        this.ganadas = ganadas;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public String getNombre() {
        return nombre;
    }

    public int getGanadas() {
        return ganadas;
    }

    public int getEmpates() {
        return empates;
    }
}
