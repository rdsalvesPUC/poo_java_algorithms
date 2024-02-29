import java.util.Scanner;
public class CirculoAreaPerimetro {
    public static void main(String[] args)
    {
//        final double PI = 3.14159;

        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o valor do raio: ");
        float raio = teclado.nextFloat();

        float area = raio * (float)Math.PI;
        float perimetro = 2 * (float)Math.PI * raio;

        System.out.println("Área do circulo: " + area);
        System.out.println("Perimetro do circulo: " + perimetro);
    }
}
