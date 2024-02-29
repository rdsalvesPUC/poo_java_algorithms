import java.util.Scanner;
public class EquacaoSegundoGrau {
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o coeficiente a: ");
        double a = teclado.nextDouble();

        System.out.print("Digite o coeficiente b: ");
        double b = teclado.nextDouble();

        System.out.print("Digite o coeficiente c: ");
        double c = teclado.nextDouble();

        double delta = Math.pow(b, 2) - 4 * a * c;

        if (delta < 0)
            System.out.println("Não existe raiz real");
        else
        {
            if (delta == 0)
            {
                double x1 = -b / (2*a);
                System.out.println("Existe somente uma raiz real: " + x1);
            }
            else
            {
                double x1 = (-b + Math.sqrt(delta)) / (2*a);
                double x2 = (-b - Math.sqrt(delta)) / (2*a);
                System.out.println(x1);
                System.out.println(x2);
            }

        }
    }
}
