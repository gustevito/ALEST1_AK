import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Torneio torneio = new Torneio();

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE TORNEIO ELIMINATÓRIO        ║");
        System.out.println("║        (Árvore Binária)                  ║");
        System.out.println("╚══════════════════════════════════════════╝");

        while (true) {
            mostrarMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    criarTorneio();
                    break;
                case 2:
                    registrarVencedor();
                    break;
                case 3:
                    mostrarPercursos();
                    break;
                case 4:
                    mostrarEstatisticas();
                    break;
                case 5:
                    encontrarLCA();
                    break;
                case 6:
                    mostrarCaminho();
                    break;
                case 7:
                    torneio.mostrarEstadoVisual();
                    break;
                case 0:
                    System.out.println("\nEncerrando sistema...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            System.out.println("\nPressione ENTER para continuar...");
            scanner.nextLine();
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║             MENU PRINCIPAL               ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║ 1. Criar novo torneio                    ║");
        System.out.println("║ 2. Registrar vencedor de partida         ║");
        System.out.println("║ 3. Mostrar percursos                     ║");
        System.out.println("║ 4. Mostrar estatísticas                  ║");
        System.out.println("║ 5. Encontrar LCA entre jogadores         ║");
        System.out.println("║ 6. Mostrar caminho até final             ║");
        System.out.println("║ 7. Visualizar estado do torneio          ║");
        System.out.println("║ 0. Sair                                  ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void criarTorneio() {
        System.out.println("\n=== CRIAR NOVO TORNEIO ===");
        System.out.println("Quantos participantes? (8, 16 ou 32): ");
        int n = lerOpcao();

        if (n != 8 && n != 16 && n != 32) {
            System.out.println("Número inválido! Use 8, 16 ou 32.");
            return;
        }

        List<String> participantes = new ArrayList<>();
        System.out.println("Digite os nomes dos " + n + " participantes:");

        for (int i = 1; i <= n; i++) {
            System.out.print("Participante " + i + ": ");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty()) {
                nome = "Jogador" + i;
            }
            participantes.add(nome);
        }

        torneio.criarTorneio(participantes);
        torneio.mostrarEstadoVisual();
    }

    private static void registrarVencedor() {
        System.out.println("\n=== REGISTRAR VENCEDOR ===");
        System.out.print("Nome do vencedor da partida: ");
        String vencedor = scanner.nextLine().trim();

        if (!vencedor.isEmpty()) {
            torneio.registrarVencedor(vencedor);
        }
    }

    private static void mostrarPercursos() {
        System.out.println("\n=== PERCURSOS DA ÁRVORE ===");
        System.out.println("1. Pré-ordem");
        System.out.println("2. Pós-ordem");
        System.out.println("3. Largura");
        System.out.println("4. Todos");
        System.out.print("Escolha: ");

        int opcao = lerOpcao();

        switch (opcao) {
            case 1:
                torneio.mostrarPreOrdem();
                break;
            case 2:
                torneio.mostrarPosOrdem();
                break;
            case 3:
                torneio.mostrarEmLargura();
                break;
            case 4:
                torneio.mostrarPreOrdem();
                torneio.mostrarPosOrdem();
                torneio.mostrarEmLargura();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void mostrarEstatisticas() {
        torneio.mostrarAltura();
        torneio.mostrarEstatisticas();
    }

    private static void encontrarLCA() {
        System.out.println("\n=== ENCONTRAR LCA ===");
        System.out.print("Nome do primeiro jogador: ");
        String jogador1 = scanner.nextLine().trim();
        System.out.print("Nome do segundo jogador: ");
        String jogador2 = scanner.nextLine().trim();

        if (!jogador1.isEmpty() && !jogador2.isEmpty()) {
            torneio.encontrarLCA(jogador1, jogador2);
        }
    }

    private static void mostrarCaminho() {
        System.out.println("\n=== CAMINHO ATÉ A FINAL ===");
        System.out.print("Nome do jogador: ");
        String jogador = scanner.nextLine().trim();

        if (!jogador.isEmpty()) {
            torneio.mostrarCaminho(jogador);
        }
    }

    // Método auxiliar para criar um torneio de teste rápido
    public static void criarTorneioTeste() {
        List<String> participantes = Arrays.asList(
                "Alice", "Bob", "Carlos", "Diana",
                "Eva", "Frank", "Gabi", "Hugo");

        torneio.criarTorneio(participantes);
        System.out.println("\nTorneio de teste criado com 8 participantes!");

        // Simular algumas partidas
        System.out.println("\nSimulando algumas partidas...");
        torneio.registrarVencedor("Alice");
        torneio.registrarVencedor("Carlos");
        torneio.registrarVencedor("Eva");
        torneio.registrarVencedor("Hugo");

        // Semifinais
        torneio.registrarVencedor("Alice");
        torneio.registrarVencedor("Hugo");

        // Final
        torneio.registrarVencedor("Hugo");

        torneio.mostrarEstadoVisual();
    }
}