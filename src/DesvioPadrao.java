import java.util.Scanner;

public class DesvioPadrao {
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

        double soma = 0;
        soma = soma + Math.pow((x1 - M), 2);
        soma = soma + Math.pow((x2 - M), 2);
        soma = soma + Math.pow((x3 - M), 2);
        soma = soma + Math.pow((x4 - M), 2);
        soma = soma + Math.pow((x5 - M), 2);

        double DP = Math.sqrt(soma / n);

        System.out.println(String.format("Resultado do cálculo do descio padrão: %.2f", DP));
    }
}
