public class App {
    public static void main(String[] args) {
        Pilha p = new Pilha();

        p.push(2);
        p.push(6);
        p.push(3);
        p.push(4);
        p.push(10);
        p.push(1);
        System.out.println("- Pilha desordenada: " + p.toString());

        p.pop();
        p.pop();
        p.pop();
        System.out.println("- Pilha após remoção: " + p.toString());

        p.sort();
        System.out.println("- Pilha ordenada (extra): " + p.toString());
    }
}