public class Main {

    public static boolean ricerca_bin(int[] v, int t, int i, int f){
        if (i>=f)
            return false;
        int centro=(i+f)/2;
        if (v[centro]==t)
            return true;
        else if (v[centro]<t)
            return ricerca_bin(v, t, i, centro-1);
        else
            return ricerca_bin(v, t, centro+1, f);
    }

    public static void main(String[] args) {
        final int DIM=20;
        int t=4, j=0;
        int[] v = new int[DIM];
        for (int i = 0; i < DIM; i++) {
            v[i] = (int)(Math.random() * 10);
        }
        for (int i = 0; i < DIM; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println(); System.out.println();
        if (!ricerca_bin(v, t, j, DIM))
            System.out.println("il numero " + t + " non è presente nel vettore.");
        if (ricerca_bin(v, t, j, DIM))
            System.out.println("il numero " + t + " è presente nel vettore.");
    }
}