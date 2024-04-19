import java.util.*;

public class Pais {
    private ArrayList<Estado> estados;

    public Pais() {
        estados = new ArrayList<>();
    }

    public void addEstado(Estado e) {
        estados.add(e);
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
}