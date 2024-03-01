import java.util.Scanner;
public class oprMathBasics {
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o primeiro operando: ");
        float value1 = teclado.nextFloat();

        System.out.println("Digite o segundo operando: ");
        float value2 = teclado.nextFloat();

        System.out.println("Operações disponíveis: \n 1 - Adição \n 2 - Subtração \n 3 - Multiplicação \n 4 - Divisão \nDigite a sua escolha: ");
        int operacao = teclado.nextInt();

        float resultado = 0;

        switch (operacao)
        {
            case 1: resultado = value1 + value2; break;
            case 2: resultado = value1 - value2; break;
            case 3: resultado = value1 * value2; break;
            case 4: resultado = value1 / value2;
        }

        System.out.println("Resultado: " + resultado);
    }
}
