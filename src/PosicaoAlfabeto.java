import java.util.*;
public class PosicaoAlfabeto {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        char letra;
        do {
            System.out.println("Digite uma letra: ");
            letra = teclado.next().charAt(0);

            System.out.println(ProcessadorStrings.localizar(letra));

        } while (!Character.isLetter(letra));
    }
}
