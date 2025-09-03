/**
 * Classe que implementa uma lista linear usando arranjo.
 * 
 * @author Isabel H. Manssour
 */

public class ListArrayOfInteger {

    private static final int INITIAL_SIZE = 10;
    private Integer[] data;
    private int count;

    public ListArrayOfInteger() {
        this(INITIAL_SIZE);
    }

    public ListArrayOfInteger(int tam) {
        if (tam <= 0) {
            tam = INITIAL_SIZE;
        }
        data = new Integer[tam];
        count = 0;
    }

    public void clear() {
        data = new Integer[INITIAL_SIZE];
        count = 0;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public int size() {
        return count;
    }

    public void add(Integer element) {
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        data[count] = element;
        count++;
    }

    public void remove(Integer element) {
        for (int i = 0; i < count; i++) {
            if (data[i].equals(element)) {
                for (int j = i; j < count - 1; j++) {
                    data[j] = data[j + 1];
                }
                data[count - 1] = null;
                count--;
                break;
            }
        }
    }

    public int get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        return data[index];
    }

    public boolean set(int index, int newElement) {
        if (index < 0 || index >= count) {
            return false;
        } else {
            data[index] = newElement;
            return true;
        }
    }

    private void setCapacity(int newCapacity) {
        if (newCapacity != data.length) {
            int min = 0;
            Integer[] newData = new Integer[newCapacity];
            if (data.length < newCapacity) {
                min = data.length;
            } else {
                min = newCapacity;
            }
            for (int i = 0; i < min; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    public boolean contains(int element) {
        for (int i = 0; i < count; i++) {
            if (data[i] = element) {
                return true;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count; i++) {
            s.append(data[i]);
            if (i != (count - 1)) {
                s.append(",");
            }
        }
        s.append("\n");
        return s.toString();
    }
}
