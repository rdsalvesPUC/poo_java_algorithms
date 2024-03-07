import java.util.Scanner;
public class Projetil {
    public static void main(String[] Args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe o angulo de alpha: ");
        int alpha = teclado.nextInt();

        System.out.println("Informa a distancia: ");
        int R = teclado.nextInt();

        double radiano_alpha = Math.toRadians(alpha);
        double g = 9.8;

//        Velocidade inicial: V 0 = √( (R g) / (2 sen α cos α) ), onde g = 9.8 m/s2
        double VI = Math.sqrt((R * g) / (2 * Math.sin(radiano_alpha) * Math.cos(radiano_alpha)));

//        Tempo de lançamento: T = (2 V0 sen α)/g
        double TL = (2 * VI * Math.sin(radiano_alpha)) / g;

//        Coordenadas
//        while () {
            double x = (VI * Math.cos(radiano_alpha)) * TL;
            double y = (VI * Math.sin(radiano_alpha)) * TL - (g * Math.pow(TL, 2) / 2);


            System.out.println("Velocidade Inicial: " + VI + "m/s");
            System.out.println("Tempo Total: " + TL + "s");

            System.out.print(x);
            System.out.print(y);
        }
    }
//}
