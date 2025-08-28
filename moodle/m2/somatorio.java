public class somatorio {
    // Exemplo: para n=5 -> 1+2+3+4+5=15
    // Variáveis para contagem de operações
    static int iterativaOperacoes = 0;
    static int recursivaOperacoes = 0;

    // Função iterativa
    public static long funcaoIt(int n) {
        long soma = 0;
        iterativaOperacoes++; // Var contagem
        for (int i = 1; i <= n; i++) {
            soma += i;
            /*
             * Cada operação de soma dentro do laço for e a própria iteração são contadas
             * como operações individuais.
             */
            iterativaOperacoes += 2;
        }
        return soma;
    }

    // Função recursiva
    public static long funcaoRe(int n) {
        recursivaOperacoes++; // Var contagem
        if (n == 1) {
            /*
             * Cada chamada recursiva e cada operação de soma são contadas. A verificação da
             * condição (n == 1) também é contada como uma operação.
             */
            recursivaOperacoes++;
            return 1;
        }
        return n + funcaoRe(n - 1);
    }

    public static void main(String[] args) {
        int[] entradas = { 10, 20, 30, 40, 50, 100 };

        System.out.println("Tamanho\tOperações Iterativa\tOperações Recursiva");

        for (int n : entradas) {
            iterativaOperacoes = 0;
            recursivaOperacoes = 0;
            funcaoIt(n);
            funcaoRe(n);
            System.out.println(iterativaOperacoes);

        }
    }
}
