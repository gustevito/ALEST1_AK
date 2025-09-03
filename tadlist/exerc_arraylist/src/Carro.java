public class Carro {
    private String marca;
    private String cor;
    private Placa placa;

    public Carro(Placa placa, String marca, String cor) {
        this.placa = placa;
        this.marca = marca;
        this.cor = cor;
    }

    // getters e setters
    public Placa getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getCor() {
        return cor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    // metodos

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Carro: ---");
        sb.append("\nMarca: " + marca);
        sb.append("\nPlaca: " + placa);
        sb.append("\nCor: " + cor);
        return sb.toString();
    }
}
