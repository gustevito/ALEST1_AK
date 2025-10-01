public class FilaArray {
    private Integer fila[];
    private int count;
    private int primeiro;
    private int ultimo;

    public FilaArray() {
        fila = new Integer[10];
        count = 0;
        primeiro = 0;
        ultimo = 0;
    }

    public Integer head() {
        if (count == 0)
            throw new EmptyQueueException("A fila esta vazia!");
        return fila[primeiro];
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public void clear() {
        fila = new Integer[10];
        count = 0;
        primeiro = 0;
        ultimo = 0;
    }

    public void enqueue(Integer element) {
        if (count == fila.length)
            throw new FullQueueException("A fila esta cheia!");
        fila[ultimo] = element;
        count++;

        ultimo = (ultimo + 1) % fila.length;
    }

    public Integer dequeue() {
        if (count == 0)
            throw new EmptyQueueException("A fila esta vazia!");
        Integer elem = fila[primeiro];
        fila[primeiro] = null;
        count--;

        primeiro = (primeiro + 1) % fila.length;
        return elem;
    }

}
