package Desafio_2.Juego.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Juego {
    public static final String instruccionesDelJuego = "Este juego consta de 2 participantes: tu y la computadora.\n" +
            "Tienes la posibilidad de elegir entre Viento, Arbol y Tierra, sabiendo que cada uno tiene" +
            " superioridad respecto a otro, por ejemplo el Viento es superior al Arbol, el Arbol a la Tierra " +
            "y la Tierra al Viento.\nCada vez que se oprima una de las tres opciones, el que sea superior " +
            "sumara un punto, y el acumulado puede ser consultado en la opcion de \"ver resultados\".";
    public static final ArrayList<String> opcionesDelJuego = new ArrayList<>(Arrays
            .asList("Viento", "Arbol", "Tierra"));

    public static String opcionAleatoria(List<String> opcionesDelJuego) {
        Random random = new Random();
        return opcionesDelJuego.get(random.nextInt(opcionesDelJuego.size()));
    }

    public static int partida(String opcionElegida, String opcionAleatoria) {
        if (opcionElegida == opcionAleatoria) return 0;
        else if (opcionElegida == "Viento" && opcionAleatoria == "Arbol") return 1;
        else if (opcionElegida == "Arbol" && opcionAleatoria == "Tierra") return 1;
        else if (opcionElegida == "Tierra" && opcionAleatoria == "Viento") return 1;
        else return -1;
    }
}
