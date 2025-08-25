import java.util.*;

public class RankingCorridas {
    
    public static void main(String[] args) {
        // 1. Criar lista de tempos
        ArrayList<Double> tempos = new ArrayList<>(List.of(
            41.32, 55.87, 38.45, 69.21, 44.12, 36.78, 50.33, 47.29, 62.41, 39.57,
            48.90, 56.12, 43.67, 37.84, 51.24, 45.91, 63.55, 42.78, 49.66, 40.88,
            54.11, 46.72, 60.35, 39.99, 52.47, 41.05, 57.33, 44.88, 65.12, 38.76,
            53.21, 47.55, 61.23, 40.45, 49.88, 42.34, 59.12, 43.45, 66.78, 37.12,
            51.88, 48.23, 63.12, 39.56, 55.44, 41.76, 67.33, 44.56, 58.22, 36.99,
            50.12, 46.87, 64.45, 38.88, 53.76, 42.65, 60.78, 43.99, 68.21, 37.45,
            52.33, 47.99, 61.88, 40.12, 49.55, 42.87, 59.76, 44.22, 65.88, 38.34,
            54.33, 46.12, 62.45, 39.78, 56.55, 41.99, 67.88, 43.12, 58.99, 36.45,
            51.55, 48.66, 64.78, 38.12, 53.12, 42.45, 60.12, 44.88, 66.12, 37.66,
            52.88, 47.34, 61.55, 40.66, 50.99, 42.12, 59.33, 43.56, 65.33, 38.45
        ));
        
        System.out.println("=== RANKING DE CORRIDAS ===\n");
        
        // Imprimir lista original
        System.out.println("LISTA ORIGINAL:");
        imprimirLista(tempos);
        
        // 2. Ordenação com dois algoritmos
        
        // Algoritmo 1: Merge Sort (ordem crescente)
        ArrayList<Double> temposCrescente = new ArrayList<>(tempos);
        long inicio = System.nanoTime();
        mergeSort(temposCrescente, 0, temposCrescente.size() - 1);
        long fim = System.nanoTime();
        long tempoMergeSort = fim - inicio;
        
        System.out.println("\nLISTA ORDENADA CRESCENTE (Merge Sort):");
        imprimirLista(temposCrescente);
        System.out.println("Tempo execução Merge Sort: " + tempoMergeSort + " nanosegundos");
        
        // Algoritmo 2: Quick Sort (ordem decrescente)
        ArrayList<Double> temposDecrescente = new ArrayList<>(tempos);
        inicio = System.nanoTime();
        quickSortDecrescente(temposDecrescente, 0, temposDecrescente.size() - 1);
        fim = System.nanoTime();
        long tempoQuickSort = fim - inicio;
        
        System.out.println("\nLISTA ORDENADA DECRESCENTE (Quick Sort):");
        imprimirLista(temposDecrescente);
        System.out.println("Tempo execução Quick Sort: " + tempoQuickSort + " nanosegundos");
        
        // 3. Busca
        double tempoBuscado = 42.0;
        System.out.println("\n=== RESULTADOS DE BUSCA ===");
        
        // Busca Linear na lista original
        int posicaoLinear = buscaLinear(tempos, tempoBuscado);
        System.out.println("Busca Linear por " + tempoBuscado + ": " + 
                          (posicaoLinear != -1 ? "Encontrado na posição " + posicaoLinear : "Não encontrado"));
        
        // Busca Binária na lista ordenada
        int posicaoBinaria = buscaBinaria(temposCrescente, tempoBuscado);
        System.out.println("Busca Binária por " + tempoBuscado + ": " + 
                          (posicaoBinaria != -1 ? "Encontrado na posição " + posicaoBinaria : "Não encontrado"));
        
        // Melhor tempo (primeiro da lista ordenada crescente)
        double melhorTempo = temposCrescente.get(0);
        System.out.println("Melhor tempo: " + melhorTempo + " minutos");
        System.out.println("Posição do melhor tempo na lista original: " + buscaLinear(tempos, melhorTempo));
        
        System.out.println("\n=== COMPARAÇÃO DE PERFORMANCE ===");
        System.out.println("Merge Sort: " + tempoMergeSort + " ns");
        System.out.println("Quick Sort: " + tempoQuickSort + " ns");
        System.out.println("Algoritmo mais rápido: " + (tempoMergeSort < tempoQuickSort ? "Merge Sort" : "Quick Sort"));
    }
    
    // ============ ALGORITMOS DE ORDENAÇÃO ============
    
    // Merge Sort (crescente)
    public static void mergeSort(ArrayList<Double> lista, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(lista, inicio, meio);
            mergeSort(lista, meio + 1, fim);
            merge(lista, inicio, meio, fim);
        }
    }
    
    private static void merge(ArrayList<Double> lista, int inicio, int meio, int fim) {
        ArrayList<Double> temp = new ArrayList<>(lista.subList(inicio, fim + 1));
        
        int i = 0, j = meio - inicio + 1, k = inicio;
        
        while (i <= meio - inicio && j <= fim - inicio) {
            if (temp.get(i) <= temp.get(j)) {
                lista.set(k++, temp.get(i++));
            } else {
                lista.set(k++, temp.get(j++));
            }
        }
        
        while (i <= meio - inicio) {
            lista.set(k++, temp.get(i++));
        }
        
        while (j <= fim - inicio) {
            lista.set(k++, temp.get(j++));
        }
    }
    
    // Quick Sort (decrescente)
    public static void quickSortDecrescente(ArrayList<Double> lista, int baixo, int alto) {
        if (baixo < alto) {
            int pi = partitionDecrescente(lista, baixo, alto);
            quickSortDecrescente(lista, baixo, pi - 1);
            quickSortDecrescente(lista, pi + 1, alto);
        }
    }
    
    private static int partitionDecrescente(ArrayList<Double> lista, int baixo, int alto) {
        double pivot = lista.get(alto);
        int i = baixo - 1;
        
        for (int j = baixo; j < alto; j++) {
            if (lista.get(j) >= pivot) { // >= para ordem decrescente
                i++;
                Collections.swap(lista, i, j);
            }
        }
        Collections.swap(lista, i + 1, alto);
        return i + 1;
    }
    
    // ============ ALGORITMOS DE BUSCA ============
    
    // Busca Linear
    public static int buscaLinear(ArrayList<Double> lista, double valor) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(valor)) {
                return i;
            }
        }
        return -1;
    }
    
    // Busca Binária (para lista ordenada)
    public static int buscaBinaria(ArrayList<Double> lista, double valor) {
        int inicio = 0, fim = lista.size() - 1;
        
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            double valorMeio = lista.get(meio);
            
            if (valorMeio == valor) {
                return meio;
            } else if (valorMeio < valor) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }
    
    // ============ UTILITÁRIOS ============
    
    private static void imprimirLista(ArrayList<Double> lista) {
        System.out.print("[");
        for (int i = 0; i < Math.min(10, lista.size()); i++) {
            System.out.print(String.format("%.2f", lista.get(i)));
            if (i < Math.min(9, lista.size() - 1)) System.out.print(", ");
        }
        if (lista.size() > 10) {
            System.out.print(" ... (" + lista.size() + " elementos total)");
        }
        System.out.println("]");
    }
}