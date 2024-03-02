import java.util.Scanner;
public class ParOuImpar {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite um número inteiro: ");
        int n = teclado.nextInt();

        int resto = n % 2;

        if (resto == 0) {
            System.out.println("O número é par!");
        }
        else {
            System.out.println("O número é impar!");
        }
    }
}
