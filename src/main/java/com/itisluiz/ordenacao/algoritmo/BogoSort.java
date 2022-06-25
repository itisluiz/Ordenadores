package main.java.com.itisluiz.ordenacao.algoritmo;
import main.java.com.itisluiz.ordenacao.conjunto.FabricaConjunto;

public class BogoSort extends Ordenador
{
    @Override
    public String algoritmo() { return "Bogo Sort"; }

    @Override
    public int[] ordenar(int[] conjunto)
    {
        while (!FabricaConjunto.ordenado(conjunto))
            FabricaConjunto.embaralharConjunto(conjunto, 1.0f);

        return conjunto;
    }
}