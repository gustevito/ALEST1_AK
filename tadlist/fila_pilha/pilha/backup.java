import java.util.EmptyStackException;

public class backup {

    private FilaArray f1;
    private FilaArray f2;

    public Pilha() {
        f1 = new FilaArray();
    }

    public int size() {
        return f1.size();
    }

    public void push(Integer e) {
        f1.enqueue(e);
    }

    public Integer pop() {
        if (f1.isEmpty())
            throw new EmptyStackException();

        while (f1.size() > 1) {
            if (f2 == null)
                f2 = new FilaArray();
            f2.enqueue(f1.dequeue());
        }
        Integer elem = f1.dequeue();

        FilaArray temp = f1;
        f1 = f2;
        f2 = temp;

        return elem;
    }

    // exibicao da pilha
    public String toString() {
        String s = "[";
        for (int i = 0; i < f1.size(); i++) {
            s += f1.dequeue();
            if (i < f1.size() - 1) {
                s += ", ";
            }
        }
        s += "]";
        return s;
    }

}
