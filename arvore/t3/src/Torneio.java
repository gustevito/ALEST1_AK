import java.util.*;

public class Torneio {
    private BinaryTreeOfInteger arvore;
    private Map<Integer, String> participantes; // ID -> Nome
    private Map<String, Integer> nomeParaId; // Nome -> ID
    private int proximoId;

    public Torneio() {
        this.arvore = new BinaryTreeOfInteger();
        this.participantes = new HashMap<>();
        this.nomeParaId = new HashMap<>();
        this.proximoId = 1;
    }

    /**
     * Cria um torneio a partir de uma lista de participantes (8 a 32)
     */
    public boolean criarTorneio(List<String> nomesParticipantes) {
        int n = nomesParticipantes.size();

        // Validar número de participantes
        if (n < 8 || n > 32) {
            System.out.println("Erro: O torneio deve ter entre 8 e 32 participantes.");
            return false;
        }

        // Verificar se é potência de 2
        if ((n & (n - 1)) != 0) {
            System.out.println("Erro: O número de participantes deve ser uma potência de 2 (8, 16 ou 32).");
            return false;
        }

        // Limpar estruturas anteriores
        arvore.clear();
        participantes.clear();
        nomeParaId.clear();
        proximoId = 1;

        // Calcular altura da árvore necessária
        int altura = (int) (Math.log(n) / Math.log(2));

        // Criar a árvore completa primeiro
        Integer raizId = criarArvoreCompleta(altura);

        // Agora preencher as folhas com os participantes
        preencherFolhas(nomesParticipantes);

        System.out.println("Torneio criado com sucesso para " + n + " participantes!");
        return true;
    }

    /**
     * Cria uma árvore binária completa com a altura especificada
     */
    private Integer criarArvoreCompleta(int altura) {
        Integer nodeId = proximoId++;
        participantes.put(nodeId, "___"); // Nodo vazio inicialmente

        if (arvore.isEmpty()) {
            arvore.addRoot(nodeId);
        }

        if (altura > 0) {
            criarSubarvore(nodeId, altura - 1, true); // Esquerda
            criarSubarvore(nodeId, altura - 1, false); // Direita
        }

        return nodeId;
    }

    /**
     * Cria uma subárvore recursivamente
     */
    private void criarSubarvore(Integer paiId, int alturaRestante, boolean isEsquerda) {
        Integer nodeId = proximoId++;
        participantes.put(nodeId, "___");

        if (isEsquerda) {
            arvore.addLeft(nodeId, paiId);
        } else {
            arvore.addRight(nodeId, paiId);
        }

        if (alturaRestante > 0) {
            criarSubarvore(nodeId, alturaRestante - 1, true); // Esquerda
            criarSubarvore(nodeId, alturaRestante - 1, false); // Direita
        }
    }

    /**
     * Preenche as folhas da árvore com os participantes
     */
    private void preencherFolhas(List<String> nomes) {
        LinkedListOfInteger todos = arvore.positionsPre();
        List<Integer> folhas = new ArrayList<>();

        // Identificar as folhas
        for (Integer id : todos) {
            if (!arvore.hasLeft(id) && !arvore.hasRight(id)) {
                folhas.add(id);
            }
        }

        // Ordenar folhas pela ordem de percurso em largura para manter organização
        Collections.sort(folhas);

        // Preencher as folhas com os nomes
        for (int i = 0; i < nomes.size() && i < folhas.size(); i++) {
            Integer folhaId = folhas.get(i);
            String nome = nomes.get(i);
            participantes.put(folhaId, nome);
            nomeParaId.put(nome, folhaId);
        }
    }

