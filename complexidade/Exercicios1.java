public class Exercicios1{
    
    public static int f1(int n) {
        int r = 0;
        for (int i = 1; i < n; i++) {
            r = r + 1;
        }
        return r;
    }

    public static int f2(int n) {
        int r = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                r++;
            }
        }
        return r;
    }

    public static int f3(int n){
        int r = 0;
        for(int i = 1; i<n; i++){
            for(int j = i+1; j<n; j++){
                r = r+2;
            }
        } return r;
    }

    //public static int f4(int n)
    //public static int f5(int n)

    public static void main(String[] args) {
        int op = 0;
        System.out.println("N    |#OP");

        //para cada funcao descomente a linha para chamar a funcao desejada
        for (int n = 0; n <= 300; n+=10) {
            //op = f1(n);
            op = f2(n);
            //op = f3(n);
            System.out.println(n + "  ;  " + op);
        }
    }
}