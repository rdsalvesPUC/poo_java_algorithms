import java.util.*;

public class IBGE {
    public static void main(String[] args) {
        Pais brasil = new Pais();

        Estado parana = new Estado();
        Estado bahia = new Estado();

        Municipio curitiba = new Municipio(2400, 400);
        Municipio guarapuava = new Municipio( 200, 100);
        Municipio londrina = new Municipio( 800, 300);
        Municipio maringa = new Municipio( 600, 200);

        Municipio salvador = new Municipio(3000, 400);
        Municipio juazeiro = new Municipio( 400, 100);
        Municipio ilheus = new Municipio(280, 200);
        Municipio itabuna = new Municipio( 320, 300);

        parana.addMunicipio(curitiba);
        parana.addMunicipio(guarapuava);
        parana.addMunicipio(londrina);
        parana.addMunicipio(maringa);

        bahia.addMunicipio(salvador);
        bahia.addMunicipio(juazeiro);
        bahia.addMunicipio(ilheus);
        bahia.addMunicipio(itabuna);

        brasil.addEstado(parana);
        brasil.addEstado(bahia);

        System.out.println(curitiba.densidade()); // quadro 1
        System.out.println(parana.densidade()); // quadro 3
        System.out.println(bahia.area()); // quadro 2
        System.out.println(brasil.populacao()); // quadro 4
        System.out.println(brasil.densidade()); // quadro 5
        System.out.println(parana.menorPopulacao());
        System.out.println(brasil.menorPopulacao());

//        Em adição, crie os métodos necessários para se identificar o município de estado
//        que tem a menor população, bem como o estado de um país que tenha a menor
//        população.

    }
}