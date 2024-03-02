import java.util.Scanner;
public class Menor3Numeros {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o valor A: ");
        double a = teclado.nextDouble();

        System.out.println("Digite o valor B: ");
        double b = teclado.nextDouble();

        System.out.println("Digite o valor C: ");
        double c = teclado.nextDouble();

        double menor = 0;

        if ((a < b) && (a < c))
        {
            menor = a;
            System.out.println("O primeiro é o menor: ");
        }
        else
        {
            if ((b < a) && (b < c))
            {
                menor = b;
                System.out.println("O segundo é o menor: ");
            }
            else
            {
                menor = c;
                System.out.println("O terceiro é o menor: ");
            }
        }

        System.out.println(menor);
    }
}
