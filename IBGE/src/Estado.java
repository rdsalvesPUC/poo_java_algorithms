import java.util.*;

public class Estado {
    String nome;
    private ArrayList<Municipio> municipios;

    public Estado(String nome) {
        this.nome = nome;
        municipios = new ArrayList<>();
    }

    public void addMunicipio(Municipio m) {
        municipios.add(m);
    }

    public String getNome() {
        return nome;
    }

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

    public String checkSmallestPop() {
        String smallestPop = "";
        int municipioPop = municipios.get(0).populacao();
        String municipioNome = municipios.get(0).getNome();

        for (int i = 1; i < municipios.size(); i++) {
            int tryPop = municipios.get(i).populacao();
            if (tryPop < municipioPop) {
                municipioPop = tryPop;
                municipioNome = municipios.get(i).getNome();
            }
        }
        smallestPop += municipioNome + ": " + municipioPop + "\n";
        return smallestPop;
    }

    double densidade() { return populacao() / area(); }
}