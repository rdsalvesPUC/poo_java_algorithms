import java.util.Scanner;
public class MediaAritmetica35 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o tamanho da amostra: ");
        int n = teclado.nextInt();

        System.out.println("Digite o valor 1: ");
        double x1 = teclado.nextDouble();

        System.out.println("Digite o valor 2: ");
        double x2 = teclado.nextDouble();

        System.out.println("Digite o valor 3: ");
        double x3 = teclado.nextDouble();

        double x4 = 0;
        double x5 = 0;

        if (n > 3) {
            System.out.println("Digite o valor 4: ");
            x4 = teclado.nextDouble();

            if (n > 4) {
                System.out.println("Digite o valor 5: ");
                x5 = teclado.nextDouble();
            }
        }

        double M = (x1 + x2 + x3 + x4 + x5) / n;

        System.out.print("Resultado do cáculo da média aritmética: ");
        System.out.printf("%.2f\n", M);

    }
}
