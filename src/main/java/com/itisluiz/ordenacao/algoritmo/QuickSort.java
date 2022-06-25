package main.java.com.itisluiz.ordenacao.algoritmo;
import main.java.com.itisluiz.ordenacao.conjunto.FabricaConjunto;
import java.util.Stack;

public class QuickSort extends Ordenador
{
    private static class Alcance
    {
        int de;
        int ate;

        Alcance(int de, int ate)
        {
            this.de = de;
            this.ate = ate;
        }
    }

    private int[] ordenar(int[] conjunto, Stack<Alcance> subconjuntos, Alcance alcance)
    {
        int pivo = alcance.ate;

        for (int i = alcance.de; i < pivo; ++i)
        {
            if (conjunto[i] > conjunto[pivo])
                for (int j = pivo - 1; j >= alcance.de; --j)
                {
                    if (conjunto[j] < conjunto[pivo])
                        FabricaConjunto.trocar(conjunto, i, j);
                    else if (i == j)
                    {
                        FabricaConjunto.trocar(conjunto, pivo, i);
                        pivo = i;
                    }
                    else
                        continue;

                    break;
                }
        }

        if (pivo - alcance.de > 1)
            subconjuntos.add(new Alcance(alcance.de, pivo - 1));

        if (alcance.ate - pivo > 1)
            subconjuntos.add(new Alcance(pivo + 1, alcance.ate));

        return conjunto;
    }

    @Override
    public String algoritmo() { return "Quick Sort"; }

    @Override
    public int[] ordenar(int[] conjunto)
    {
        // Alternativa à recursão para impedir estouro da pilha
        Stack<Alcance> subconjuntos = new Stack<Alcance>();
        subconjuntos.push(new Alcance(0, conjunto.length - 1));

        while (!subconjuntos.isEmpty())
            this.ordenar(conjunto, subconjuntos, subconjuntos.pop());

        return conjunto;
    }
}
