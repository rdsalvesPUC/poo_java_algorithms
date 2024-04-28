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
