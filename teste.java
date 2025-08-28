public class teste {
    public static void main(String[] args) {
        int V = 15; // Você pode trocar o valor de V aqui
        int count = 0;
        int operacoes = 0;

        for (int start = 1; start <= V; start++) {
            int soma = 0;
            for (int end = start; end <= V; end++) {
                soma += end;
                operacoes++; // Conta a operação de soma
                if (soma == V) {
                    count++;
                    break; // Não precisa continuar, pois já atingiu V
                }
                if (soma > V) {
                    break; // Não precisa continuar, pois já passou de V
                }
            }
        }
        System.out.println("Número de sequências: " + count);
        System.out.println("Operações de soma realizadas: " + operacoes);
    }
}