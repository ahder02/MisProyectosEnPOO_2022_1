package Taller1.dispensador.dominio;

public class Snack {

    private String nombre;
    private int codigo;
    private double valor;
    private short cantidadDeUnidades;

    public Snack(String nombre, int codigo, double valor, short cantidadDeUnidades) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.valor = valor;
        this.cantidadDeUnidades = cantidadDeUnidades;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getValor() {
        return valor;
    }

    public short getCantidadDeUnidades() {
        return cantidadDeUnidades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setCantidadDeUnidades(short cantidadDeUnidades) {
        this.cantidadDeUnidades = cantidadDeUnidades;
    }
}
