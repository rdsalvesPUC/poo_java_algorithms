import java.util.Scanner;
public class DivisaoEuclidiana {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o valor de x: ");
        int x = teclado.nextInt();

        System.out.println("Digite o valor de y: ");
        int y = teclado.nextInt();

        int q = 0;
        int r = x;

        while (r >= y)
        {
            r = r - y;
            q = q + 1;
        }

        System.out.println("Quociente: " + q);
        System.out.println("Resto: " + r);
    }
}
