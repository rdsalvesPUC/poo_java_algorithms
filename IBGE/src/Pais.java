import java.util.*;

public class Pais {
    String nome;
    private ArrayList<Estado> estados;

    public Pais(String nome) {
        this.nome = nome;
        estados = new ArrayList<>();
    }

    public void addEstado(Estado e) {
        estados.add(e);
    }

    public String getNome() {
        return nome;
    }

    public int populacao() {
        int maxPopulacao = 0;
        for (Estado e : estados) {
            maxPopulacao += e.populacao();
        }
        return maxPopulacao;
    }

    public double area() {
        double maxArea = 0;
        for (Estado e : estados) {
            maxArea += e.area();
        }
        return maxArea;
    }

    public double densidade() {
        return populacao() / area();
    }

    public String checkSmallestPop() {
        String smallestPop = "";
        int estadoPop = estados.get(0).populacao();
        String estadoNome = estados.get(0).getNome();

        for (int i = 1; i < estados.size(); i++) {
            int tryPop = estados.get(i).populacao();
            if (tryPop < estadoPop) {
                estadoPop = tryPop;
                estadoNome = estados.get(i).getNome();
            }
        }
        smallestPop += estadoNome + ": " + estadoPop + "\n";
        return smallestPop;
    }
}