public class Pilha {
    private FilaArray fila1;
    private FilaArray fila2;

    public Pilha() {
        fila1 = new FilaArray();
        fila2 = new FilaArray();
    }

    public boolean isEmpty() {
        return fila1.isEmpty();
    }

    public int size() {
        return fila1.size();
    }

    public Integer top() {
        if (isEmpty())
            throw new IllegalStateException("Pilha vazia");
        return fila1.head();
    }

    public void push(Integer elemento) { // complexidade O(n)
        fila2.enqueue(elemento);
        while (!fila1.isEmpty()) {
            fila2.enqueue(fila1.dequeue());
        }
        FilaArray temp = fila1;
        fila1 = fila2;
        fila2 = temp;
    }

    public Integer pop() { // complexidade O(1)
        if (isEmpty())
            throw new IllegalStateException("Pilha vazia");
        return fila1.dequeue();
    }

    public void clear() {
        fila1.clear();
        fila2.clear();
    }

    public void sort() { // acho que é complexidade O(n²) kkkk
        if (fila1.isEmpty())
            return;

        FilaArray tempFila = new FilaArray();
        while (!fila1.isEmpty()) {
            Integer current = fila1.dequeue();
            while (!tempFila.isEmpty() && tempFila.head() > current) {
                fila1.enqueue(tempFila.dequeue());
            }
            tempFila.enqueue(current);
        }

        while (!tempFila.isEmpty()) {
            fila1.enqueue(tempFila.dequeue());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < fila1.size(); i++) {
            Integer elem = fila1.dequeue();
            sb.append(elem);
            if (i < fila1.size()) {
                sb.append(", ");
            }
            fila1.enqueue(elem);
        }
        sb.append("]");
        return sb.toString();
    }
}