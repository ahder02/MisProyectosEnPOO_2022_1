package Desafio_2.Juego.app;

import Desafio_2.Juego.dominio.Juego;
import Desafio_2.Juego.dominio.Jugador;

import javax.swing.*;
import java.util.Arrays;

public class AppJuego {
    public static final String TITULO = "Juego";

            // -------------------------------------------
            // Viento->Arbol, Arbol->Tierra, Tierra->Viento
            // Fuego->Hielo, Hielo->Agua, Agua->Fuego
            // -------------------------------------------

    public static final int CERRAR = -1;
    public static final int INSTRUCCIONES = 0;
    public static final int JUGAR = 1;
    public static final int RESULTADOS = 2;
    public static final int EMPATES = 0;
    public static final int GANADAS = 1;

    public static Jugador nuevoJugador = new Jugador("");
    public static Jugador computadora = new Jugador("La computadora");
    //public static ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList());

    public static void main(String[] args) {
        boolean pudoCastear;
        int opcionesDelJuego = 0;
        String opcionElegida = null;
        
        nuevoJugador.setNombre(JOptionPane.showInputDialog("Ingesa tu nombre"));
        System.out.println(nuevoJugador.getNombre());
        if (nuevoJugador.getNombre().isBlank() || nuevoJugador.getNombre() == " ") {
            nuevoJugador.setNombre("Tú");
        }
        nuevoJugador.setEmpates(0);
        nuevoJugador.setGanadas(0);

        while (true){
            do {
                try {
                    opcionesDelJuego = JOptionPane.showOptionDialog(null,
                        "Bienvenido!\nQue quieres hacer?", TITULO, JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, Arrays.asList("Ver instrucciones",
                                "Jugar", "Ver resultados").toArray(), "Ver instrucciones");
                    if (opcionesDelJuego == CERRAR) {
                        System.exit(0);
                    }
                    pudoCastear = true;
                } catch (NumberFormatException e) {
                    pudoCastear = false;
                }
            } while (!pudoCastear);

            switch (opcionesDelJuego){
                case INSTRUCCIONES: {
                    mostrarInstrucciones(Juego.instruccionesDelJuego);
                    break;
                }

                case JUGAR: {
                    do {
                        try {
                            opcionElegida = String.valueOf(JOptionPane.showInputDialog(null,
                                    "Juguemos!\nSelecciona una opcion:", TITULO, JOptionPane.QUESTION_MESSAGE,
                                    null, Juego.opcionesDelJuego.toArray(),"Viento"));
                            if (opcionElegida == null) {
                                System.exit(0);
                            }
                            pudoCastear = true;
                        } catch (NumberFormatException e) {
                            pudoCastear = false;
                        }
                    } while (!pudoCastear);

                    if (opcionElegida != "null") { // String cuando se oprime cancelar
                        String opcionAleatoria = Juego.opcionAleatoria(Juego.opcionesDelJuego);
                        int resultado = Juego.partida(opcionElegida, opcionAleatoria);

                        switch (resultado) {
                            case EMPATES: {
                                nuevoJugador.setEmpates(nuevoJugador.getEmpates() + 1);
                                computadora.setEmpates(computadora.getEmpates() + 1);
                                respuestaActual("Empate!", opcionAleatoria, opcionElegida);
                                break;
                            }

                            case GANADAS: {
                                nuevoJugador.setGanadas(nuevoJugador.getGanadas() + 1);
                                respuestaActual("Ganaste!", opcionAleatoria, opcionElegida);
                                break;
                            }

                            default: {
                                computadora.setGanadas(computadora.getGanadas() + 1);
                                respuestaActual("Perdiste!", opcionAleatoria, opcionElegida);
                                break;
                            }
                        }
                    }

                    break;
                }

                case RESULTADOS: {
                    //jugadores.add(nuevoJugador);
                    resultadoFinal();
                    nuevoJugador.setNombre(JOptionPane.showInputDialog("Juguemos de nuevo!\nIngesa tu nombre"));

                    if (nuevoJugador.getNombre() == "" || nuevoJugador.getNombre() == " ") {
                        nuevoJugador.setNombre("Tú");
                    }
                    nuevoJugador.setEmpates(0);
                    nuevoJugador.setGanadas(0);
                    computadora.setEmpates(0);
                    computadora.setGanadas(0);
                    break;
                }
            }
        }
    }
    public static void mostrarInstrucciones(String instrucciones){
        JOptionPane.showMessageDialog(null, instrucciones, "Instrucciones",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void respuestaActual(String respuesta, String opcionAleatoria, String opcionElegida){
        JOptionPane.showMessageDialog(null, "Tu seleccionaste: " + opcionElegida +
                ".\nLa computadora: " + opcionAleatoria + ".\n\n" + respuesta, "Respuesta",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void resultadoFinal(){
        JOptionPane.showMessageDialog(null, nuevoJugador.getNombre() + " : " +
                nuevoJugador.getGanadas() + " Partidas ganadas.\n" + computadora.getNombre() + " : " +
                computadora.getGanadas() + " Partidas ganadas.\n Empates: " + computadora.getEmpates() +
                " Partidas.", "Resultados", JOptionPane.INFORMATION_MESSAGE);
    }
}
