public class DoubleLinkedListOfInteger {

    private Node header;
    private Node trailer;
    private Node current;
    private int count;

    private class Node {
        public Integer element;
        public Node next;
        public Node prev;

        public Node(Integer e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    public DoubleLinkedListOfInteger() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public int size() {
        return count;
    }

    // metodos de add -----------------------------------

    public void addInicio(Integer element) {
        Node n = new Node(element);

        n.next = header.next;
        n.prev = header;

        header.next.prev = n;

        header.next = n;
        count++;
    }

    public void addFim(Integer element) {
        Node n = new Node(element);

        n.prev = trailer.prev; // n.prev = antigo último nó
        n.next = trailer; // n agora é o último elemento antes de trailer

        trailer.prev.next = n; // antigo último nó aponta para o novo nó (n) / o next do nodo prev agora aponta
                               // para o elemento de n

        trailer.prev = n; // trailer agora reconhece o novo último
        count++;
    }

    public void add(int index, Integer element) {
        Node n = new Node(element);

        current = header;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        n.prev = current.prev;
        n.next = current;

        current.prev.next = n;

        current.prev = n;
        count++;
    }

    // métodos de remove --------------------------------

    public void removeInicio() {
        header.next = header.next.next;
        header.next.next.prev = header;
        count--;
    }

    public void removeFim() {
        trailer.prev = trailer.prev.prev;
        trailer.prev.prev.next = trailer;
        count--;
    }

    public void removeElemento(Integer element) {
        current = header;
        for (int i = 0; i < count; i++) {
            current = current.next;
        }

        if (current == element) {
            current.next.prev = current.prev;
            current.prev.next = current.next;
        }
    }

    public void remove(int index) {
        current = header;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.next.prev = current.prev;
        current.prev.next = current.next;
        count--;
    }

    // toString ---------------------------------------

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node aux = header.next;

        while (aux != null && aux != trailer) {
            sb.append(aux.element);
            if (aux.next != trailer) {
                sb.append(System.lineSeparator());
            }
            aux = aux.next;
        }

        return sb.toString();
    }

}
