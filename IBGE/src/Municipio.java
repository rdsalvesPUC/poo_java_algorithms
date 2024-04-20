import java.util.*;

public class Municipio {
    String nome;
    private int populacao;
    private double area;

    public Municipio(String nome, int populacao, double area) {
        this.nome = nome;
        this.populacao = populacao;
        this.area = area;
    }

    public String getNome() {
        return nome;
    }

    public int populacao() {
        return populacao;
    }

    public double area() {
        return area;
    }

    public double densidade() {
        return populacao / area;
    }
}
