package main.java.com.itisluiz.ordenacao.algoritmo;

import java.util.Arrays;

public abstract class Ordenador
{
    public abstract String algoritmo();
    public abstract int[] ordenar(int[] conjunto);

    public double benchmark(int[] conjunto, int iteracoes, boolean print)
    {
        double tempoTotal = 0.0;

        for (int i = 0; i < iteracoes; ++i)
        {
            int[] copiaConjunto = conjunto.clone();

            if (copiaConjunto.length <= 100 && print)
                System.out.println("Antes: " + Arrays.toString(copiaConjunto));

            final long ti = System.currentTimeMillis();
            this.ordenar(copiaConjunto);
            final long tf = System.currentTimeMillis();

            if (copiaConjunto.length <= 100 && print)
                System.out.println("Depois: " + Arrays.toString(copiaConjunto));

            tempoTotal += (tf - ti) / 1000.0;
        }

        return tempoTotal / iteracoes;
    }
}