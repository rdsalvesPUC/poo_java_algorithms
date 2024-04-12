import java.util.Scanner;
public class OperacoesStrings {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite seu texto: ");
        String texto1 = teclado.nextLine();

        System.out.println("\nEscolha a operação que deseja realizar ================= ");
        System.out.println("""
                1 - Converter p/ maiusculas
                2 - Converter p/ minusculas
                3 - Extrair dados
                4 - Localizar dados
                5 - Verificar duplicata""");
        System.out.println("Digite o número da operação: ");
        int operacao = teclado.nextInt();
        teclado.nextLine();

        String texto2 = "";
        int beginIndex = 0;
        int endIndex = 0;
        switch (operacao) {
            case 3:
                System.out.println("Informe o Index inicial: ");
                beginIndex = teclado.nextInt();

                System.out.println("Informe o Index final: ");
                endIndex = teclado.nextInt(); break;
            case 4:
                System.out.println("Informe a substring: ");
                texto2 = teclado.nextLine(); break;
            case 5:
                System.out.println("Digite o segundo texto para comparação: ");
                texto2 = teclado.nextLine();
        }

        String resultado = switch (operacao) {
            case 1 -> ProcessadorStrings.convertUpperCase(texto1);
            case 2 -> ProcessadorStrings.convertLowerCase(texto1);
            case 3 -> ProcessadorStrings.extractData(texto1, beginIndex, endIndex);
            case 4 -> ProcessadorStrings.searchData(texto1, texto2);
            case 5 -> ProcessadorStrings.checkDuplicate(texto1, texto2);
            default -> "Opção inválida";
        };

        System.out.println("\nOperação escolhida: " + operacao);
        System.out.println("Resultado: " + resultado);
    }
}
