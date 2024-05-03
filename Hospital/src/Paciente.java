import java.time.*;
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

    public static ArrayList getListaPacientes() {
        return pacientes;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String novoCpf) {
        cpf = novoCpf;
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }
}