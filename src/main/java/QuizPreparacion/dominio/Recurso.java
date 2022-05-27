package QuizPreparacion.dominio;

public abstract class Recurso {
    private boolean prestado;
    private String nombre;
    private int copias;

    public boolean getPrestado() {
        return prestado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCopias() {
        return copias;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }
}
