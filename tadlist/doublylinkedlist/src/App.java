
public class App {
    public static void main(String[] args) {
        DoubleLinkedListOfInteger l = new DoubleLinkedListOfInteger();
        l.addF(10);
        l.addF(20);
        l.addF(30);

        System.out.println("Lista: \n" + l);
        System.out.println("----------------------");
        System.out.println("Tamanho da lista: " + l.size());
        System.out.println("----------------------");

        System.out.println("\n*ADICIONA 10 NO INICIO*");
        l.addI(10);
        System.out.println("\nLista atualizada: \n" + l);
        System.out.println("----------------------");
        System.out.println("Tamanho da lista: " + l.size());
        System.out.println("----------------------");

    }

}
