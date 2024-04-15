public class ProcessadorStrings {

    public static String convertUpperCase(String texto1) {
        return texto1.toUpperCase();
    }
    public static String convertLowerCase(String texto1) {
        return texto1.toLowerCase();
    }
    public static String extractData(String texto1, int a, int z) {
        return texto1.substring(a, z);
    }
    public static String searchData(String texto1, String texto2) {
        return String.valueOf(texto1.indexOf(texto2));
    }
    public static String checkDuplicate(String texto1, String texto2) {
        return texto1.equals(texto2) ? "Duplicado" : "Não duplicado";
    }

    public static void anatomy(String texto1) {
        texto1 = texto1.toLowerCase();

        int vogaisCounter = 0;
        int consoantesCounter = 0;
        int neitherCounter = 0;
    
        char[] vogais = {'a','e','i','o','u'};
        char[] consoantes = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','u','v','x','w','y','z'};
        
        for (int i = 0; i < texto1.length(); i++) {
            for (int j = 0; j < vogais.length; j++) {
                if (texto1.charAt(i) == vogais[j]) {
                    vogaisCounter++;
                }
            }
        }
    
        for (int i = 0; i < texto1.length(); i++) {
            for (int j = 0; j < consoantes.length; j++) {
                if (texto1.charAt(i) == consoantes[j]) {
                    consoantesCounter++;
                }
            }
        }
    
        for (int i = 0; i < texto1.length(); i++) {
            if (Character.isDigit(texto1.charAt(i))) {
                neitherCounter++;
            }
        }
    
        System.out.println("Vogais: " + vogaisCounter);
        System.out.println("Consoantes: " + consoantesCounter);
        System.out.println("Outros Caracteres: " + neitherCounter);
    }
//    public static void convert() {
//        String dataConverted = "";
//
//
//
//        return dataConverted;
//    }
    public static String criptografar(String texto) {
        String newString = "";

        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            letra = (char) (letra + 5);
            newString += letra;
        }

        return newString;
    }
    public static String localizar(char letra) {

        if (Character.isLetter(letra)) {
            letra = Character.toUpperCase(letra);
            int posicao = letra - 'A' + 1;
            return "A letra " + letra + " está na posição " + posicao;
        }
        else {
            return "Dado inválido, tente novamente!";
        }
    }
}
