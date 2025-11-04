import java.util.*;

public class GenericTree<E> {

    public static class Node<E> {
        private E element;
        private Node<E> parent;
        private List<Node<E>> children;

        public Node(E element) {
            this.element = element;
            this.parent = null;
            this.children = new ArrayList<>();
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public List<Node<E>> getChildren() {
            return children;
        }

        public void addChild(Node<E> child) {
            children.add(child);
            child.setParent(this);
        }

        public void removeChild(Node<E> child) {
            children.remove(child);
            child.setParent(null);
        }

        public boolean isLeaf() {
            return children.isEmpty();
        }

        public boolean isRoot() {
            return parent == null;
        }

        public int getDegree() {
            return children.size();
        }
    }

    private Node<E> root;
    private int size;

    public GenericTree() {
        this.root = null;
        this.size = 0;
    }

    public GenericTree(E rootElement) {
        this.root = new Node<>(rootElement);
        this.size = 1;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size;
    }

    public Node<E> getRoot() {
        return root;
    }

    public void setRoot(E element) {
        if (root == null) {
            root = new Node<>(element);
            size = 1;
        } else {
            root.setElement(element);
        }
    }

    public Node<E> search(E element) {
        if (root == null)
            return null;
        return searchHelper(root, element);
    }

    private Node<E> searchHelper(Node<E> node, E element) {
        if (node.getElement().equals(element)) {
            return node;
        }

        for (Node<E> child : node.getChildren()) {
            Node<E> result = searchHelper(child, element);
            if (result != null) {
                return result;
            }
        }

        return null;
    }

    public boolean addChild(E parentElement, E childElement) {
        Node<E> parentNode = search(parentElement);
        if (parentNode == null) {
            return false;
        }

        Node<E> childNode = new Node<>(childElement);
        parentNode.addChild(childNode);
        size++;
        return true;
    }

    public boolean moveSubtree(E nodeElement, E newParentElement) {
        if (nodeElement.equals(newParentElement)) {
            return false;
        }

        Node<E> node = search(nodeElement);
        Node<E> newParent = search(newParentElement);

        if (node == null || newParent == null || node.isRoot()) {
            return false;
        }

        if (isDescendant(newParent, node)) {
            return false;
        }

        Node<E> oldParent = node.getParent();
        oldParent.removeChild(node);

        newParent.addChild(node);

        return true;
    }

    private boolean isDescendant(Node<E> possibleDescendant, Node<E> possibleAncestor) {
        Node<E> current = possibleDescendant;
        while (current != null) {
            if (current == possibleAncestor) {
                return true;
            }
            current = current.getParent();
        }
        return false;
    }

    public boolean removeSubtree(E element) {
        Node<E> node = search(element);
        if (node == null) {
            return false;
        }

        if (node.isRoot()) {
            root = null;
            size = 0;
            return true;
        }

        int nodesToRemove = countNodes(node);

        Node<E> parent = node.getParent();
        parent.removeChild(node);

        size -= nodesToRemove;
        return true;
    }

    private int countNodes(Node<E> node) {
        if (node == null)
            return 0;

        int count = 1;
        for (Node<E> child : node.getChildren()) {
            count += countNodes(child);
        }
        return count;
    }

    public int height() {
        if (root == null)
            return -1;
        return heightHelper(root);
    }

    private int heightHelper(Node<E> node) {
        if (node.isLeaf())
            return 0;

        int maxHeight = -1;
        for (Node<E> child : node.getChildren()) {
            maxHeight = Math.max(maxHeight, heightHelper(child));
        }
        return maxHeight + 1;
    }

    public int maxDegree() {
        if (root == null)
            return 0;
        return maxDegreeHelper(root);
    }

    private int maxDegreeHelper(Node<E> node) {
        int max = node.getDegree();

        for (Node<E> child : node.getChildren()) {
            max = Math.max(max, maxDegreeHelper(child));
        }
        return max;
    }

    public int countLeaves() {
        if (root == null)
            return 0;
        return countLeavesHelper(root);
    }

    private int countLeavesHelper(Node<E> node) {
        if (node.isLeaf())
            return 1;

        int count = 0;
        for (Node<E> child : node.getChildren()) {
            count += countLeavesHelper(child);
        }
        return count;
    }

    public int countInternalNodes() {
        return size - countLeaves();
    }

    /**
     * Percurso em pré-ordem
     */
    public List<E> preOrder() {
        List<E> result = new ArrayList<>();
        if (root != null) {
            preOrderHelper(root, result);
        }
        return result;
    }

