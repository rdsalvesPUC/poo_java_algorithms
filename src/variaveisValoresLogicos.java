import java.util.Scanner;
public class variaveisValoresLogicos {
    public static void main(String[] args)
    {
//        boolean cheio = false;
//        boolean aprovado = true;
//        cheio = true;
//        System.out.println( cheio );
//        aprovado = false;
//        System.out.println( aprovado );

        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o valor de k: ");
        int k = teclado.nextInt();
        switch ( k )
        {
            case 0: k = (k + 5) * 3; break;
            case 1: k = k + 5; k = k * k; break;
            case 2: k = k * 3; k = k / 2; break;
            default: k = 0;
        }
        System.out.println( k );
    }
}
