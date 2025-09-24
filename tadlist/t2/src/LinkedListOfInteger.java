public class LinkedListOfInteger {

    private class Node {
        public Integer element;
        public Node next;

        public Node(Integer element) {
            this.element = element;
            next = null;
        }

        public Node(Integer element, Node next) {
            this.element = element;
            this.next = next;
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

    // metodos ------------------------------------
    public boolean isEmpty() {
        return (head == null);
    }

    public int size() {
        return count;
    }

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    public void add(int index, Integer element) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();

        Node n = new Node(element);

        if (index == 0) {
            if (count == 0) {
                tail = n;
            } else {
                n.next = head;
            }
            head = n;
        } else if (index == count) {
            tail.next = n;
            tail = n;
        } else {
            Node ant = head;
            for (int i = 0; i < index - 1; i++) {
                ant = ant.next;
            }
            n.next = ant.next;
            ant.next = n;
        }

        count++;
    }

    public void addInicio(Integer element) {
        Node n = new Node(element);

        if (count == 0) {
            head = n;
            tail = n.next;
        }

        n.next = head.next;
        head.next = n;
        count++;
    }

    public void addFim(Integer element) {
        Node n = new Node(element);

        if (count == 0) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        count++;
    }

    /*
     * public Integer get(Integer index) {
     * if (index < 0 || index > count) {
     * throw new IndexOutOfBoundsException();
     * }
     * if (index == count) {
     * return tail.element;
     * }
     * if (index == 1) {
     * return head.element;
     * }
     * }
     */

    public Integer set(int index, Integer element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == count - 1) {
            Integer currentElement = tail.element;
            tail.element = element;
            return currentElement;
        }

        Node current = head;
        int c = 0;
        while (c < index) {
            current = current.next;
            c++;
        }
        Integer currentElement = current.element;
        current.element = element;
        return currentElement;
    }

    public boolean contains(Integer element) {
        Node current = head;
        while (current != null) {
            if (current.element.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean remove(Integer element) {
        if (count == 0)
            return false;

        if (element.equals(head.element)) {
            if (count == 1) {
                tail = null;
            }
            head = head.next;
            count--;
            return true;
        }

        Node ant = head;
        Node current = head.next;

        for (int i = 1; i < count; i++) {
            if (current.element.equals(element)) {
                if (current == tail) {
                    tail = ant;
                    tail.next = null;
                } else {
                    ant.next = current.next;
                }
                count--;
                return true;
            }
            current = current.next;
            ant = ant.next;
        }
        return false;
    }

    // toString ------------------------------------
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Node current = head;

        while (current != null) {
            s.append(current.element.toString());
            s.append("\n");
            current = current.next;
        }

        return s.toString();
    }

}