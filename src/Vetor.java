public class Vetor {
    public static void main(String[] args)
    {
        int[ ] valores = {10, 7, 5, 3, 8};
        organize(valores, 3);
        System.out.println(valores[0]);
        System.out.println(valores[valores.length-1]);
    }
    private static void organize(int v[], int K)
    {
        int capacidade = v.length;
        for (int shift = 0; shift < K; shift++)
        {
            int temp = v[capacidade-1];
            for (int i = capacidade-1; i > 0; i--) v[i] = v[i-1];
            v[0] = temp;
        }
    }
}