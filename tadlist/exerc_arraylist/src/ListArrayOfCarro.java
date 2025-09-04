public class ListArrayOfCarro {
    private Carro[] data;
    private int count;
    private int maxSize;

    public ListArrayOfCarro(int maxSize) {
        this.maxSize = maxSize;
        this.data = new Carro[maxSize];
        this.count = 0;
    }

    public void clear() {
        for (int i = 0; i < count; i++) {
            data[i] = null;
        }
        count = 0;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public boolean isFull() {
        return (count == maxSize);
    }

    public int size() {
        return count;
    }

    public int maxSize() {
        return maxSize;
    }

    // inserção ordenada por placa (ordem alfabética)
    public boolean addOrdered(Carro carro) {
        if (isFull()) {
            return false;
        }

        // encontrar a posição correta para inserir
        int pos = 0;
        while (pos < count && data[pos].compareTo(carro) < 0) {
            pos++;
        }

        // deslocar elementos para abrir espaço
        for (int i = count; i > pos; i--) {
            data[i] = data[i - 1];
        }

        // inserir o carro na posição correta
        data[pos] = carro;
        count++;
        return true;
    }

    // remove carro por placa
    public boolean remove(String placa) {
        int index = indexOf(placa);
        if (index == -1) {
            return false;
        }

        // deslocar elementos para fechar o espaço
        for (int i = index; i < count - 1; i++) {
            data[i] = data[i + 1];
        }

        data[count - 1] = null;
        count--;
        return true;
    }

    public Carro removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Carro primeiro = data[0];

        // desloca para esquerda
        for (int i = 0; i < count - 1; i++) {
            data[i] = data[i + 1];
        }

        data[count - 1] = null;
        count--;
        return primeiro;
    }

    // busca sequencial por placa
    public int indexOfSequencial(String placa) {
        for (int i = 0; i < count; i++) {
            if (data[i].getPlaca().getCodigo().equals(placa)) {
                return i;
            }
        }
        return -1;
    }

    // busca binaria por placa
    public int indexOfBinaria(String placa) {
        int left = 0;
        int right = count - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int comparison = data[middle].getPlaca().getCodigo().compareTo(placa);

            if (comparison == 0) {
                return middle;
            }
            if (comparison < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    private int indexOf(String placa) {
        return indexOfSequencial(placa);
    }

    public Carro get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        return data[index];
    }

    public boolean contains(String placa) {
        return indexOf(placa) != -1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < count; i++) {
            s.append(data[i].toString());
            if (i != (count - 1)) {
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }
}