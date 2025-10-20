import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        LinkedListOfInteger lista = new LinkedListOfInteger();
        DoubleLinkedListOfInteger listaDupla = new DoubleLinkedListOfInteger();

        lista.addFim(10);
        lista.addFim(20);
        lista.addFim(30);
        lista.addFim(40);
        lista.addFim(50);

        listaDupla.addFim(1);
        listaDupla.addFim(2);
        listaDupla.addFim(3);
        listaDupla.addFim(3);
        listaDupla.addFim(4);
        listaDupla.addFim(5);

        System.out.println(listaDupla);
        System.out.println(listaDupla.hasRepetidos());

        listaDupla.addAll(lista);
        System.out.println(listaDupla);
    }

    // public static void main(String[] args) {
    // DoubleLinkedListOfInteger l = new DoubleLinkedListOfInteger();

    // Scanner scanner = new Scanner(System.in);
    // int option = -1;

    // while (option != 0) {
    // System.out.println("\nLista: " + l);
    // System.out.println("Tamanho da lista: " + l.size());
    // System.out.println("----------------------");
    // System.out.println("Menu:");
    // System.out.println("1. Adicionar elemento por índice");
    // System.out.println("2. Adicionar elemento ao início da lista");
    // System.out.println("3. Adicionar elemento ao fim da lista");
    // System.out.println("4. Remover elemento do início");
    // System.out.println("5. Remover elemento do fim");
    // System.out.println("6. Remover elemento por valor");
    // System.out.println("7. Remover elemento no índice");
    // System.out.println("0. Sair");
    // System.out.print("Escolha uma opção: ");
    // option = scanner.nextInt();

    // switch (option) {
    // case 1:
    // System.out.print("Informe o índice: ");
    // int idxAdd = scanner.nextInt();
    // System.out.print("Informe o valor: ");
    // int valAdd = scanner.nextInt();
    // l.add(idxAdd, valAdd);
    // break;
    // case 2:
    // System.out.print("Informe o valor: ");
    // int valInicio = scanner.nextInt();
    // l.addInicio(valInicio);
    // break;
    // case 3:
    // System.out.print("Informe o valor: ");
    // int valFim = scanner.nextInt();
    // l.addFim(valFim);
    // break;
    // case 4:
    // l.removeInicio();
    // break;
    // case 5:
    // l.removeFim();
    // break;
    // case 6:
    // System.out.print("Informe o valor a remover: ");
    // int valRem = scanner.nextInt();
    // l.removeElemento(valRem);
    // break;
    // case 7:
    // System.out.print("Informe o índice a remover: ");
    // int idxRem = scanner.nextInt();
    // l.remove(idxRem);
    // break;
    // case 0:
    // System.out.println("Saindo...");
    // break;
    // default:
    // System.out.println("Opção inválida!");
    // }
    // }
    // scanner.close();
    // }
}
