package QuizPreparacion.dominio;

public class Revista extends Recurso implements Prestable {
    @Override
    public void prestar() {
        this.setPrestado(true);
    }

    @Override
    public void devolver() {
        this.setPrestado(false);
    }
}
