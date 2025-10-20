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

    public void insertSorted(Integer element) {
        Node n = new Node(element);

        current = header.next;
        while (current != trailer && current.element < element) {
            current = current.next;
        }

        n.prev = current.prev;
        n.next = current;

        current.prev.next = n;
        current.prev = n;
        count++;
    }

    public void inverter() {
        Node left = header.next;
        Node right = trailer.prev;

        for (int i = 0; i < count / 2; i++) {
            Integer temp = left.element;
            left.element = right.element;
            right.element = temp;

            left = left.next;
            right = right.prev;
        }
    }

    public void addAll(LinkedListOfInteger list) {
        Node aux = new Node(0);
        for (int i = 0; i < list.size(); i++) {
            aux.element = list.get(i);
            addFim(aux.element);
        }
    }

    public boolean hasRepetidos() {
        Node aux = new Node(0);

        current = header.next;
        for (Integer i = 0; i < count; i++) {
            aux.element = i;
            if (aux.element.equals(current.element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // toString ---------------------------------------

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node aux = header.next;

        sb.append("{ ");
        while (aux != null && aux != trailer) {
            sb.append(aux.element);
            if (aux.next != trailer) {
                sb.append(", "); // Adiciona espaço entre elementos na mesma linha
            }
            aux = aux.next;
        }
        sb.append(" }");

        return sb.toString();
    }

}