    /**
     * Registra o vencedor de uma partida
     */
    public boolean registrarVencedor(String nomeVencedor) {
        if (!nomeParaId.containsKey(nomeVencedor)) {
            System.out.println("Erro: Participante '" + nomeVencedor + "' não encontrado.");
            return false;
        }

        Integer idVencedor = nomeParaId.get(nomeVencedor);
        Integer idPai = arvore.getParent(idVencedor);

        if (idPai == null) {
            System.out.println("Erro: " + nomeVencedor + " já é o campeão!");
            return false;
        }

        // Verificar se ambos os filhos do pai já jogaram
        Integer idEsq = arvore.getLeft(idPai);
        Integer idDir = arvore.getRight(idPai);

        String jogadorEsq = participantes.get(idEsq);
        String jogadorDir = participantes.get(idDir);

        if (jogadorEsq.equals("___") || jogadorDir.equals("___")) {
            System.out.println("Erro: A partida ainda não está pronta (falta oponente).");
            return false;
        }

        // Verificar se o jogador está em uma das posições
        if (!idVencedor.equals(idEsq) && !idVencedor.equals(idDir)) {
            // Procurar se o jogador já avançou
            boolean encontrado = false;
            LinkedListOfInteger caminho = new LinkedListOfInteger();
            obterCaminhoAteRaiz(idVencedor, caminho);

            for (Integer id : caminho) {
                if (participantes.get(id).equals(nomeVencedor)) {
                    idVencedor = id;
                    idPai = arvore.getParent(id);
                    if (idPai != null) {
                        idEsq = arvore.getLeft(idPai);
                        idDir = arvore.getRight(idPai);
                        if (idVencedor.equals(idEsq) || idVencedor.equals(idDir)) {
                            encontrado = true;
                            break;
                        }
                    }
                }
            }

            if (!encontrado) {
                System.out.println("Erro: " + nomeVencedor + " não está nesta partida.");
                return false;
            }
        }

        // Registrar o vencedor
        participantes.put(idPai, nomeVencedor);
        nomeParaId.remove(nomeVencedor);
        nomeParaId.put(nomeVencedor, idPai);

        System.out.println(nomeVencedor + " venceu a partida!");

        // Verificar se é a final
        if (arvore.getParent(idPai) == null) {
            System.out.println("\n🏆 " + nomeVencedor + " É O CAMPEÃO DO TORNEIO! 🏆");
        }

        return true;
    }

    /**
     * Mostra percurso em pré-ordem
     */
    public void mostrarPreOrdem() {
        System.out.println("\n=== Percurso Pré-Ordem ===");
        LinkedListOfInteger lista = arvore.positionsPre();
        for (Integer id : lista) {
            System.out.print(participantes.get(id) + " ");
        }
        System.out.println();
    }

    /**
     * Mostra percurso em pós-ordem
     */
    public void mostrarPosOrdem() {
        System.out.println("\n=== Percurso Pós-Ordem ===");
        LinkedListOfInteger lista = arvore.positionsPos();
        for (Integer id : lista) {
            System.out.print(participantes.get(id) + " ");
        }
        System.out.println();
    }

    /**
     * Mostra percurso em largura
     */
    public void mostrarEmLargura() {
        System.out.println("\n=== Percurso em Largura ===");
        LinkedListOfInteger lista = arvore.positionsWidth();
        for (Integer id : lista) {
            System.out.print(participantes.get(id) + " ");
        }
        System.out.println();
    }

    /**
     * Mostra altura da árvore
     */
    public void mostrarAltura() {
        System.out.println("\nAltura da árvore: " + arvore.height());
    }

    /**
     * Mostra número de folhas e nós internos
     */
    public void mostrarEstatisticas() {
        int folhas = arvore.countLeaves();
        int nosInternos = arvore.size() - folhas;
        System.out.println("\n=== Estatísticas do Torneio ===");
        System.out.println("Número de participantes (folhas): " + folhas);
        System.out.println("Número de partidas (nós internos): " + nosInternos);
        System.out.println("Total de nós: " + arvore.size());
    }

    /**
     * Encontra o LCA (primeira partida onde dois jogadores podem se enfrentar)
     */
    public void encontrarLCA(String jogador1, String jogador2) {
        System.out.println("\n=== LCA (Lowest Common Ancestor) ===");

        Integer id1 = buscarIdJogador(jogador1);
        Integer id2 = buscarIdJogador(jogador2);

        if (id1 == null || id2 == null) {
            System.out.println("Erro: Um ou ambos os jogadores não foram encontrados.");
            return;
        }

        // Obter caminhos até a raiz
        LinkedListOfInteger caminho1 = new LinkedListOfInteger();
        LinkedListOfInteger caminho2 = new LinkedListOfInteger();

        obterCaminhoAteRaiz(id1, caminho1);
        obterCaminhoAteRaiz(id2, caminho2);

        // Encontrar o primeiro ancestral comum
        Integer lca = null;
        for (int i = 0; i < caminho1.size(); i++) {
            for (int j = 0; j < caminho2.size(); j++) {
                if (caminho1.get(i).equals(caminho2.get(j))) {
                    lca = caminho1.get(i);
                    break;
                }
            }
            if (lca != null)
                break;
        }

        if (lca == null) {
            System.out.println("Erro: Não foi possível encontrar LCA.");
            return;
        }

        String fase = determinarFase(lca);
        System.out.println("LCA(" + jogador1 + ", " + jogador2 + ") = " + fase);
        System.out.println("Primeira partida possível entre eles: nó " + lca);
    }

