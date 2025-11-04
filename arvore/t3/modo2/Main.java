import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MenuApp menuApp = new MenuApp();

    public static void main(String[] args) {
        System.out.println("::: MODO 2 - MENU DE APLICATIVO (Árvore Genérica) :::");

        while (true) {
            mostrarMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1 -> visualizarEstruturaMenu();
                case 2 -> adicionarItem();
                case 3 -> moverSubarvore();
                case 4 -> removerSubarvore();
                case 5 -> mostrarEstatisticas();
                case 6 -> mostrarPercursos();
                case 7 -> encontrarLCA();
                case 8 -> mostrarCaminho();
                case 9 -> verificarConsistencia();
                case 10 -> buscarItem();
                case 11 -> reinicializarMenu();
                case 0 -> {
                    System.out.println("\nEncerrando aplicação...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("\nOpção inválida. Tente novamente.");
            }

            if (opcao != 0)
                pausar();
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Visualizar estrutura do menu");
        System.out.println("2. Adicionar item");
        System.out.println("3. Mover subárvore");
        System.out.println("4. Remover subárvore");
        System.out.println("5. Mostrar estatísticas");
        System.out.println("6. Mostrar percursos");
        System.out.println("7. Encontrar LCA");
        System.out.println("8. Mostrar caminho entre itens");
        System.out.println("9. Verificar consistência");
        System.out.println("10. Buscar item");
        System.out.println("11. Reinicializar menu");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void visualizarEstruturaMenu() {
        System.out.println("\n--- Estrutura atual do menu ---");
        menuApp.visualizarMenu();
    }

    private static void adicionarItem() {
        System.out.println("\n--- Adicionar item ---");
        System.out.println("Itens disponíveis como pai:");
        menuApp.visualizarMenu();

        System.out.print("\nNome do item pai: ");
        String pai = scanner.nextLine().trim();
        if (pai.isEmpty()) {
            System.out.println("Nome do pai não pode ser vazio.");
            return;
        }

        System.out.print("Nome do novo item: ");
        String novo = scanner.nextLine().trim();
        if (novo.isEmpty()) {
            System.out.println("Nome do novo item não pode ser vazio.");
            return;
        }

        menuApp.adicionarItem(pai, novo);
    }

    private static void moverSubarvore() {
        System.out.println("\n--- Mover subárvore ---");
        menuApp.visualizarMenu();

        System.out.print("\nItem a mover: ");
        String item = scanner.nextLine().trim();
        if (item.isEmpty()) {
            System.out.println("Nome do item não pode ser vazio.");
            return;
        }

        System.out.print("Novo pai: ");
        String novoPai = scanner.nextLine().trim();
        if (novoPai.isEmpty()) {
            System.out.println("Nome do novo pai não pode ser vazio.");
            return;
        }

        menuApp.moverSubarvore(item, novoPai);

        System.out.println("\nNova estrutura:");
        menuApp.visualizarMenu();
    }

    private static void removerSubarvore() {
        System.out.println("\n--- Remover subárvore ---");
        menuApp.visualizarMenu();

        System.out.print("\nItem a remover: ");
        String item = scanner.nextLine().trim();
        if (item.isEmpty()) {
            System.out.println("Nome do item não pode ser vazio.");
            return;
        }

        System.out.print("Tem certeza que deseja remover '" + item + "' e seus descendentes? (S/N): ");
        String confirmacao = scanner.nextLine().trim();
        if (confirmacao.equalsIgnoreCase("S")) {
            menuApp.removerSubarvore(item);
            System.out.println("\nEstrutura após remoção:");
            menuApp.visualizarMenu();
        } else {
            System.out.println("Operação cancelada.");
        }
    }

    private static void mostrarEstatisticas() {
        System.out.println("\n--- Estatísticas ---");
        menuApp.mostrarEstatisticas();

        int altura = menuApp.getAltura();
        if (altura <= 3)
            System.out.println("Menu raso, fácil navegação.");
        else if (altura <= 5)
            System.out.println("Menu com profundidade moderada.");
        else
            System.out.println("Menu muito profundo, considere reorganizar.");
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
            case 1 -> menuApp.mostrarPreOrdem();
            case 2 -> menuApp.mostrarPosOrdem();
            case 3 -> menuApp.mostrarEmLargura();
            case 4 -> {
                System.out.println("\nTodos os percursos:");
                menuApp.mostrarPreOrdem();
                menuApp.mostrarPosOrdem();
                menuApp.mostrarEmLargura();
            }
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void encontrarLCA() {
        System.out.println("\n--- LCA (Lowest Common Ancestor) ---");
        System.out.print("Primeiro item: ");
        String item1 = scanner.nextLine().trim();
        if (item1.isEmpty()) {
            System.out.println("Nome do primeiro item não pode ser vazio.");
            return;
        }

        System.out.print("Segundo item: ");
        String item2 = scanner.nextLine().trim();
        if (item2.isEmpty()) {
            System.out.println("Nome do segundo item não pode ser vazio.");
            return;
        }

        menuApp.encontrarLCA(item1, item2);
    }

    private static void mostrarCaminho() {
        System.out.println("\n--- Caminho entre itens ---");
        System.out.print("Origem: ");
        String origem = scanner.nextLine().trim();
        if (origem.isEmpty()) {
            System.out.println("Nome da origem não pode ser vazio.");
            return;
        }

        System.out.print("Destino: ");
        String destino = scanner.nextLine().trim();
        if (destino.isEmpty()) {
            System.out.println("Nome do destino não pode ser vazio.");
            return;
        }

        menuApp.mostrarCaminho(origem, destino);
    }

    private static void verificarConsistencia() {
        System.out.println("\n--- Verificar consistência ---");
        menuApp.verificarConsistencia();
    }

    private static void buscarItem() {
        System.out.println("\n--- Buscar item ---");
        System.out.print("Nome do item: ");
        String item = scanner.nextLine().trim();
        if (item.isEmpty()) {
            System.out.println("Nome do item não pode ser vazio.");
            return;
        }

        menuApp.buscarItem(item);
    }

    private static void reinicializarMenu() {
        System.out.println("\n--- Reinicializar menu ---");
        System.out.print("Confirmar reinicialização? (S/N): ");
        String confirmacao = scanner.nextLine().trim();

        if (confirmacao.equalsIgnoreCase("S")) {
            menuApp = new MenuApp();
            System.out.println("Menu reinicializado com sucesso.");
            System.out.println("\nNova estrutura:");
            menuApp.visualizarMenu();
        } else {
            System.out.println("Operação cancelada.");
        }
    }

    private static void pausar() {
        System.out.print("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
