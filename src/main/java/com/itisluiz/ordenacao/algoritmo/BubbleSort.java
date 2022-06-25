package main.java.com.itisluiz.ordenacao.algoritmo;
import main.java.com.itisluiz.ordenacao.conjunto.FabricaConjunto;

public class BubbleSort extends Ordenador
{
    @Override
    public String algoritmo() { return "Bubble Sort"; }

    @Override
    public int[] ordenar(int[] conjunto)
    {
        for(int i = 0; i < conjunto.length; ++i)
            for(int j = 0; j < conjunto.length - (1 + i); ++j)
            {
                if(conjunto[j] > conjunto[j + 1])
                    FabricaConjunto.trocar(conjunto, j, j + 1);
            }

        return conjunto;
    }
}
