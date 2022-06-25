package main.java.com.itisluiz.ordenacao.algoritmo;
import main.java.com.itisluiz.ordenacao.conjunto.FabricaConjunto;

public class ShellSort extends Ordenador
{
    @Override
    public String algoritmo() { return "Shell Sort"; }

    @Override
    public int[] ordenar(int[] conjunto)
    {
        for (int intervalo = conjunto.length / 2; intervalo >= 1; intervalo /= 2)
        {
            for (int i = intervalo; i < conjunto.length; i += intervalo)
                for (int j = i; j > 0 && conjunto[j - intervalo] > conjunto[j]; j -= intervalo)
                {
                    FabricaConjunto.trocar(conjunto, j - intervalo, j);
                }
        }

        return conjunto;
    }
}
