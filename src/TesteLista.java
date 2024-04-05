import java.util.ArrayList;
public class TesteLista {
    public static void main(String[] args)
    {
        ArrayList<String> cidades = new ArrayList<String>();

        System.out.println(cidades.size());

        cidades.add("Curitiba");
        cidades.add("Maringa");
        cidades.add("Londrina");

        System.out.println(cidades.size());

        for (String x : cidades)
            System.out.println(x);
    }
}