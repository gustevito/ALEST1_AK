import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean cond = true;

        while (cond) {
            exibirMenu();
            int op = in.nextInt();
            in.nextLine();
            switch (op) {
                case 1:
                    System.out.println("INSERÇÃO");
                    esperarEnter(in);
                    break;

                case 2:

                    System.out.println("REMOÇÃO");
                    esperarEnter(in);
                    break;

                case 3:

                    System.out.println("BUSCA");
                    esperarEnter(in);
                    break;

                case 4:

                    System.out.println("EXIBIR");
                    esperarEnter(in);
                    break;

                case 0:
                    in.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n## Opção inválida! ##");
                    System.out.println("Verifique a opção digitada e tente novamente.");
                    esperarEnter(in);
                    break;
            }
        }
    }

    private static void esperarEnter(Scanner in) {
        System.out.println("\nPressione a tecla Enter para acessar o menu...");
        in.nextLine();
        limparTela();
    }

    private static void exibirMenu() {
        System.out.println("\n------------------------------");
        System.out.println("Digite o nº da opção que deseja executar:");
        System.out.println("\n1 - Inserir carro no estacionamento");
        System.out.println("2 - Remover carro do estacionamento");
        System.out.println("3 - Exibir carros estacionados");
        System.out.println("4 - Exibir carros na lista de espera");
        System.out.println("5 - Buscar carro por placa");
        System.out.println("\n------------------------------");
    }

    // pedi pra IA fazer esse método pra limpar a tela
    private static void limparTela() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

}