    /**
     * Mostra o caminho de um jogador até a final
     */
    public void mostrarCaminho(String jogador) {
        System.out.println("\n=== Caminho até a Final ===");

        Integer id = buscarIdJogador(jogador);
        if (id == null) {
            System.out.println("Erro: Jogador '" + jogador + "' não encontrado.");
            return;
        }

        LinkedListOfInteger caminho = new LinkedListOfInteger();
        obterCaminhoAteRaiz(id, caminho);

        System.out.println("Caminho de " + jogador + " até a final:");

        // Verificar se já foi eliminado
        boolean eliminado = false;
        Integer ondeEliminado = null;

        for (int i = 1; i < caminho.size(); i++) { // Pula o próprio jogador
            Integer idPartida = caminho.get(i);
            String vencedor = participantes.get(idPartida);

            if (!vencedor.equals("___") && !vencedor.equals(jogador)) {
                eliminado = true;
                ondeEliminado = idPartida;
                break;
            }
        }

        if (eliminado) {
            System.out.println(jogador + " foi ELIMINADO na " + determinarFase(ondeEliminado));
            System.out.println("Vencedor da partida: " + participantes.get(ondeEliminado));
        } else {
            System.out.println("Partidas que " + jogador + " precisa vencer:");
            for (int i = 1; i < caminho.size(); i++) {
                Integer idPartida = caminho.get(i);
                String status = participantes.get(idPartida);
                String fase = determinarFase(idPartida);

                if (status.equals("___")) {
                    System.out.println("- " + fase + " (aguardando)");
                } else if (status.equals(jogador)) {
                    System.out.println("- " + fase + " (✓ vencida)");
                }
            }

            if (caminho.size() == 1 || (caminho.size() > 1 &&
                    participantes.get(arvore.getRoot()).equals(jogador))) {
                System.out.println(jogador + " é o CAMPEÃO!");
            }
        }
    }

    /**
     * Busca o ID de um jogador pelo nome
     */
    private Integer buscarIdJogador(String nome) {
        // Primeiro verifica o mapa direto
        if (nomeParaId.containsKey(nome)) {
            return nomeParaId.get(nome);
        }

        // Se não encontrar, procura em todos os nós
        for (Map.Entry<Integer, String> entry : participantes.entrySet()) {
            if (entry.getValue().equals(nome)) {
                return entry.getKey();
            }
        }

        return null;
    }

    /**
     * Obtém o caminho de um nó até a raiz
     */
    private void obterCaminhoAteRaiz(Integer nodeId, LinkedListOfInteger caminho) {
        Integer atual = nodeId;
        while (atual != null) {
            caminho.add(atual);
            atual = arvore.getParent(atual);
        }
    }

    /**
     * Determina a fase do torneio baseado no nível do nó
     */
    private String determinarFase(Integer nodeId) {
        // Contar quantos níveis faltam até a raiz
        int nivel = 0;
        Integer atual = nodeId;
        while (arvore.getParent(atual) != null) {
            nivel++;
            atual = arvore.getParent(atual);
        }

        if (nivel == 0)
            return "Final";
        if (nivel == 1)
            return "Semifinal";
        if (nivel == 2)
            return "Quartas de final";
        if (nivel == 3)
            return "Oitavas de final";
        if (nivel == 4)
            return "16-avos de final";

        return "Fase " + nivel;
    }

    /**
     * Mostra o estado visual do torneio
     */
    public void mostrarEstadoVisual() {
        System.out.println("\n=== Estado Visual do Torneio ===");
        mostrarArvoreFormatada(arvore.getRoot(), "", true);
    }

    private void mostrarArvoreFormatada(Integer nodeId, String prefix, boolean isTail) {
        if (nodeId == null)
            return;

        String nome = participantes.get(nodeId);
        System.out.println(prefix + (isTail ? "└── " : "├── ") + nome);

        Integer esq = arvore.getLeft(nodeId);
        Integer dir = arvore.getRight(nodeId);

        if (esq != null || dir != null) {
            if (esq != null) {
                mostrarArvoreFormatada(esq, prefix + (isTail ? "    " : "│   "), false);
            }
            if (dir != null) {
                mostrarArvoreFormatada(dir, prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }
}