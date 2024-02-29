import java.util.Scanner;
public class funcaoMatematicaI {
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite x: ");
        double x = teclado.nextDouble();

        if (x == 0 || x == 4)
            System.out.println("O valor de X não pode ser " + (int)x);
        else
        {
            double y = Math.sqrt(x) / (x - 4);
            System.out.println(y);
        }


//        if (x == 0)
//            System.out.println("O valor de x não pode ser 0");
//        else
//        {
//            if (x == 4)
//                System.out.println("O valor de x não pode ser 4");
//            else
//            {
//                double y = Math.sqrt(x) / (x - 4);
//                System.out.println(y);
//            }
//
//        }

    }
}
