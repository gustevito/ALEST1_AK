public class Main {
    public static void main(String[] args) {
        BinaryTreeOfInteger b = new BinaryTreeOfInteger();

        b.addRoot(100);
        b.addLeft(2, 100);
        b.addRight(3, 100);
        b.addRight(0, 3);
        b.addLeft(4, 2);
        b.addLeft(69, 4);
        b.addRight(5, 2);
        b.addRight(6, 5);
        b.addRight(7, 6);

        b.printTree();

        int e = 4;
        System.out.println(b.size());
        System.out.println("-> Elemento " + e + " contém nodo à esquerda? " + "[" + b.hasLeft(e) + "]");
        System.out.println("-> Árvore contém o elemento " + e + "? " + "[" + b.contains(e) + "]");
    }
}