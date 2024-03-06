import java.util.Scanner;
public class LeituraDadosIntervalo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        boolean valido = false;
        int number = 0;
        int trys = 5;

//        do {
//            System.out.println("Informe um número de 5 a 10: ");
//            number = teclado.nextInt();
//
//            if (number >= 5 && number <= 10) {
//                System.out.println("Valor " + number + " validado");
//            }
//            else {
//                System.out.println("Valor fora do intervalo, tente novamente.");
//            }
//        } while (number < 5 || number > 10);

//        ####### Tentativas infinitas até acertar
//        while (!valido) {
//            System.out.println("Informa um número de 5 a 10: ");
//            number = teclado.nextInt();
//
//            if (number >= 5 && number <= 10) {
//                System.out.println("Valor aceito");
//                valido = true;
//            }
//            else {
//                System.out.println("Valor fora do intervalo, tente novamente\n");
//            }
//        }

//        ##### Tentativas LIMITADAS a 5
        for (int i = 0; i < trys; i++) {
            System.out.println("Informa um número de 5 a 10: ");
            number = teclado.nextInt();

            if (number >= 5 && number <= 10) {
                System.out.println("Valor aceito");
                valido = true;
            } else {
                System.out.println("Valor fora do intervalo, tente novamente\n");
            }
        }
    }
}
