import java.util.Scanner;

public class Fatorial {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o número para calcular o fatorial: ");
        int n = teclado.nextInt();

        int f = 1;

        for (int i = n; i > 1; i-- ) {
            f = f * i;
        }

        System.out.println("Fatorial: " + f);
    }
}
