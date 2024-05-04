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

    public int get_crm() {
        return crm;
    }

    public void add_paciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void exibir() {
        System.out.printf("\nMédico: %-10s \nCRM: %-10s", nome, crm);
    }
}
