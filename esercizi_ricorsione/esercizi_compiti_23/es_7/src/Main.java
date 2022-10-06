public class Main {
    public static int sommaDispari(int[] v, int n){
        if (n < 1)
            return 0;
        return sommaDispari(v, n - 2) + v[v.length - n];
    }

    public static void main(String[] args) {
        int DIM = 10;
        int[] v = new int[DIM];
        for (int i = 0; i < DIM; i++) {
            v[i] = (int)(Math.random() * 10);
        }
        for (int i = 0; i < DIM; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println(); System.out.println();
        System.out.println("Somma dei posti dispari del vettore: " + sommaDispari(v, DIM));
    }
}