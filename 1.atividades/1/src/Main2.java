public class Main2 {
    public static void main(String[] args) {

        GeneralTreeOfInteger arv = new GeneralTreeOfInteger();
        arv.add(10, null);
        arv.add(20, 10);
        arv.add(30, 10);
        arv.add(40, 20);
        arv.add(50, 20);
        arv.add(60, 20);

        arv.add(70, 30);
        arv.add(80, 30);

        arv.add(90, 40);
        arv.add(100, 40);

        arv.add(110, 60);
        arv.add(120, 80);

        arv.add(130, 100);
        arv.add(140, 100);
        arv.add(150, 100);

        arv.add(160, 120);
        arv.add(170, 120);

        System.out.println("Caminhamento em largura:");
        System.out.println(arv.positionsWidth());

        System.out.println("Caminhamento pré-fixado:");
        System.out.println(arv.positionsPre());

        System.out.println("Caminhamento pós-fixado:");
        System.out.println(arv.positionsPos());

        arv.geraDOT();

    }
}
