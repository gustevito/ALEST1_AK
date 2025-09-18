
public class App {
    public static void main(String[] args) {
        DoubleLinkedListOfInteger l = new DoubleLinkedListOfInteger();
        l.addFim(10);
        l.addFim(10);
        l.addFim(10);
        l.addFim(20);
        l.addFim(30);

        System.out.println("Lista: \n" + l);
        System.out.println("----------------------");
        System.out.println("Tamanho da lista: " + l.size());
        System.out.println("----------------------");

        System.out.println("\n*ADICIONA 10 NO INICIO*");
        l.addInicio(10);
        System.out.println("\nLista atualizada: \n" + l);
        System.out.println("----------------------");
        System.out.println("Tamanho da lista: " + l.size());
        System.out.println("----------------------");

        System.out.println("\n*ADICIONA 50 NO INDEX 2*");
        l.add(2, 50);
        System.out.println("\nLista atualizada: \n" + l);
        System.out.println("----------------------");
        System.out.println("Tamanho da lista: " + l.size());
        System.out.println("----------------------");

        System.out.println("\n*REMOVE O 1º ELEMENTO DA LISTA*");
        l.removeInicio();
        System.out.println("\nLista atualizada: \n" + l);
        System.out.println("----------------------");
        System.out.println("Tamanho da lista: " + l.size());
        System.out.println("----------------------");

        System.out.println("\n*REMOVE ELEMENTO DO INDEX 5*");
        l.remove(6);
        System.out.println("\nLista atualizada: \n" + l);
        System.out.println("----------------------");
        System.out.println("Tamanho da lista: " + l.size());
        System.out.println("----------------------");

    }

}
