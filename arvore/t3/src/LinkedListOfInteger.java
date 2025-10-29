import java.util.Iterator;

public class LinkedListOfInteger implements Iterable<Integer> {
    private class Node {
        public Integer element;
        public Node next;

        public Node(Integer element) {
            this.element = element;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public LinkedListOfInteger() {
        head = null;
        tail = null;
        count = 0;
    }

    public void add(Integer element) {
        Node novo = new Node(element);
        if (head == null) {
            head = novo;
            tail = novo;
        } else {
            tail.next = novo;
            tail = novo;
        }
        count++;
    }

    public void add(int index, Integer element) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        }

        Node novo = new Node(element);

        if (index == 0) {
            novo.next = head;
            head = novo;
            if (count == 0) {
                tail = novo;
            }
        } else if (index == count) {
            tail.next = novo;
            tail = novo;
        } else {
            Node anterior = head;
            for (int i = 0; i < index - 1; i++) {
                anterior = anterior.next;
            }
            novo.next = anterior.next;
            anterior.next = novo;
        }
        count++;
    }

    public Integer get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        Node aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        return aux.element;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    public boolean contains(Integer element) {
        Node aux = head;
        while (aux != null) {
            if (aux.element.equals(element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                Integer element = current.element;
                current = current.next;
                return element;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        Node aux = head;
        while (aux != null) {
            str.append(aux.element);
            if (aux.next != null) {
                str.append(", ");
            }
            aux = aux.next;
        }
        str.append("]");
        return str.toString();
    }
}