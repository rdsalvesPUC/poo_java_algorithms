import java.util.Scanner;
public class Projetil {
    public static void main(String[] Args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe o angulo de alpha: ");
        int alpha = teclado.nextInt();

        System.out.println("Informa a distancia: ");
        int R = teclado.nextInt();

        double g = 9.8f;

//        Velocidade inicial: V 0 = √( (R g) / (2 sen α cos α) ), onde g = 9.8 m/s2
//        double VI = Math.sqrt((R * g) / (2 * Math.sin(alpha) * Math.cos(alpha)));
//        double VI = Math.sqrt(R * g);
//        double VI = (R * g) / (2 * Math.sin(alpha) * Math.cos(alpha));
        double VI = Math.sin(alpha);
        System.out.println(VI);

////        Tempo de lançamento: T = (2 V0 sen α)/g
//        double TL = (2 * VI * Math.sin(alpha)) / g;
//
////        Coordenadas
//        double x = (VI * Math.cos(alpha)) * TL;
//        double y = (VI * Math.sin(alpha)) * TL - (g * Math.pow(TL, 2) / 2);
//
//
//        System.out.println("Velocidade Inicial: " + VI + "m/s");
//        System.out.println("Tempo Total: " + TL + "s");
//
//        System.out.print(x);
//        System.out.print(y);
    }
}
