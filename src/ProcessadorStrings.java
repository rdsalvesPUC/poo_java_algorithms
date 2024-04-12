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
}
