package Quiz3.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Oftalmologo {
    private String nombre;
    private List<Paciente> pacientes = new ArrayList<>();

    public Paciente revisarPaciente(String nombre, int edad) {
        Paciente pacienteAIngresar;
        if (nombre.toLowerCase().contains("a")){
                if (edad < 40)
                    pacienteAIngresar = new PacienteApto(nombre, edad, true);
                else
                    pacienteAIngresar = new PacienteNoApto(nombre, edad, true);
    } else
        pacienteAIngresar = new PacienteNoApto(nombre, edad, false);
    pacientes.add(pacienteAIngresar);
    return pacienteAIngresar;
    }

    public void operarPacientes(){
        this.pacientes.stream().filter(p -> p instanceof PacienteApto)
                .forEach(paciente -> ((PacienteApto) paciente).operar());
    }

    public List<Paciente> getPacientesAOperar(){
        return this.pacientes.stream().filter(p -> p instanceof PacienteApto && p.isNecesitaCirugia())
                .collect(Collectors.toList());
    }
}
