import java.util.*;
public class Fibonacci {
    public static void main(String[] args) {
        int k = ler_inteiro_positivo("Digite uma posição da Sequência de Fibonacci: ");
        System.out.println(
                String.format("O número na posição %d da Sequência de Fibonacci é %d.",
                        k, fib(k-1)));
    }
    private static int fib(int k) {
        int resultado = 0;
        if (k == 0 || k == 1)
            resultado = k;
        else
            resultado = fib(k-1) + fib(k-2);
        return resultado;
    }
    private static int ler_inteiro_positivo(String prompt) {
        int posicao = ler_inteiro(prompt);

        boolean positivo = false;
        while (!positivo) {
            if (posicao > 0) {
                positivo = true;
            }
            else {
                System.out.print("Valor tem que ser positivo. Tente novamente!");
            }
        }
        return posicao;
    }
    private static int ler_inteiro(String prompt) {
        Scanner teclado = new Scanner(System.in);

        boolean isDigit = false;
        int inteiro = 0;
        while (!isDigit) {
            try {
                System.out.print(prompt);
                inteiro = teclado.nextInt();
                isDigit = true;
            }
            catch (Exception e) {
                System.out.println("Entrada inválida. Tente novamente!");
                teclado.nextLine();
            }
        }
        return inteiro;
    }
}