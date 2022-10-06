public class Main {
    public static boolean ricerca(int[] v, int t, int i, int f){
        if (i>=f)
            return false;
        if (v[i]==t)
            return true;
        return ricerca(v, t, i+1, f);
    }
    public static void main(String[] args) {
        final int DIM=20;
        int t=4, j=0;
        int[] v = new int[DIM];
        for (int i = 0; i < DIM; i++) {
            v[i] = (int)(Math.random() * 100);
        }
        for (int i = 0; i < DIM; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println(); System.out.println();
        if (!ricerca(v, t, j, DIM))
            System.out.println("il numero " + t + " non è presente nel vettore.");
        if (ricerca(v, t, j, DIM))
            System.out.println("il numero " + t + " è presente nel vettore.");
    }
}