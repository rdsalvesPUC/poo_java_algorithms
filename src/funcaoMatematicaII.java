import java.util.Scanner;
public class funcaoMatematicaII {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        double x;

        do {
            System.out.println("Forneça X: ");
            x = teclado.nextDouble();

            if (x != 0) {
                if (x <= 4)
                    System.out.println("O valor de X não pode ser menor ou igual a 4");
                else {
                    double y = Math.sin(x) / Math.sqrt(x-4);
                    System.out.println("Resultado: " + y);
                }
            }
            else System.out.println("Não é possível dividir por zero.");
        } while (x == 0 || x <= 4);
    }
}
