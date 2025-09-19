public class App {
    public static void main(String[] args) {
        LinkedListOfInteger lista = new LinkedListOfInteger();

        // System.out.println("Tamanho da lista: " + lista.size());
        // System.out.println("Lista Vaiza? " + lista.isEmpty());

        System.out.println("Adicionando elementos no final da lista...");

        lista.addFim(2);
        lista.addFim(4);
        lista.addFim(6);
        lista.addFim(8);
        lista.addFim(10);
        lista.addFim(12);

        lista.addInicio(69);
        lista.addInicio(42);
        lista.addInicio(7);
        System.out.println(lista);
        System.out.println("--> Elementos adicionados com sucesso!");

        // System.out.println("Tamanho da lista: " + lista.size());
        // System.out.println("Lista Vaiza? " + lista.isEmpty());

        // System.out.println("Lista Vaiza? " + lista.isEmpty());

        // System.out.println("Elemento armazenado na "
        // + "segunda posicao da lista: " +lista.get(1));

        // System.out.println("Elemento armazenado na "
        // + "ultima posicao da lista: " +lista.get(lista.size()-1));

    }
}
