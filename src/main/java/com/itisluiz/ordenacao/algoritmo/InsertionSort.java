package main.java.com.itisluiz.ordenacao.algoritmo;
import main.java.com.itisluiz.ordenacao.conjunto.FabricaConjunto;

public class InsertionSort extends Ordenador
{
    @Override
    public String algoritmo() { return "Insertion Sort"; }

    @Override
    public int[] ordenar(int[] conjunto)
    {
        for (int i = 1; i < conjunto.length; ++i)
            for (int j = i; j > 0 && conjunto[j - 1] > conjunto[j]; --j)
            {
                FabricaConjunto.trocar(conjunto, j - 1, j);
            }

        return conjunto;
    }
}
