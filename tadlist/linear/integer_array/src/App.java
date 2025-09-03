import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ListArrayOfInteger lista = new ListArrayOfInteger();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);
        lista.remove(4);
        System.out.println("\nLista:\n" + lista);

        System.out.println("Digite um número para remover da lista: ");
        int num = sc.nextInt();
        lista.remove(num);
        System.out.println("Lista após a remoção do elemento: " + lista);
        System.out.println("");

    }
}
