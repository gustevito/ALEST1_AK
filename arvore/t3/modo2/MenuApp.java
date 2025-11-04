import java.util.*;

public class MenuApp {
    private GenericTree<String> menuTree;

    public MenuApp() {
        this.menuTree = new GenericTree<>("App");
        inicializarMenuPadrao();
    }

    /**
     * Inicializa um menu padrão com alguns itens
     */
    private void inicializarMenuPadrao() {
        // Primeiro nível
        menuTree.addChild("App", "Conta");
        menuTree.addChild("App", "Pagamentos");
        menuTree.addChild("App", "Configurações");
        menuTree.addChild("App", "Ajuda");

        // Submenu Conta
        menuTree.addChild("Conta", "Perfil");
        menuTree.addChild("Conta", "Segurança");
        menuTree.addChild("Conta", "Histórico");

        // Submenu Pagamentos
        menuTree.addChild("Pagamentos", "Cartões");
        menuTree.addChild("Pagamentos", "Transferências");
        menuTree.addChild("Pagamentos", "Boletos");

        // Submenu Configurações
        menuTree.addChild("Configurações", "Notificações");
        menuTree.addChild("Configurações", "Privacidade");
        menuTree.addChild("Configurações", "Aparência");
        menuTree.addChild("Configurações", "Idioma");

        // Submenus mais profundos
        menuTree.addChild("Segurança", "Senha");
        menuTree.addChild("Segurança", "Autenticação 2FA");
        menuTree.addChild("Notificações", "E-mail");
        menuTree.addChild("Notificações", "Push");
        menuTree.addChild("Notificações", "SMS");
    }

    /**
     * Adiciona um novo item ao menu
     */
    public boolean adicionarItem(String pai, String novoItem) {
        if (menuTree.search(novoItem) != null) {
            System.out.println("Erro: Item '" + novoItem + "' já existe no menu.");
            return false;
        }

        boolean sucesso = menuTree.addChild(pai, novoItem);
        if (sucesso) {
            System.out.println("Item '" + novoItem + "' adicionado em '" + pai + "'.");
        } else {
            System.out.println("Erro: Não foi possível encontrar o item pai '" + pai + "'.");
        }
        return sucesso;
    }

    /**
     * Move uma subárvore para outro local
     */
    public boolean moverSubarvore(String item, String novoPai) {
        boolean sucesso = menuTree.moveSubtree(item, novoPai);
        if (sucesso) {
            System.out.println("Subárvore '" + item + "' movida para '" + novoPai + "'.");
        } else {
            System.out.println("Erro: Não foi possível mover '" + item + "' para '" + novoPai + "'.");
            System.out.println("Verifique se os itens existem e se não criaria um ciclo.");
        }
        return sucesso;
    }

    /**
     * Remove uma subárvore inteira
     */
    public boolean removerSubarvore(String item) {
        if (item.equals("App")) {
            System.out.println("Erro: Não é possível remover a raiz do aplicativo.");
            return false;
        }

        GenericTree.Node<String> node = menuTree.search(item);
        if (node == null) {
            System.out.println("Erro: Item '" + item + "' não encontrado.");
            return false;
        }

        // Contar quantos itens serão removidos
        int count = countSubtreeNodes(node);

        boolean sucesso = menuTree.removeSubtree(item);
        if (sucesso) {
            System.out.println("Subárvore '" + item + "' removida (" + count + " itens no total).");
        }
        return sucesso;
    }

    private int countSubtreeNodes(GenericTree.Node<String> node) {
        if (node == null)
            return 0;
        int count = 1;
        for (GenericTree.Node<String> child : node.getChildren()) {
            count += countSubtreeNodes(child);
        }
        return count;
    }

    /**
     * Mostra estatísticas do menu
     */
    public void mostrarEstatisticas() {
        System.out.println("\n::: ESTATÍSTICAS DO MENU :::");
        System.out.println("Altura da árvore: " + menuTree.height());
        System.out.println("Grau máximo: " + menuTree.maxDegree());
        System.out.println("Número de folhas: " + menuTree.countLeaves());
        System.out.println("Número de nós internos: " + menuTree.countInternalNodes());
        System.out.println("Total de itens: " + menuTree.size());
    }

