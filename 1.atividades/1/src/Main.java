
public class Main {
    public static void main(String[] args) {

        GeneralTreeOfInteger arv = new GeneralTreeOfInteger();
        // raiz
        arv.add(1, null);
        // nivel 1
        arv.add(2, 1);
        arv.add(3, 1);
        // nivel 2
        arv.add(4, 2);
        arv.add(5, 2);
        arv.add(6, 2);
        arv.add(7, 3);
        arv.add(8, 3);
        // nivel 3
        arv.add(9, 4);
        arv.add(10, 4);
        arv.add(11, 6);
        arv.add(12, 8);
        // nivel 4 - folha
        arv.add(13, 10);
        arv.add(14, 10);
        arv.add(15, 10);
        arv.add(16, 12);
        arv.add(17, 12);

        System.out.println("Caminhamento pré-fixado:");
        System.out.println(arv.positionsPre());

        System.out.println("Caminhamento pós-fixado:");
        System.out.println(arv.positionsPos());

        System.out.println("Caminhamento em largura:");
        System.out.println(arv.positionsWidth());

        arv.geraDOT();
        // pegue o resultado do dot e cole neste link para visualizar a representação
        // gráfica da árvore
        // https://dreampuf.github.io/GraphvizOnline/

    }
}