//import java.util.Scanner;
public class aleatorioCores {
    public static void main(String[] args)
    {
        int x = (int)(Math.random() * 100) / 10;

        System.out.println("Numero aleatório: " + x);

        if (x == 0 || x == 1 || x == 2)
            System.out.println("azul");
        else if (x == 5 || x == 7 || x == 9) {
            System.out.println("marrom");
        }
        else
            System.out.println("amarelo");
    }
}
