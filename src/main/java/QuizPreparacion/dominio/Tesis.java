package QuizPreparacion.dominio;

public class Tesis extends Recurso implements Copiable {
    @Override
    public void fotocopiar() {
        this.setCopias(this.getCopias()+1);
    }
}
