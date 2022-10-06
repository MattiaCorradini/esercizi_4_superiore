public class Main {
    public static boolean ricerca_bin(int[] v, int valore, int i, int f){
        if (i > f)
            return false;
        int pos = (i + f) / 2;
        if (v[pos] == valore)
            return true;
        else if (v[pos] > valore)
            return ricerca_bin(v, valore, i, pos - 1);
        else
            return ricerca_bin(v, valore, pos + 1, f);
    }


    public static void main(String[] args) {
        final int DIM=20;
        int t=4;
        int[] v = new int[DIM];
        for (int i = 0; i < DIM; i++) {
            v[i] = i*10;
        }
        for (int i = 0; i < DIM; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println(); System.out.println();
        if (!ricerca_bin(v, t, 0, DIM-1))
            System.out.println("il numero " + t + " non è presente nel vettore.");
        else
            System.out.println("il numero " + t + " è presente nel vettore.");
    }
}