    /**
     * Mostra percurso em pré-ordem
     */
    public void mostrarPreOrdem() {
        System.out.println("\n::: Percurso Pré-Ordem :::");
        List<String> percurso = menuTree.preOrder();
        System.out.println(String.join(" → ", percurso));
    }

    /**
     * Mostra percurso em pós-ordem
     */
    public void mostrarPosOrdem() {
        System.out.println("\n::: Percurso Pós-Ordem :::");
        List<String> percurso = menuTree.posOrder();
        System.out.println(String.join(" → ", percurso));
    }

    /**
     * Mostra percurso em largura
     */
    public void mostrarEmLargura() {
        System.out.println("\n::: Percurso em Largura :::");
        List<String> percurso = menuTree.levelOrder();
        System.out.println(String.join(" → ", percurso));
    }

    /**
     * Encontra o LCA entre dois itens
     */
    public void encontrarLCA(String item1, String item2) {
        String lca = menuTree.findLCA(item1, item2);
        if (lca != null) {
            System.out.println("\nLCA(" + item1 + ", " + item2 + ") = " + lca);
            System.out.println("'" + lca + "' é o menu que agrupa '" + item1 + "' e '" + item2 + "'.");
        } else {
            System.out.println("\nErro: Não foi possível encontrar LCA entre '" +
                    item1 + "' e '" + item2 + "'.");
        }
    }

    /**
     * Mostra o caminho de navegação entre dois itens
     */
    public void mostrarCaminho(String de, String para) {
        List<String> caminho = menuTree.findPath(de, para);
        if (!caminho.isEmpty()) {
            System.out.println("\nCaminho de '" + de + "' até '" + para + "':");
            System.out.println(String.join(" → ", caminho));
            System.out.println("Total de passos: " + (caminho.size() - 1));
        } else {
            System.out.println("\nErro: Não foi possível encontrar caminho de '" +
                    de + "' para '" + para + "'.");
        }
    }

    /**
     * Verifica a consistência do menu
     */
    public void verificarConsistencia() {
        System.out.println("\n::: VERIFICAÇÃO DE CONSISTÊNCIA :::");
        boolean consistente = menuTree.checkConsistency();

        if (consistente) {
            System.out.println("# Menu consistente:");
            System.out.println("  - Possui uma única raiz ('App')");
            System.out.println("  - Não possui ciclos");
            System.out.println("  - Estrutura hierárquica válida");
        } else {
            System.out.println("# Menu INCONSISTENTE!");
            System.out.println("  Possíveis problemas:");
            System.out.println("  - Múltiplas raízes");
            System.out.println("  - Presença de ciclos");
        }
    }

    /**
     * Visualiza a estrutura completa do menu
     */
    public void visualizarMenu() {
        System.out.println("\n::: ESTRUTURA DO MENU :::");
        menuTree.printTree();
    }

    /**
     * Limpa o menu e recria apenas com a raiz
     */
    public void limparMenu() {
        menuTree = new GenericTree<>("App");
        System.out.println("Menu limpo. Apenas 'App' permanece.");
    }

    /**
     * Busca um item no menu
     */
    public boolean buscarItem(String item) {
        GenericTree.Node<String> node = menuTree.search(item);
        if (node != null) {
            System.out.println("Item '" + item + "' encontrado!");

            // Mostrar informações sobre o item
            System.out.println("  - É folha: " + (node.isLeaf() ? "Sim" : "Não"));
            System.out.println("  - É raiz: " + (node.isRoot() ? "Sim" : "Não"));
            if (!node.isRoot()) {
                System.out.println("  - Pai: " + node.getParent().getElement());
            }
            System.out.println("  - Número de filhos: " + node.getDegree());
            if (!node.isLeaf()) {
                System.out.print("  - Filhos: ");
                List<String> filhos = new ArrayList<>();
                for (GenericTree.Node<String> child : node.getChildren()) {
                    filhos.add(child.getElement());
                }
                System.out.println(String.join(", ", filhos));
            }
            return true;
        } else {
            System.out.println("Item '" + item + "' não encontrado no menu.");
            return false;
        }
    }
}