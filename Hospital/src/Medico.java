import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.time.temporal.ChronoUnit;

public class Medico extends GestaoDados implements Serializable {
    private String nome;
    private int crm;
    private ArrayList<Paciente> pacientes;
    private static ArrayList<Medico> medicos = new ArrayList<>();

    public Medico(String nome, int crm) {
        this.nome = nome;
        this.crm = crm;
        pacientes = new ArrayList<>();
    }

    public static void criar_medicos(String path) {
        BufferedReader reader = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            reader = new BufferedReader(new FileReader(path));
            while ((line = reader.readLine()) != null) {

                String[] medico = line.split(cvsSplitBy);
                String nome = medico[0];
                int crm = Integer.parseInt(medico[1]);

                medicos.add(new Medico(nome, crm));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            salvar(medicos,"Save-Medicos");
            System.out.println("Lista de médicos foi serializada.");
        } catch (IOException e) {
            System.out.println("Não foi possível serializar a lista de médicos");
            e.printStackTrace();
        }
    }

    public static ArrayList get_lista_medicos() {
        return medicos;
    }

    public String get_nome() {
        return nome;
    }

    public static String get_medico_nome(int crm) {
        String medico_nome = "";
        for (Medico medico : medicos) {
            if (crm == medico.get_crm()) {
                medico_nome = medico.get_nome();
            }
        }
        return medico_nome;
    }

    public int get_crm() {
        return crm;
    }

    public void add_paciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public static int converter_meses(int meses) {
        int meses_to_dias = meses * 30;
        return meses_to_dias;
    }

    public static long diferenca_dias(LocalDate data_consulta) {
        LocalDate data_atual = LocalDate.now();

        long diferencaEmDias = ChronoUnit.DAYS.between(data_consulta, data_atual);
        return diferencaEmDias;
    }

    public String exibir_pacientes_by_medico() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("\nMédico: %-10s CRM: %-10s", nome, crm));
        output.append("\n------------------------------------");
        output.append("\nPaciente             CPF");
        output.append("\n------------------------------------");
        for (Paciente paciente : pacientes) {
            output.append(String.format("\n%-20s %-20s", paciente.get_nome(), paciente.get_cpf()));
        }
        return output.toString();
    }

    public String exibir_consultas_by_medico(LocalDate data_inicial, LocalDate data_final) {
        String nome_medico = Medico.get_medico_nome(crm);
        StringBuilder output = new StringBuilder();
        output.append(String.format("\nMédico: %-10s CRM: %-10s", nome_medico, crm));
        output.append("\n--------------------------------------------------------");
        output.append("\n-                      Consultas                       -");
        output.append("\n--------------------------------------------------------");
        output.append("\nData         Horário  Paciente (CPF)");
        output.append("\n--------------------------------------------------------");
        Collections.sort(Consulta.get_lista_consultas());
        for (Consulta consulta : Consulta.get_lista_consultas()) {
            if (crm == consulta.get_crm()) {
                if (consulta.get_data().isAfter(data_inicial) && consulta.get_data().isBefore(data_final)) {
                    String nome_paciente = Paciente.get_paciente_nome(consulta.get_cpf());
                    output.append(String.format("\n%-12s %-8s %-17s (%s)", consulta.get_data_str(), consulta.get_horario(), nome_paciente, consulta.get_cpf()));
                }
            }
        }
        return output.toString();
    }

    public String exibir_pacientesInativos_by_medico(int meses) {
        int dataCorte = converter_meses(meses);
        StringBuilder output = new StringBuilder();

        output.append(String.format("\nMédico: %-10s CRM: %-10s", nome, crm));
        output.append("\n-------------------------------------------------------");
        output.append("\nPacientes           CPF            Dias Inativo");
        output.append("\n-------------------------------------------------------");
        for (Paciente paciente : pacientes) {
            paciente.get_lista_consultas().sort(Comparator.comparing(Consulta::get_data));
            Consulta consultaMaisAntiga = paciente.get_lista_consultas().get(0);
            long diferencaDias = diferenca_dias(consultaMaisAntiga.get_data());
            if (diferencaDias > dataCorte) {
                // output.append(String.format("\n%-12s %-20s %-15s %s dias", consultaMaisAntiga.get_data_str(), paciente.get_nome(), paciente.get_cpf(), diferencaDias));
                output.append(String.format("\n%-20s %-15s %s dias inativo", paciente.get_nome(), paciente.get_cpf(), diferencaDias));

            }
        }
        return output.toString();
    }
}
