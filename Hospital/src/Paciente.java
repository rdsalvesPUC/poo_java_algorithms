import java.io.*;
import java.time.LocalDate;
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

    public ArrayList<Consulta> get_lista_consultas() {
        return consultas;
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

    public boolean check_medico(int crm) {
        boolean resposta = false;
        for (Consulta consulta : consultas) {
            if (crm == consulta.get_crm()) {
                resposta = true;
            }
        }
        return resposta;
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
        Collections.sort(Consulta.get_lista_consultas());
        for (Consulta consulta : consultas) {
            String nome_medico = Medico.get_medico_nome(consulta.get_crm());
            output.append(String.format("\n%-15s %-10s %-10s (%s)", consulta.get_data_str(), consulta.get_horario(), nome_medico, consulta.get_crm()));
        }
        return output.toString();
    }

    public String exibir_medicos_by_paciente() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("\nPaciente: %-20s CPF: %-10s", nome, cpf));
        output.append("\n------------------------------------");
        output.append("\nMédico Responsáveis (CRM)");
        output.append("\n------------------------------------");
        Collections.sort(Consulta.get_lista_consultas());
        for (Consulta consulta : consultas) {
            String nome_medico = Medico.get_medico_nome(consulta.get_crm());
            output.append(String.format("\n%-20s (%s)", nome_medico, consulta.get_crm()));
        }
        return output.toString();
    }

    public String exibir_consultas_by_paciente_and_medico(int crm) {
        StringBuilder output = new StringBuilder();
        String nome_paciente = Paciente.get_paciente_nome(cpf);
        String nome_medico = Medico.get_medico_nome(crm);

        output.append(String.format("\nPaciente: %-20s CPF: %-10s\n  Medico: %-20s CRM: %-10s", nome_paciente, cpf, nome_medico, crm));
        output.append("\n------------------------------------");
        output.append("\nData         Horário");
        output.append("\n------------------------------------");
        Collections.sort(Consulta.get_lista_consultas());
        for (Consulta consulta : consultas) {
            if (consulta.get_data().isBefore(LocalDate.now()) && consulta.get_crm() == crm) {
                // output.append(String.format("\n%-15s %-10s", consulta.get_data_str(), consulta.get_horario()));
                output.append(String.format("\n%-12s %-8s %-17s (%s)", consulta.get_data_str(), consulta.get_horario()));
            }
        }
        return output.toString();
    }
}
