public class App {
    public static void main(String[] args) {
        Pilha p = new Pilha();
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        p.pop();

        /*
         * int tam = p.size();
         * for(int i=0; i<tam; i++) {
         * System.out.println(p.pop());
         * }
         */
        while (!p.isEmpty()) {
            System.out.println(p.pop());
        }

    }

    public static void inverte(Integer vet[]) {
        String palavra = "almoço";

    }

    public static Pilha getClone(Pilha p) {
        return null;
    }

    public static void addAll(Pilha p, LinkedListOfInteger l) {

    }
}
