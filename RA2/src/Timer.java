public class Timer {
    private static int tempo = 0;
    public static void aguardar(int segundos)
    {
        // Suspende o processamento pelo número de segundos fornecido
        // como parâmetro e avança o tempo
        try
        {
            int milisegundos = segundos * 1000;
            Thread.sleep(milisegundos); // suspende o processamento
            tempo = tempo + segundos;
        }
        catch ( Exception e ) {}
    }
    public static String tempo() { return "[T = " + tempo + "] "; }
}