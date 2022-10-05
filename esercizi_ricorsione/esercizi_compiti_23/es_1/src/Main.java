public class Main {
    public static void inverti(int[] v, int i, int f){
        if (i>=f)
            return;
        int t=v[i];
        v[i]=v[f];
        v[f]=t;
        inverti(v, i+1, f-1);
    }

    public static void main(String[] args) {
        int DIM=14;
        int []v= new int[DIM];
        for (int i = 0; i < DIM; i++) {
            v[i] = (int)(Math.random() * 100);
        }
        for (int i = 0; i < DIM; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println(); System.out.println();
        inverti(v, 0, v.length-1);
        for (int i = 0; i < DIM; i++) {
            System.out.print(v[i] + " ");
        }
    }
}