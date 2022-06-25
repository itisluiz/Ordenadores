package main.java.com.itisluiz.ordenacao;
import main.java.com.itisluiz.ordenacao.algoritmo.*;
import main.java.com.itisluiz.ordenacao.conjunto.FabricaConjunto;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    private static final Scanner cin = new Scanner(System.in);
    private static double arredondar(double valor)
    {
        return Math.round(valor * 1000.0) / 1000.0;
    }

    public static void main(String[] args)
    {
        // Ordenadores
        Ordenador[] ordenadores = new Ordenador[]{ new BubbleSort(), new HeapSort(), new InsertionSort(),
                new QuickSort(), new SelectionSort(), new ShellSort() };

        // Input de parâmetros
        int elementos = 0;
        while (elementos <= 0)
        {
            System.out.print("Elementos por array: ");
            try { elementos = cin.nextInt(); }
            catch (InputMismatchException e) { cin.nextLine(); }
        }

        int iteracoes = 0;
        while (iteracoes <= 0)
        {
            System.out.print("Iterações por teste: ");
            try { iteracoes = cin.nextInt(); }
            catch (InputMismatchException e) { cin.nextLine(); }
        }

        float fator = Float.NaN;
        while (Float.isNaN(fator) || fator < -1.0f || fator > 1.0f)
        {
            System.out.print("Fator de desorganização: ");
            try { fator = cin.nextFloat(); }
            catch (InputMismatchException e) { cin.nextLine(); }
        }

        // Conjuntos para teste
        int[] conjunto_desordenado = FabricaConjunto.gerarConjuntoSequencial(elementos, false);
        int[] conjunto_quaseordenado = FabricaConjunto.gerarConjuntoSequencial(elementos, false);
        int[] conjunto_ordenadodecrescente = FabricaConjunto.gerarConjuntoSequencial(elementos, true);

        FabricaConjunto.embaralharConjunto(conjunto_desordenado, 1.0f);
        FabricaConjunto.embaralharConjunto(conjunto_quaseordenado, fator);

        // Benchmark e output
        for (Ordenador ordenador : ordenadores)
        {
            System.out.println(ordenador.algoritmo() + " - [Desordenado: " +
                arredondar(ordenador.benchmark(conjunto_desordenado, iteracoes, true)) + "s, Quase ordenado: " +
                arredondar(ordenador.benchmark(conjunto_quaseordenado, iteracoes, false)) + "s, Ordenado decrescente: " +
                arredondar(ordenador.benchmark(conjunto_ordenadodecrescente, iteracoes, false)) + "s]"
            );
        }
    }
}
