public class cod {
    public static int f1(int n) {
        int r = 0;
        int op = 0;
        for (int i = 1; i < n; i = i + i) {
            op++;
        }
        return op;
    }

    public static int f2(int n) {
        int r = 0;
        int op = 0;
        for (int i = 1; i < n; i = i + i) {
            for (int j = i + 1; j < n; j++) {
                op = op + 1;
                r = r + 2;
            }
        }
        return op;
    }

    // public static int f3(int n)
    // public static int f4(int n)
    // public static int f5(int n)

    public static void main(String[] args) {
        int op = 0;
        System.out.println("N    |#OP");

        // para cada funcao descomente a linha para chamar a funcao desejada
        for (int n = 1; n < 10; n++) {
            op = f1(n);
            // op = f2(n);
            System.out.println(n + "    |" + op);
        }
    }
}