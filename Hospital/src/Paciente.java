import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Paciente {
    private String nome;
    private String cpf;
    private ArrayList<Consulta> consultas;

    public Paciente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        consultas = new ArrayList<>();
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
