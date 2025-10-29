import java.util.NoSuchElementException;

import TreePrinter.PrintableNode;

public class BinaryTreeOfInteger {
    private static final class Node implements TreePrinter.PrintableNode {
        public Node father;
        public Node left;
        public Node right;
        private Integer element;

        public Node(Integer element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }

        public TreePrinter.PrintableNode getLeft() {
            return left;
        }

        public TreePrinter.PrintableNode getRight() {
            return right;
        }

        public String getText() {
            return element.toString();
        }
    }

    private int count;
    private Node root;

    public BinaryTreeOfInteger() {
        count = 0;
        root = null;
    }

    public void clear() {
        count = 0;
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public int size() {
        return count;
    }

    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    private Node searchNodeRef(Integer element, Node target) {
        if (target == null)
            return null;
        if (element.equals(target.element))
            return target;

        Node aux = searchNodeRef(element, target.left);

        if (aux == null)
            aux = searchNodeRef(element, target.right);

        return aux;
    }

    public boolean contains(Integer element) {
        Node nAux = searchNodeRef(element, root);
        return (nAux != null);
    }

    public Integer getParent(Integer element) {
        Node n = this.searchNodeRef(element, root);
        if (n == null) {
            return null;
        } else if (n.father == null) {
            return null;
        } else {
            return n.father.element;
        }
    }

    public void setRoot(Integer element) {
        if (root != null) {
            root.element = element;
        }
    }

    public boolean addRoot(Integer element) {
        if (root != null)
            return false;
        root = new Node(element);
        count++;
        return true;
    }

    public boolean hasLeft(Integer element) {
        Node aux = searchNodeRef(element, root);

        if (aux == null)
            return false;
        if (aux.left == null)
            return false;

        return true;
    }

    public boolean hasRight(Integer element) {
        Node aux = searchNodeRef(element, root);

        if (aux == null)
            return false;
        if (aux.right == null)
            return false;

        return true;
    }

    public boolean addLeft(Integer element, Integer elemFather) {
        Node aux = searchNodeRef(elemFather, root);

        if (aux == null)
            return false;
        if (aux.left != null)
            return false;

        Node n = new Node(element); // primeiro cria o nodo
        n.father = aux; // faz o novo nodo apontar para o pai
        aux.left = n;// faz o pai apontar para o filho
        count++; // atualiza count
        return true;
    }

    public boolean addRight(Integer element, Integer elemFather) {
        Node aux = searchNodeRef(elemFather, root);

        if (aux == null)
            return false;
        if (aux.right != null)
            return false;

        Node n = new Node(element); // primeiro cria o nodo
        n.father = aux; // faz o novo nodo apontar para o pai
        aux.right = n;// faz o pai apontar para o filho
        count++; // atualiza count
        return true;
    }

    private int countNodes(Node n) {
        if (n == null)
            return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }

    public LinkedListOfInteger positionsPre() {
        LinkedListOfInteger lista = new LinkedListOfInteger();
        positionsPreAux(root, lista);
        return lista;
    }

    private void positionsPreAux(Node n, LinkedListOfInteger lista) {
        if (n != null) {
            lista.add(n.element); // visita raiz
            positionsPreAux(n.left, lista); // percorre subarvore da esq
            positionsPreAux(n.right, lista); // percorre subarvore da dir
        }
    }

    public LinkedListOfInteger positionsPos() {
        LinkedListOfInteger lista = new LinkedListOfInteger();
        positionsPosAux(root, lista);
        return lista;
    }

    private void positionsPosAux(Node n, LinkedListOfInteger lista) {
        if (n != null) {
            positionsPosAux(n.left, lista); // percorre subarvore da esq
            positionsPosAux(n.right, lista); // percorre subarvore da dir
            lista.add(n.element); // visita raiz
        }
    }

    public LinkedListOfInteger positionsWidth() {
        LinkedListOfInteger lista = new LinkedListOfInteger();
        if (root == null)
            return lista;

        LinkedListOfInteger fila = new LinkedListOfInteger();
        fila.add(root.element);

        while (!fila.isEmpty()) {
            Integer elem = fila.get(0);
            // Remover primeiro elemento manualmente
            LinkedListOfInteger novaFila = new LinkedListOfInteger();
            for (int i = 1; i < fila.size(); i++) {
                novaFila.add(fila.get(i));
            }
            fila = novaFila;

            lista.add(elem);

            Node n = searchNodeRef(elem, root);
            if (n != null) {
                if (n.left != null)
                    fila.add(n.left.element);
                if (n.right != null)
                    fila.add(n.right.element);
            }
        }
        return lista;
    }

    public Integer getLeft(Integer element) {
        Node n = searchNodeRef(element, root);
        if (n == null || n.left == null)
            return null;
        return n.left.element;
    }

    public Integer getRight(Integer element) {
        Node n = searchNodeRef(element, root);
        if (n == null || n.right == null)
            return null;
        return n.right.element;
    }

    public int height() {
        return heightAux(root);
    }

    private int heightAux(Node n) {
        if (n == null)
            return -1;
        if (n.left == null && n.right == null)
            return 0;
        int hLeft = heightAux(n.left);
        int hRight = heightAux(n.right);
        return 1 + Math.max(hLeft, hRight);
    }

    public int countLeaves() {
        return countLeavesAux(root);
    }

    private int countLeavesAux(Node n) {
        if (n == null)
            return 0;
        if (n.left == null && n.right == null)
            return 1;
        return countLeavesAux(n.left) + countLeavesAux(n.right);
    }

    public void printTree() {
        if (root != null) {
            TreePrinter.print(root);
        } else {
            System.out.println("Árvore vazia");
        }
    }
}