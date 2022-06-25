package main.java.com.itisluiz.ordenacao.conjunto;
import java.util.Random;

public class FabricaConjunto
{
    private static final Random rng = new Random();

    public static int[] gerarConjuntoSequencial(int tamanho, boolean reverso)
    {
        int[] conjunto = new int[tamanho];

        for (int i = 0; i < tamanho; ++i)
            conjunto[i] = reverso ? tamanho - (1 + i) : i;

        return conjunto;
    }

    public static int[] trocar(int[] conjunto, int a, int b)
    {
        int aux = conjunto[a];
        conjunto[a] = conjunto[b];
        conjunto[b] = aux;

        return conjunto;
    }

    public static int[] embaralharConjunto(int[] conjunto, float fator)
    {
        fator = Math.min(1.0f, Math.max(-1.0f, fator));

        int inicio = fator > 0.0f ? 0 : Math.round( (1.0f + fator) * (conjunto.length - 1) ) + 1;
        int fim = fator > 0.0f ? Math.round(fator * (conjunto.length - 1) ) : conjunto.length - 1;

        for (int i = inicio; i < fim; ++i)
        {
            int indiceAleatorio = i + rng.nextInt(fim - (i - 1));
            trocar(conjunto, i, indiceAleatorio);
        }

        return conjunto;
    }

    public static boolean ordenado(int[] conjunto)
    {
        if (conjunto.length <= 1)
            return true;

        for (int i = 1; i < conjunto.length; ++i)
            if (conjunto[i - 1] > conjunto[i])
                return false;

        return true;
    }
}
