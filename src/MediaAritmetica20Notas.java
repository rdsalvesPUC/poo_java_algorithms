import java.util.Scanner;

public class MediaAritmetica20Notas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        double soma = 0;
        int contador = 0;

        for (int i = contador; i < 20; i++) {
            System.out.println("Digite uma nota: ");
            double nota = teclado.nextDouble();

            soma += nota;
            contador++;
        }

        double media = soma / 20;

        System.out.println("Média calculada: " + media);
    }
}
