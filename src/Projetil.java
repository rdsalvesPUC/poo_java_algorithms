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

        System.out.printf("Velocidade Inicial: %.4fm/s\n", VI);
        System.out.printf("Tempo Total: %.2fs\n", TL);

//        Coordenadas
        double time = 0;
        while (time <= TL) {

            time = time + 0.1;
            double x = VI * Math.cos(radiano_alpha) * time;
            double y = (VI * Math.sin(radiano_alpha)) * time - (g * Math.pow(time, 2) / 2);

            System.out.printf("t=%.1f (%.2f - %.2f)\n", time, x, y);
        }
    }
}
