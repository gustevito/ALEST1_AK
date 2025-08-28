public class App {
    public static void main(String[] args) {
        ListArrayOfInteger lista = new ListArrayOfInteger();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);
        lista.remove(4);
        System.out.println("\nLista:\n" + lista);

        System.out.println("Elemento armazenado na primeira posicao da lista: " + lista.get(0));
        System.out.println("");

    }
}
