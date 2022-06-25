package main.java.com.itisluiz.ordenacao.algoritmo;
import main.java.com.itisluiz.ordenacao.conjunto.FabricaConjunto;

public class HeapSort extends Ordenador
{
    @Override
    public String algoritmo() { return "Heap Sort"; }

    private int indiceEsquerda(int parente) { return 2 * parente + 1; }
    private int indiceDireita(int parente) { return 2 * parente + 2; }

    private int peneirarMaior(int[] conjunto, int indice, int escopo)
    {
        int maiorIndice = indice;

        if (this.indiceEsquerda(indice) <= escopo && conjunto[this.indiceEsquerda(indice)] > conjunto[maiorIndice])
            maiorIndice = this.indiceEsquerda(indice);

        if (this.indiceDireita(indice) <= escopo && conjunto[this.indiceDireita(indice)] > conjunto[maiorIndice])
            maiorIndice = this.indiceDireita(indice);

        if (maiorIndice != indice)
            FabricaConjunto.trocar(conjunto, indice, maiorIndice);

        return maiorIndice - 1;
    }

    @Override
    public int[] ordenar(int[] conjunto)
    {
        int escopo = conjunto.length - 1;
        while (escopo > 0) {
            int indice = escopo / 2;

            while (indice >= 0)
                indice = this.peneirarMaior(conjunto, indice, escopo);

            FabricaConjunto.trocar(conjunto, 0, escopo--);
        }

        return conjunto;
    }
}