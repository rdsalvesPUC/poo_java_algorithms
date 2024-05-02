import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Medico {
    private String nome;
    private int crm;
    private ArrayList<Paciente> pacientes;

    public Medico(String nome, int crm) {
        this.nome = nome;
        this.crm = crm;
        pacientes = new ArrayList<>();
    }

    public static void criar_medicos() {
        ArrayList<Medico> medicos = new ArrayList<>();
        String file = "Hospital/arquivos_csv/medicos.csv";
        BufferedReader reader = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            reader = new BufferedReader(new FileReader(file));
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

    public String getNome() {
        return nome;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int novoCrm) {
        crm = novoCrm;
    }

    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void exibir() {
        System.out.printf("\nMédico: %-10s \nCRM: %-10s", nome, crm);
    }
}
