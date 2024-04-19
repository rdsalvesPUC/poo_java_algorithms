import java.util.*;

public class Estado {
    private ArrayList<Municipio> municipios;

    public Estado() {
        municipios = new ArrayList<>();
    }

    public void addMunicipio(Municipio m) {
        municipios.add(m);
    }

//    public int menorPopulacao() {
//
//        return municipios;
//    }

    public int populacao() {
        int maxPopulacao = 0;
        for (Municipio m : municipios) {
            maxPopulacao += m.populacao();
        }
        return maxPopulacao;
    }

    public double area() {
        double maxArea = 0;
        for (Municipio m : municipios) {
            maxArea = maxArea + m.area();
        }
        return maxArea;
    }

    double densidade() { return populacao() / area(); }
}