public class exercicio1 {
    public static void main(String[] args) {
        int[] entradas = {10, 20, 30, 40, 50, 100};

        for (int n : entradas) {
            // iterativa
            long inicioIt = System.nanoTime();
            int resultadoIt = funcaoIt(n);
            long fimIt = System.nanoTime();
            long tempoIt = fimIt - inicioIt;

            // recursiva
            long inicioRec = System.nanoTime();
            int resultadoRec = funcaoRec(n);
            long fimRec = System.nanoTime();
            long tempoRec = fimRec - inicioRec;

            System.out.println("N = " + n);
            System.out.println("ITERATIVA: \nResultado = " + resultadoIt + " \nTempo = " + tempoIt + " ns");
            System.out.println("\nRECURSIVA: \nResultado = " + resultadoRec + " \nTempo = " + tempoRec + " ns");
            System.out.println("---------------------------");
        }
    }

    public static int funcaoIt(int n) {
        int soma = 0;
        for (int i = 1; i <= n; i++) {
            soma += i;
        }
        return soma;
    }

    public static int funcaoRec(int n) {
        if (n == 1) return 1;
        return n + funcaoRec(n - 1);
    }
}
