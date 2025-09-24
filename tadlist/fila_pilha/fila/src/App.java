
public class App {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------");
        System.out.println("FILA 1:");
        FilaArray f1 = new FilaArray();
        f1.enqueue(10);
        f1.enqueue(20);
        f1.enqueue(30);
        f1.enqueue(40);

        for (int i = 0; i < f1.size(); i++) {
            System.out.print("|" + f1.head() + "| ");
            f1.enqueue(f1.dequeue());
        }

        System.out.println("Tamanho da fila: " + f1.size());

        System.out.println("\nFILA 2:");
        FilaArray f2 = new FilaArray();
        f2.enqueue(1);
        f2.enqueue(2);
        f2.enqueue(3);
        f2.enqueue(4);

        for (int i = 0; i < f2.size(); i++) {
            System.out.print("|" + f2.head() + "| ");
            f2.enqueue(f2.dequeue());
        }

        System.out.println("Tamanho da fila: " + f2.size());
        System.out.println("-----------------------------------------");

        System.out.println("FILA CONCATENADA (desordenada):");
        FilaArray f3 = new FilaArray();
        f3 = concatena(f1, f2);

        for (int i = 0; i < f3.size(); i++) {
            System.out.print("|" + f3.head() + "| ");
            f3.enqueue(f3.dequeue());
        }

        System.out.println("\n-----------------------------------------");

    }

    public static FilaArray concatena(FilaArray q, FilaArray w) {
        FilaArray f3 = new FilaArray();

        for (int i = 0; i < q.size(); i++) {
            Integer e = q.dequeue();
            f3.enqueue(e);
            q.enqueue(e);
        }

        for (int i = 0; i < w.size(); i++) {
            Integer e = w.dequeue();
            f3.enqueue(e);
            w.enqueue(e);
        }

        return f3;
    }
}
