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

        double delta = b**2 - 4 * a * c;

        if (delta < 0);
        System.out.println("Não existe raiz real");
    }
}
