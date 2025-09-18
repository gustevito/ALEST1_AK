import java.util.EmptyStackException;

public class Pilha {

    private LinkedListOfInteger pilha;

    public Pilha() {
        pilha = new LinkedListOfInteger();
    }

    public void push(Integer e) {
        pilha.add(0, e);
    }

    public Integer pop() {
        if (pilha.isEmpty())
            throw new EmptyStackException();
        return pilha.removeByIndex(0);
    }

    public Integer top() {
        if (pilha.isEmpty())
            throw new EmptyStackException();
        return pilha.get(0);
    }

    public int size() {
        return pilha.size();
    }

    public boolean isEmpty() {
        return pilha.isEmpty();
    }

    public void clear() {
        pilha.clear();
    }
}
