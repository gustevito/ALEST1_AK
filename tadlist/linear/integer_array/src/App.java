import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ListArrayOfInteger lista = new ListArrayOfInteger();
        ListArrayOfInteger lista2 = new ListArrayOfInteger();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);

        lista2.add(7);
        lista2.add(42);
        lista2.add(64);
        lista2.add(81);
        lista2.add(130);
        lista2.add(8);

        System.out.println("\nLista: " + lista);
        System.out.println("\nLista 2: " + lista2);

        Integer elemento = maiorElementoPresenteNasDuasListas(lista, lista2);
        System.out.println("Maior elemento entre as duas: " + elemento);

    }

    public static Integer maiorElementoPresenteNasDuasListas(ListArrayOfInteger lista1, ListArrayOfInteger lista2) {
        Integer maior = 0;
        for (int i = 0; i < lista1.size(); i++) {
            Integer elem = lista1.get(i);
            if (lista2.contains(elem)) {
                if (maior == null || elem > maior) {
                    maior = elem;
                }
            }
        }
        return maior;
    }

}
