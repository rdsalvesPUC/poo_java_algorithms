public class Corrida {
    public static void main(String args[])
    {
        Tartaruga tartaruga = new Tartaruga(15, 15);
        tartaruga.definir_territorio(500, 500);
        System.out.println("Primeiro movimento da tartaruga:");
        tartaruga.mover(30, 40);
        System.out.println("Segundo movimento da tartaruga:");
        tartaruga.mover(20, -50);
        Coelho coelho = new Coelho(30, 50);
        coelho.definir_territorio(500, 500);
        System.out.println("Primeiro movimento do coelho:");
        coelho.mover(500, 500);
        System.out.println("Segundo movimento do coelho:");
        coelho.mover(-200, -250);
    }
}