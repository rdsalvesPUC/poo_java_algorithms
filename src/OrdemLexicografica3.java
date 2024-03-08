import java.util.Scanner;
public class OrdemLexicografica3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite a string 1: ");
        String s1 = teclado.nextLine();

        System.out.println("Digite a string 2: ");
        String s2 = teclado.nextLine();

        System.out.println("Digite a string 3: ");
        String s3 = teclado.nextLine();

        String a, b, c;

        if (s1.compareTo(s2) < 0 && s1.compareTo(s3) < 0) {
            a = s1;

            if (s2.compareTo(s3) < 0) {
                b = s2;
                c = s3;
            }
            else {
                b = s3;
                c = s2;
            }
        }
        else {
            c = s1;

            if (s2.compareTo(s3) < 0) {
                a = s2;
                b = s3;
            }
            else {
                b = s3;
                a = s2;
            }
        }
        System.out.printf("%s\n%s\n%s", a, b, c);
    }
}
