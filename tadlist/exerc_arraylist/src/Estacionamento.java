public class Estacionamento {
    private static final int CAPACIDADE_ESTACIONAMENTO = 3;
    private static final int CAPACIDADE_LISTA_ESPERA = 3;

    private ListArrayOfCarro estacionamento;
    private ListArrayOfCarro listaEspera;

    public Estacionamento() {
        this.estacionamento = new ListArrayOfCarro(CAPACIDADE_ESTACIONAMENTO);
        this.listaEspera = new ListArrayOfCarro(CAPACIDADE_LISTA_ESPERA);
    }

    public String adicionarCarro(Carro carro) {
        String placa = carro.getPlaca().getCodigo();

        if (estacionamento.contains(placa) || listaEspera.contains(placa)) {
            return "Erro: Carro com placa " + placa + " já está no sistema!";
        }

        if (estacionamento.addOrdered(carro)) {
            return "Carro " + placa + " adicionado ao estacionamento.\n" +
                    "Estacionamento: " + estacionamento.toString();
        }

        if (listaEspera.addOrdered(carro)) {
            return "Estacionamento cheio! Carro " + placa + " foi inserido na lista de espera.\n" +
                    "Lista de espera: " + listaEspera.toString();
        }

        return "Erro: Estacionamento e lista de espera estão cheios!";
    }

    public String removerCarro(String placa) {

        if (estacionamento.remove(placa)) {
            String resultado = "Carro " + placa + " removido do estacionamento.";

            if (!listaEspera.isEmpty()) {
                Carro proximoCarro = listaEspera.removeFirst();
                estacionamento.addOrdered(proximoCarro);
                resultado += "\nCarro " + proximoCarro.getPlaca().getCodigo() +
                        " entrou no estacionamento.";
            }

            resultado += "\nEstacionamento: " + estacionamento.toString();
            resultado += "\nLista de espera: " + listaEspera.toString();
            return resultado;
        }

        if (listaEspera.remove(placa)) {
            return "Carro " + placa + " removido da lista de espera.\n" +
                    "Lista de espera: " + listaEspera.toString();
        }

        return "Erro: Carro com placa " + placa + " não encontrado no sistema.";
    }

    public String buscarCarroSequencial(String placa) {
        int posEstacionamento = estacionamento.indexOfSequencial(placa);
        int posListaEspera = listaEspera.indexOfSequencial(placa);

        StringBuilder resultado = new StringBuilder();
        resultado.append("Busca por placa: ").append(placa).append("\n");

        if (posEstacionamento != -1) {
            resultado.append("# Encontrado no estacionamento (posição ").append(posEstacionamento + 1).append(")");
        } else {
            resultado.append("# Não encontrado no estacionamento");
        }

        resultado.append("\n");

        if (posListaEspera != -1) {
            resultado.append("# Encontrado na lista de espera (posição ").append(posListaEspera + 1).append(")");
        } else {
            resultado.append("# Não encontrado na lista de espera");
        }

        if (posEstacionamento == -1 && posListaEspera == -1) {
            resultado.append("\n\nCarro não está no sistema.");
        }

        return resultado.toString();
    }

    public String buscarCarroBinaria(String placa) {
        int posEstacionamento = estacionamento.indexOfBinaria(placa);
        int posListaEspera = listaEspera.indexOfBinaria(placa);

        StringBuilder resultado = new StringBuilder();
        resultado.append("Busca por placa: ").append(placa).append("\n");

        if (posEstacionamento != -1) {
            resultado.append("# Encontrado no estacionamento (posição ").append(posEstacionamento + 1).append(")");
        } else {
            resultado.append("# Não encontrado no estacionamento");
        }

        resultado.append("\n");

        if (posListaEspera != -1) {
            resultado.append("# Encontrado na lista de espera (posição ").append(posListaEspera + 1).append(")");
        } else {
            resultado.append("# Não encontrado na lista de espera");
        }

        if (posEstacionamento == -1 && posListaEspera == -1) {
            resultado.append("\n\nCarro não está no sistema.");
        }

        return resultado.toString();
    }

    public void exibirSituacao() {
        System.out.println("Capacidade do estacionamento: " + CAPACIDADE_ESTACIONAMENTO);
        System.out.println("Capacidade da lista de espera: " + CAPACIDADE_LISTA_ESPERA);
        System.out.println("\nEstacionamento (" + estacionamento.size() + "/" +
                CAPACIDADE_ESTACIONAMENTO + "): " + estacionamento.toString());
        System.out.println("Lista de espera (" + listaEspera.size() + "/" +
                CAPACIDADE_LISTA_ESPERA + "): " + listaEspera.toString());
    }
}
