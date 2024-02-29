import java.util.Scanner;
public class progressaoAritmetica {
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o valor do primeiro termo da PA: ");
        double a_1 = teclado.nextDouble();

        System.out.println("Digite a razão da PA ");
        double r = teclado.nextDouble();

        System.out.println("Digite o número de termos da PA: ");
        int n = teclado.nextInt();

        double a_n = a_1 + (n-1) * r;

        System.out.println("Último termo da PA: " + a_n);

        double S_n = (a_1 + a_n) * n / 2;

        System.out.println("Soma de todos os termos da PA: " + S_n);
    }
}
