import java.util.EmptyStackException;

public class Pilha {

    private LinkedListOfString pilha;

    public Pilha() {
        pilha = new LinkedListOfString();
    }

    public void push(String e) {
        pilha.add(0, e);
    }

    public String pop() {
        if (pilha.isEmpty())
            throw new EmptyStackException();
        return pilha.removeByIndex(0);
    }

    // public String top() {
    // if (pilha.isEmpty())
    // throw new EmptyStackException();
    // return pilha.get(0);
    // }

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
