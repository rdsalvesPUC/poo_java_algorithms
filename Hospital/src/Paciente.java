import java.io.*;
import java.util.*;

public class Paciente {
    private String nome;
    private String cpf;
    private ArrayList<Consulta> consultas;
    private static ArrayList<Paciente> pacientes = new ArrayList<>();

    public Paciente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        consultas = new ArrayList<>();
    }

    public static void criar_pacientes(String path) {
        BufferedReader reader = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            reader = new BufferedReader(new FileReader(path));
            while ((line = reader.readLine()) != null) {

                String[] paciente = line.split(cvsSplitBy);
                String nome = paciente[0];
                String cpf = (paciente[1]);

                pacientes.add(new Paciente(nome, cpf));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList get_lista_pacientes() {
        return pacientes;
    }

    public String get_nome() {
        return nome;
    }

    public static String get_paciente_nome(String cpf) {
        String paciente_nome = "";
        for (Paciente paciente : pacientes) {
            if (Objects.equals(cpf, paciente.get_cpf())) {
                paciente_nome = paciente.get_nome();
            }
        }
        return paciente_nome;
    }

    public String get_cpf() {
        return cpf;
    }

    public void add_consulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public static void alocar_paciente() {
        ArrayList<Medico> listaMedicos = Medico.get_lista_medicos();
        for (Paciente paciente : pacientes) {
            for (Consulta consulta : paciente.consultas) {
                for (Medico medico: listaMedicos) {
                    if (medico.get_crm() == consulta.get_crm()) {
                        medico.add_paciente(paciente);
                    }
                }
            }
        }
    }

    public void exibir() {
        System.out.printf("\nPaciente: %-20s CPF: %-10s", nome, cpf);
        System.out.println("\n------------------------------------");
    }

    public String exibir_consultas_by_paciente() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("\nPaciente: %-20s CPF: %-10s", nome, cpf));
        output.append("\n------------------------------------");
        output.append("\nData            Horário    Médico (CRM)");
        output.append("\n------------------------------------");
        for (Consulta consulta : consultas) {
            String nome_medico = Medico.get_medico_nome(consulta.get_crm());
            output.append(String.format("\n%-15s %-10s %-10s (%s)", consulta.get_data_str(), consulta.get_horario(), nome_medico, consulta.get_crm()));
        }
        return output.toString();
    }

}
