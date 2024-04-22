public class IBGE {
    public static void main(String[] args) {
        Pais brasil = new Pais("Brasil");

        Estado parana = new Estado("Parana");
        Estado bahia = new Estado("Bahia");

        Municipio curitiba = new Municipio("Curitiba", 3400, 400);
        Municipio guarapuava = new Municipio( "Guarapuava", 200, 100);
        Municipio londrina = new Municipio( "Londrina", 800, 300);
        Municipio maringa = new Municipio( "Maringa", 600, 200);

        Municipio salvador = new Municipio("Salvador", 3000, 400);
        Municipio juazeiro = new Municipio( "Juazeiro", 400, 100);
        Municipio ilheus = new Municipio("Ilheus", 280, 200);
        Municipio itabuna = new Municipio( "Itabune", 320, 300);

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

        System.out.println("Densidade ============");
        System.out.printf("%s: %.1f\n", curitiba.getNome(), curitiba.densidade()); // quadro 1
        System.out.printf("%s: %.1f\n", parana.getNome(), parana.densidade()); // quadro 3
        System.out.printf("%s: %.1f\n", brasil.getNome(), brasil.densidade()); // quadro 5
        System.out.println("\nArea ============");
        System.out.printf("%s: %.1f\n", bahia.getNome(), bahia.area()); // quadro 2
        System.out.println("\nPopulação ============");
        System.out.printf("%s: %s\n", brasil.getNome(), brasil.populacao()); // quadro 4
        System.out.println("\nEstado com menor população ============");
        System.out.printf(brasil.checkSmallestPop());
        System.out.println("\nMunicipio com menor população ============");
        System.out.printf(parana.checkSmallestPop());
        System.out.printf(bahia.checkSmallestPop());
    }
}