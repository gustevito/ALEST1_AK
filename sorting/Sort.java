import java.util.Arrays;

public class Sort{
    public static void main(String[] args) {

        int[] v = {4, 2, 5, 7, 3, 6, 1};

        String lista = Arrays.toString(v);
        System.out.println("Lista desordenada: " + lista);
        // BubbleSort(v);
        // InsertionSort(hs);
        MergeSort(v);
        // QuickSort(v);
        lista = Arrays.toString(v);
        System.out.println("Lista ordenada: " + lista);
    }

    public static void BubbleSort(int[] v){
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v.length; j++) { 
                if (v[j] > v[j + 1]) {
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                }   
            }
        }
    }

    public static void InsertionSort(int[] v){
        for (int i = 0; i < v.length - 1; i++) {
            int pivo = v[i];
            int j = i - 1;

            while(j >= 0 && v[j] > pivo){
                v[j + 1] = v[j];
                j--;
            }

            v[j + 1] = pivo;
            
        }
    }













    
    public static void MergeSort(int[] v){
        int n = v.length;
        if(n <= 1) return;

        int meio = (n/2);
        int[] esq = new int[meio];
        int[] dir = new int[n - meio];

        int i = 0;
        int j = 0;
        for (; i < n; i++) {
            if (i < meio) {
                esq[i] = v[i];
            } else{
                dir[j] = v[i];
                j++;
            }
        }

        MergeSort(esq);
        MergeSort(dir);
        merge(esq, dir, v);
    }
    
    public static void merge(int[] esq, int[] dir, int[] v){
        int tamanhoEsquerda = (v.length/2);
        int tamanhoDireita = (v.length - tamanhoEsquerda);

        int i = 0, e = 0, d = 0;

        while(e < tamanhoEsquerda && d < tamanhoDireita){
            if (esq[e] < dir[d]) {
                v[i] = esq[e];
                i++;
                e++;
            }
            else{
                v[i] = dir[d];
                i++;
                d++;
            }
        }

        while(e < tamanhoEsquerda){
            v[i] = esq[e];
            i++;
            e++;
        }
        while(d < tamanhoDireita){
            v[i] = dir[d];
            i++;
            d++;
        }        
    }
}