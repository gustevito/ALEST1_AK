import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Torneio torneio = new Torneio();

    public static void main(String[] args) {
        System.out.println("::: SISTEMA DE TORNEIO ELIMINATÓRIO (Árvore Binária) :::");

        while (true) {
            mostrarMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1 -> criarTorneio();
                case 2 -> registrarVencedor();
                case 3 -> mostrarPercursos();
                case 4 -> mostrarEstatisticas();
                case 5 -> encontrarLCA();
                case 6 -> mostrarCaminho();
                case 7 -> torneio.mostrarEstadoVisual();
                case 8 -> criarTorneioTeste();
                case 0 -> {
                    System.out.println("\nEncerrando sistema...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.print("\nPressione ENTER para continuar...");
            scanner.nextLine();
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Criar novo torneio");
        System.out.println("2. Registrar vencedor de partida");
        System.out.println("3. Mostrar percursos");
        System.out.println("4. Mostrar estatísticas");
        System.out.println("5. Encontrar LCA entre jogadores");
        System.out.println("6. Mostrar caminho até a final");
        System.out.println("7. Visualizar estado do torneio");
        System.out.println("8. Criar torneio de teste");
        System.out.println("0. Sair");
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
        System.out.println("\n--- Criar novo torneio ---");
        System.out.print("Quantos participantes? (8, 16 ou 32): ");
        int n = lerOpcao();

        if (n != 8 && n != 16 && n != 32) {
            System.out.println("Número inválido. Use 8, 16 ou 32.");
            return;
        }

        List<String> participantes = new ArrayList<>();
        System.out.println("\nDigite os nomes dos " + n + " participantes:");

        for (int i = 1; i <= n; i++) {
            System.out.print("Participante " + i + ": ");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty())
                nome = "Jogador" + i;
            participantes.add(nome);
        }

        torneio.criarTorneio(participantes);
        torneio.mostrarEstadoVisual();
    }

    private static void registrarVencedor() {
        System.out.println("\n--- Registrar vencedor ---");
        System.out.print("Nome do vencedor da partida: ");
        String vencedor = scanner.nextLine().trim();

        if (!vencedor.isEmpty()) {
            torneio.registrarVencedor(vencedor);
        } else {
            System.out.println("Nome não pode ser vazio.");
        }
    }

    private static void mostrarPercursos() {
        System.out.println("\n--- Percursos da árvore ---");
        System.out.println("1. Pré-ordem");
        System.out.println("2. Pós-ordem");
        System.out.println("3. Largura");
        System.out.println("4. Todos");
        System.out.print("Escolha: ");

        int opcao = lerOpcao();

        switch (opcao) {
            case 1 -> torneio.mostrarPreOrdem();
            case 2 -> torneio.mostrarPosOrdem();
            case 3 -> torneio.mostrarEmLargura();
            case 4 -> {
                System.out.println("\nTodos os percursos:");
                torneio.mostrarPreOrdem();
                torneio.mostrarPosOrdem();
                torneio.mostrarEmLargura();
            }
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void mostrarEstatisticas() {
        System.out.println("\n--- Estatísticas do torneio ---");
        torneio.mostrarAltura();
        torneio.mostrarEstatisticas();
    }

    private static void encontrarLCA() {
        System.out.println("\n--- Encontrar LCA (Lowest Common Ancestor) ---");
        System.out.print("Nome do primeiro jogador: ");
        String jogador1 = scanner.nextLine().trim();
        System.out.print("Nome do segundo jogador: ");
        String jogador2 = scanner.nextLine().trim();

        if (!jogador1.isEmpty() && !jogador2.isEmpty()) {
            torneio.encontrarLCA(jogador1, jogador2);
        } else {
            System.out.println("Os nomes não podem ser vazios.");
        }
    }

    private static void mostrarCaminho() {
        System.out.println("\n--- Caminho até a final ---");
        System.out.print("Nome do jogador: ");
        String jogador = scanner.nextLine().trim();

        if (!jogador.isEmpty()) {
            torneio.mostrarCaminho(jogador);
        } else {
            System.out.println("Nome não pode ser vazio.");
        }
    }

    private static void criarTorneioTeste() {
        System.out.println("\n--- Criando torneio de teste ---");
        List<String> participantes = Arrays.asList(
                "Gustavo", "Sangalli", "Bernardo", "Laura",
                "Filipe", "Nicolas", "Ronaldo", "Carlinhos");

        torneio.criarTorneio(participantes);
        System.out.println("Torneio de teste criado com 8 participantes.");

        System.out.println("\nSimulando partidas...");
        torneio.registrarVencedor("Gustavo");
        torneio.registrarVencedor("Bernardo");
        torneio.registrarVencedor("Filipe");
        torneio.registrarVencedor("Ronaldo");

        torneio.registrarVencedor("Bernardo");
        torneio.registrarVencedor("Ronaldo");
        torneio.registrarVencedor("Bernardo");

        torneio.mostrarEstadoVisual();
    }
}
