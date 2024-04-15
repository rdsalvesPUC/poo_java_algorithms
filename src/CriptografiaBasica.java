import java.util.Scanner;
public class CriptografiaBasica {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite um texto: ");
        String texto = teclado.nextLine();

        System.out.print("A string encriptada é:" + ProcessadorStrings.criptografar(texto));
    }
}
