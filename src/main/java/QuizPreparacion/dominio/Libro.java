package QuizPreparacion.dominio;

public class Libro extends Recurso implements Copiable, Prestable {
    @Override
    public void fotocopiar() {

    }

    @Override
    public void prestar() {
        this.setPrestado(true);
    }

    @Override
    public void devolver() {
        this.setPrestado(false);
    }
}
