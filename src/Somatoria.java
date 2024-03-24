import java.util.Scanner;

public class Somatoria {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informa quantidade de valores: ");
        int n = teclado.nextInt();

        double PI = Math.PI;
        double z = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("Digite o valor de X: ");
            double x = teclado.nextByte();

            double t = (Math.pow(PI - x, 2)) / i;
            z += t;
        }

        System.out.println(z);

    }
}
