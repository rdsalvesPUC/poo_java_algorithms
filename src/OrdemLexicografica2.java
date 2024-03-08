import java.util.Scanner;
public class OrdemLexicografica2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite a string 1: ");
        String s1 = teclado.nextLine();

        System.out.println("Digite a string 2: ");
        String s2 = teclado.nextLine();

        if (s1.compareTo(s2) < 0) {
            System.out.println(s1);
            System.out.println(s2);
        }
        else {
            System.out.println(s2);
            System.out.println(s1);
        }
    }
}
