import java.util.Scanner;

public class App {
    private static Estacionamento estacionamento = new Estacionamento();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean cond = true;

        while (cond) {
            exibirMenu();
            int op = in.nextInt();
            in.nextLine();

            switch (op) {
                case 1:
                    inserirCarro(in);
                    break;
                case 2:
                    removerCarro(in);
                    break;
                case 3:
                    buscarCarro(in);
                    break;
                case 4:
                    exibirSituacao();
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

    private static void inserirCarro(Scanner in) {
        System.out.print("Digite a placa do carro (formato: AAA0A00): ");
        String codigoPlaca = in.nextLine().toUpperCase();

        Placa placa = new Placa(codigoPlaca);
        if (placa.getCodigo().equals("AAA0A00")) {
            System.out.println("Placa inválida! Formato deve ser LLLNLNN (ex: ABC1D23)");
        } else {
            Carro carro = new Carro(placa);
            String resultado = estacionamento.adicionarCarro(carro);
            System.out.println(resultado);
        }

        esperarEnter(in);
    }

    private static void removerCarro(Scanner in) {
        System.out.print("Digite a placa do carro a ser removido: ");
        String codigoPlaca = in.nextLine().toUpperCase();

        String resultado = estacionamento.removerCarro(codigoPlaca);
        System.out.println(resultado);

        esperarEnter(in);
    }

    private static void buscarCarro(Scanner in) {
        System.out.print("Digite a placa do carro: ");
        String codigoPlaca = in.nextLine().toUpperCase();

        System.out.println("\n=== BUSCA SEQUENCIAL ===");
        String resultado = estacionamento.buscarCarroSequencial(codigoPlaca);
        System.out.println(resultado);

        System.out.println("\n=== BUSCA BINÁRIA ===");
        resultado = estacionamento.buscarCarroBinaria(codigoPlaca);
        System.out.println(resultado);

        esperarEnter(in);
    }

    private static void exibirSituacao() {
        System.out.println("\n=== SITUAÇÃO ATUAL DO ESTACIONAMENTO ===");
        estacionamento.exibirSituacao();
    }

    private static void esperarEnter(Scanner in) {
        System.out.println("\nPressione a tecla Enter para acessar o menu...");
        in.nextLine();
        limparTela();
    }

    private static void exibirMenu() {
        System.out.println("\n===============================");
        System.out.println("  ESTACIONAMENTO INTELIGENTE");
        System.out.println("===============================");
        System.out.println("Digite o nº da opção que deseja executar:");
        System.out.println("\n1 - Inserir carro no estacionamento");
        System.out.println("2 - Remover carro do estacionamento");
        System.out.println("3 - Buscar carro por placa");
        System.out.println("4 - Exibir situação atual");
        System.out.println("0 - Sair");
        System.out.println("===============================");
        System.out.print("Opção: ");
    }

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