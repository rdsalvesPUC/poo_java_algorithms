import java.util.Scanner;
public class Integral {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe a: ");
        double a = teclado.nextDouble();

        System.out.println("Informe b: ");
        double b = teclado.nextDouble();

        if (a <= b){
            System.out.println("Informe n: ");
            int n =  teclado.nextInt();

            if (n > 0) {
                double area_total = 0;
                double x = a;
                double h = (b - a) / n;
//                double y1 = Math.PI / x;
                double y1 = Math.pow(x, 2);
                int i = 0;

                while (i < n) {
                    x = x + h;
//                    double y2 = Math.PI / x;
                    double y2 = Math.pow(x, 2);
                    double area_trapezio = ((y1 + y2) / 2) * h;
                    area_total = area_total + area_trapezio;
                    y1 = y2;
                    i++;
                }
                System.out.println(area_total);
            }
            else {
                System.out.println("Erro: o valor de N deve ser maior que zero");
            }
        }
        else {
            System.out.println("Erro: valor de A deve ser menor ou igual ao valor de B");
        }
    }
}
