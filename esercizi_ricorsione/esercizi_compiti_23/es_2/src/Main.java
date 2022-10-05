public class Main {
    public static int somma(int[] v, int i, int f){
        if (i == f)
            return v[i];
        return somma(v, i, (i + f) / 2) + somma(v, (i + f) / 2 + 1, f);
    }

    public static void main(String[] args) {
        int DIM = 15;
        int[] v = new int[DIM];
        for (int i = 0; i < DIM; i++) {
            v[i] = (int)(Math.random() * 10);
        }
        for (int i = 0; i < DIM; i++) {
            System.out.print(v[i] + "+");
        }
        System.out.println(); System.out.println();
        System.out.println("la somma degli elementi è: " + somma(v, 0, DIM - 1));
    }
}