public class LinkedListOfInteger {

    private Node head;
    private Node tail;
    private int count;

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

    // Construtor da lista
    public LinkedListOfInteger() {
        head = null;
        tail = null;
        count = 0;
    }

    // Esvazia a lista

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    // Adiciona um elemento ao final da lista.

    public void add(Integer element) {
        Node n = new Node(element);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        count++;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Node aux = head;

        while (aux != null) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }

        return s.toString();
    }

    ///////////////////////////////////////////////////
    //// EXERCICIOS - VEJA SLIDES E ENUNACIADO
    ///////////////////////////////////////////////////

    public boolean isEmpty() {
        if (head == null) {
            return ture;
        }
        return false;
    }

    public int size() {
        return count;
    }

    // 3 - implemente o método get
    /*
     * Retorna o elemento de uma determinada posicao da lista.
     * 
     * @param index a posição da lista
     * 
     * @return o elemento da posicao especificada
     * 
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */

    public int get(int index) {
        if (index < 0 || index >= size()) {
            throw IndexOutOfBoundsException();
        }

        return element;

    }

    /*
     * Exemplo - veja o main
     * Lista:
     * 2
     * 4
     * 8
     * lista.get(1)
     * Elemento na segunda posicao da lista: 4
     */

    // assinatura do metodo
    // public Integer get(int index)
}
