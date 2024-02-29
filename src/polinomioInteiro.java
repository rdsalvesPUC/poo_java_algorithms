import java.util.Scanner;
public class polinomioInteiro {
    static public void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o valor do coeficiente a: ");
        int a = teclado.nextInt();

        System.out.println("Digite o valor do coeficiente b: ");
        int b = teclado.nextInt();

        System.out.println("Digite o valor do coeficiente c: ");
        int c = teclado.nextInt();

        System.out.println("Digite o valor para x: ");
        double x = teclado.nextDouble();

        double y = a * Math.pow(x, 2) + b * x + c;

        System.out.println("Resultado do cálculo do polinômio: " + y);
    }
}
