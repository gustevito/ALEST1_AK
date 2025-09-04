public class Carro implements Comparable<Carro> {
    private Placa placa;

    public Carro(Placa placa) {
        this.placa = placa;
    }

    // getters e setters
    public Placa getPlaca() {
        return placa;
    }

    @Override
    public int compareTo(Carro outro) {
        return this.placa.getCodigo().compareTo(outro.placa.getCodigo());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Carro carro = (Carro) obj;
        return placa.getCodigo().equals(carro.placa.getCodigo());
    }

    @Override
    public String toString() {
        return placa.getCodigo();
    }
}