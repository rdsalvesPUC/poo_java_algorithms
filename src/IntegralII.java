import java.util.Scanner;

public class IntegralII {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Ler os valores de a e b
        System.out.println("Informe a: ");
        double a = teclado.nextDouble();

        System.out.println("Informe b: ");
        double b = teclado.nextDouble();

        // Verificar se a <= b
        if (a <= b) {
            // Ler o valor de n
            System.out.println("Informe n: ");
            int n = teclado.nextInt();

            // Verificar se n é maior que zero
            if (n > 0) {
                // Inicializar as variáveis
                double area_total = 0;
                double x = a;
                double h = (b - a) / n;
                double y1 = f(x);
                int i = 0;

                // Calcular a área usando o método do trapézio
                while (i < n) {
                    x = x + h;
                    double y2 = f(x);
                    double area_trapezio = ((y1 + y2) / 2) * h;
                    area_total = area_total + area_trapezio;
                    y1 = y2;
                    i = i + 1;
                }

                // Escrever a área total calculada
                System.out.println("A área total é: " + area_total);
            } else {
                // Escrever mensagem de erro se n não for maior que zero
                System.out.println("Erro: o valor de n deve ser maior que zero");
            }
        } else {
            // Escrever mensagem de erro se a não for menor ou igual a b
            System.out.println("Erro: valor de a deve ser menor ou igual ao valor de b");
        }
    }

    // Função f(x) para calcular y com base em x
    public static double f(double x) {
        // Aqui você pode implementar a função f(x) desejada
        // Neste exemplo, vamos usar uma função simples, como x^2
        return x * x;
    }
}
