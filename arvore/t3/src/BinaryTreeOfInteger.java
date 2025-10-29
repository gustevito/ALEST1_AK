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

    public void printTree() {
        if (root != null) {
            TreePrinter.print(root);
        } else {
            System.out.println("Árvore vazia");
        }
    }
}
