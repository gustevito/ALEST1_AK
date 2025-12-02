import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        int[] A = { 1, 2, 3, 4, 6 };
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        HashSet<Integer> numeros = new HashSet<>();

        for (int num : A) {
            if (num > 0) {
                numeros.add(num);
            }
        }

        int menor = 1;
        while (numeros.contains(menor)) {
            menor++;
        }

        return menor;
    }
}
