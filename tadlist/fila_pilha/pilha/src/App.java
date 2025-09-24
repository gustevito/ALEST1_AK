import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);

        System.out.println("Digite uma palavra (String) para invertê-la: ");
        String palavra = t.nextLine();

        System.out.println("\n--- PALAVRA DIGITADA: ---");
        System.out.println(palavra);
        System.out.println("-------------------------");

        System.out.println("--- STRING INVERTIDA ---");
        String invertida = inverteString(palavra);
        System.out.println(invertida);
        System.out.println("-------------------------");

    }

    public static String inverteString(String palavra) {
        Pilha p = new Pilha();
        int n = palavra.length();

        for (int i = 0; i < n; i++) {
            p.push(String.valueOf(palavra.charAt(i)));
        }

        String invertida = "";

        while (!p.isEmpty()) {
            invertida += p.pop();
        }

        return invertida;
    }
}
