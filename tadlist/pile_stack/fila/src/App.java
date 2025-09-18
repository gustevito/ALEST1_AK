
public class App {
    public static void main(String[] args) {
        FilaArray f = new FilaArray();
        f.enqueue(10);
        f.enqueue(20);
        f.enqueue(30);
        f.enqueue(40);
        
        for(int i=0; i<f.size(); i++) {
            System.out.println(f.head());
            f.enqueue(f.dequeue());
        }
        
        System.out.println("Tamanho da fila: " + f.size());
        
        while (!f.isEmpty()) {
            System.out.println(f.dequeue());
        }
        
        System.out.println("Tamanho da fila: " + f.size());
             
    }
}
