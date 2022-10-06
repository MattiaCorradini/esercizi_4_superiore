public class Main {
    public static int massimo(int[] v, int i, int f){
        if (i == f)
            return v[i];
        int o = massimo(v, i, (i + f) / 2);
        int s = massimo(v, (i + f) / 2 + 1, f);
        return Math.min(o, s);
    }

    public static void main(String[] args) {
        int DIM = 15;
        int[] v = new int[DIM];
        for (int i = 0; i < DIM; i++) {
            v[i] = (int)(Math.random() * 100);
        }
        for (int i = 0; i < DIM; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println(); System.out.println();
        System.out.println("il minimo degli elementi del vettore è: " + massimo(v, 0, DIM - 1));
    }
}