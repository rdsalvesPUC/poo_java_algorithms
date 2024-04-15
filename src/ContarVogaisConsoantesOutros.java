import java.util.Scanner;
public class ContarVogaisConsoantesOutros {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite seu texto: ");
        String texto = teclado.nextLine();

        ProcessadorStrings.anatomy(texto);
    }
}
