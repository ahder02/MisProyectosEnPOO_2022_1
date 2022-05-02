/*package parcial.dominio;

import Taller1.agenda.dominio.Contacto;
import Taller1.dispensador.dominio.Snack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EPS {
    private final byte CAPACIDAD = 100;
    private static byte capacidadActual;
    private List<Paciente> pacientes = new ArrayList<>();

    private String nombre;

    public byte getCAPACIDAD() {
        return CAPACIDAD;
    }

    public Paciente getPacientes() {
        return (Paciente) pacientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Metodos auxiliares
    private static void aumentarCapacidad(){
        capacidadActual++;
    }

    private void agregarAListaDePacientes(Paciente nuevoPaciente){
        this.pacientes.add(nuevoPaciente);
    }

    private boolean verificarExistencia(long cedula){
        if (String.valueOf(this.pacientes.stream().filter(c -> c.getCedula() == cedula))
                == String.valueOf(cedula)){
            return true;
        } else {
        return false;
        }
    }

    // Metodos principales
    public boolean afiliarPaciente(long cedula, String nombre){
        if (capacidadActual<=CAPACIDAD && verificarExistencia(cedula) != true){
            aumentarCapacidad();
            Enfermedad nuevaEnfermedad = new Enfermedad(nombre);
            Paciente nuevoPaciente = new Paciente(nombre, cedula, nuevaEnfermedad);
            this.pacientes.add(nuevoPaciente);
            return true;
        } else {
            return false;
        }

    }

    public void sacarPaciente(long cedula){
        if (verificarExistencia(cedula) != true){
            int posicionASacar = this.pacientes.indexOf(cedula);
            this.pacientes.set(posicionASacar, cedula);
        }
    }

    public Paciente buscarPaciente(long cedula){
        if (cedula >= 0){
            return this.pacientes.stream().filter(c -> c
                    .getCedula() == cedula).findFirst().orElse(null);
        } else {
            return null;
        }
    }

    public List<Paciente> buscarPacientesPorEnfermedad(String enfermedadABuscar){
        List<Paciente> pacientesPorEnfermedad = new ArrayList<>();
        this.pacientes.stream()
                .filter(s -> s.getEnfermedades().getNombre() == enfermedadABuscar)
                .collect(Collectors.toList())
                .forEach(c -> pacientesPorEnfermedad.add(c));
        return pacientesPorEnfermedad;
    }

    public List<Paciente> obtenerPacientesSinEnfermedad(){
        List<Paciente> pacientesSinEnfermedad = new ArrayList<>();
        this.pacientes.stream().filter(c -> c.getEnfermedades().getGravedad() == 1)
                .collect(Collectors.toList())
                .forEach(c -> pacientesSinEnfermedad.add(c));
        return pacientesSinEnfermedad;
    }

    public void ordenarPacientesPorNombre(){
        this.pacientes.sort(Comparator.comparing(Paciente::getNombre));
    }
}
*/