public class IPTU {
    public static void main(String[] args) {
        Imovel imovelA = new Imovel();
        imovelA.addInscricao(123456789);
        imovelA.addBairroID((int)(Math.random() * 10));
        imovelA.addAreaTerreno((Math.random() * 100));
        imovelA.addAreaConstruida((Math.random() * 100));

        Imovel imovelB = new Imovel();
        imovelB.addInscricao(987654312);
        imovelB.addBairroID((int)(Math.random() * 10));
        imovelB.addAreaTerreno((Math.random() * 100));
        imovelB.addAreaConstruida((Math.random() * 100));

        Imovel imovelC = new Imovel();
        imovelC.addInscricao(456123789);
        imovelC.addBairroID((int)(Math.random() * 10));
        imovelC.addAreaTerreno((Math.random() * 100));
        imovelC.addAreaConstruida((Math.random() * 100));

        imovelA.calculoIPTU();
        imovelB.calculoIPTU();
        imovelC.calculoIPTU();

        imovelA.exibir();
        imovelB.exibir();
        imovelC.exibir();

    }

}
