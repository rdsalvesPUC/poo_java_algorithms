public class Imovel {
    private int incricao;
    private int bairroID;
    private double areaTerreno;
    private double areaConstruida;
    private double valor;

    public void addInscricao(int n) {
        incricao = n;
    }
    public void addBairroID(int n) {
        bairroID = n;
    }
    public void addAreaTerreno(double area) {
        areaTerreno = area;
    }
    public void addAreaConstruida(double area) {
        areaConstruida = area;
    }

    public void calculoIPTU() {
        switch (bairroID) {
            case 0, 1, 2: valor = (areaTerreno) + (areaConstruida * 2.00); break;
            case 3, 4, 5: valor = (areaTerreno * 0.50) + (areaConstruida); break;
            default: valor = (areaTerreno * 0.25) + (areaConstruida * 0.50);
        }
    }

    public void exibir() {
        System.out.println("Dados do Ímovel \n======================");
        System.out.println("Incrição Estadual: " + incricao);
        System.out.println("Código do Bairro: " + bairroID);
        System.out.printf("Área Total do Terreno: %.2f m²%n", areaTerreno);
        System.out.printf("Área Total Construída: %.2f m²%n", areaConstruida);
        System.out.printf("======================\nValor a ser pago: R$ %.2f \n%n", valor);
    }
}