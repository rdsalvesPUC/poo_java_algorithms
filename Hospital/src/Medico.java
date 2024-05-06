import java.io.*;
import java.util.*;

public class Medico {
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

//    public void exibir() {
//        System.out.printf("\nMédico: %-10s CRM: %-10s", nome, crm);
//        System.out.println("\n------------------------------------");
//        System.out.println("Paciente             CPF");
//        System.out.println("------------------------------------");
//        for (Paciente p : pacientes) {
//            System.out.printf("%-20s %-20s\n", p.get_nome(), p.get_cpf());
//        }
//    }

    // Modificar o método exibir() para retornar uma representação em String dos dados
    public String exibir() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("\nMédico: %-10s CRM: %-10s", nome, crm));
        output.append("\n------------------------------------");
        output.append("\nPaciente             CPF");
        output.append("\n------------------------------------");
        for (Paciente p : pacientes) {
            output.append(String.format("\n%-20s %-20s", p.get_nome(), p.get_cpf()));
        }
        return output.toString();
    }
}
