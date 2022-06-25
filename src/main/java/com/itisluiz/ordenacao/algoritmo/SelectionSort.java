package main.java.com.itisluiz.ordenacao.algoritmo;
import main.java.com.itisluiz.ordenacao.conjunto.FabricaConjunto;

public class SelectionSort extends Ordenador
{
    @Override
    public String algoritmo() { return "Selection Sort"; }

    @Override
    public int[] ordenar(int[] conjunto)
    {
        for (int i = 0; i < conjunto.length; ++i)
        {
            int menor = i;

            for (int j = i; j < conjunto.length; ++j)
                if (conjunto[j] < conjunto[menor])
                    menor = j;

            FabricaConjunto.trocar(conjunto, menor, i);
        }

        return conjunto;
    }
}