    private void preOrderHelper(Node<E> node, List<E> result) {
        result.add(node.getElement());
        for (Node<E> child : node.getChildren()) {
            preOrderHelper(child, result);
        }
    }

    /**
     * Percurso em pós-ordem
     */
    public List<E> posOrder() {
        List<E> result = new ArrayList<>();
        if (root != null) {
            posOrderHelper(root, result);
        }
        return result;
    }

    private void posOrderHelper(Node<E> node, List<E> result) {
        for (Node<E> child : node.getChildren()) {
            posOrderHelper(child, result);
        }
        result.add(node.getElement());
    }

    /**
     * Percurso em largura (BFS)
     */
    public List<E> levelOrder() {
        List<E> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            result.add(node.getElement());

            for (Node<E> child : node.getChildren()) {
                queue.offer(child);
            }
        }

        return result;
    }

    /**
     * Encontra o LCA (Lowest Common Ancestor)
     */
    public E findLCA(E element1, E element2) {
        Node<E> node1 = search(element1);
        Node<E> node2 = search(element2);

        if (node1 == null || node2 == null) {
            return null;
        }

        // Obter caminho até a raiz para ambos os nós
        List<Node<E>> path1 = getPathToRoot(node1);
        List<Node<E>> path2 = getPathToRoot(node2);

        // Encontrar o primeiro ancestral comum
        for (Node<E> n1 : path1) {
            for (Node<E> n2 : path2) {
                if (n1 == n2) {
                    return n1.getElement();
                }
            }
        }

        return null;
    }

    /**
     * Obtém o caminho de um nó até a raiz
     */
    private List<Node<E>> getPathToRoot(Node<E> node) {
        List<Node<E>> path = new ArrayList<>();
        Node<E> current = node;

        while (current != null) {
            path.add(current);
            current = current.getParent();
        }

        return path;
    }

    /**
     * Encontra o caminho entre dois nós
     */
    public List<E> findPath(E from, E to) {
        Node<E> fromNode = search(from);
        Node<E> toNode = search(to);

        if (fromNode == null || toNode == null) {
            return new ArrayList<>();
        }

        // Encontrar LCA
        Node<E> lca = search(findLCA(from, to));
        if (lca == null) {
            return new ArrayList<>();
        }

        // Caminho de 'from' até LCA
        List<E> pathUp = new ArrayList<>();
        Node<E> current = fromNode;
        while (current != lca) {
            pathUp.add(current.getElement());
            current = current.getParent();
        }
        pathUp.add(lca.getElement());

        // Caminho de LCA até 'to' (se não forem o mesmo)
        if (lca != toNode) {
            List<E> pathDown = new ArrayList<>();
            current = toNode;
            while (current != lca) {
                pathDown.add(current.getElement());
                current = current.getParent();
            }

            // Inverter pathDown e adicionar ao resultado
            Collections.reverse(pathDown);
            for (E elem : pathDown) {
                pathUp.add(elem);
            }
        }

        return pathUp;
    }

    /**
     * Verifica consistência da árvore
     */
    public boolean checkConsistency() {
        if (root == null)
            return true;

        // Verificar única raiz
        if (!root.isRoot()) {
            return false;
        }

        // Verificar ausência de ciclos usando DFS
        Set<Node<E>> visited = new HashSet<>();
        Set<Node<E>> visiting = new HashSet<>();

        return !hasCycle(root, visited, visiting);
    }

    private boolean hasCycle(Node<E> node, Set<Node<E>> visited, Set<Node<E>> visiting) {
        visiting.add(node);

        for (Node<E> child : node.getChildren()) {
            if (visiting.contains(child)) {
                return true; // Ciclo detectado
            }
            if (!visited.contains(child) && hasCycle(child, visited, visiting)) {
                return true;
            }
        }

        visiting.remove(node);
        visited.add(node);
        return false;
    }

    /**
     * Visualização da árvore em formato texto
     */
    public void printTree() {
        if (root == null) {
            System.out.println("Árvore vazia");
            return;
        }
        printTreeHelper(root, "", true);
    }

    private void printTreeHelper(Node<E> node, String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.getElement());

        List<Node<E>> children = node.getChildren();
        for (int i = 0; i < children.size() - 1; i++) {
            printTreeHelper(children.get(i), prefix + (isTail ? "    " : "│   "), false);
        }

        if (!children.isEmpty()) {
            printTreeHelper(children.get(children.size() - 1),
                    prefix + (isTail ? "    " : "│   "), true);
        }
    }
}