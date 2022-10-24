public class Main {
    private static final int DIM = 10000000;
    /**
     * riordina il vettore facendo scorrere il vettore e scambiando ogni volta due numeri adiacenti
     * tra loro che non sono in ordine crescente
     * @param v il vettore da riordinare
     */
    public static void bubbleSort(int[] v) {
        boolean scambio = true;
        int inizio = 0;
        while (scambio){
            scambio = false;
            for (int i = v.length - 1; i > inizio; i--) {
                if (v[i] < v[i-1]){
                    int t = v[i];
                    v[i] = v[i-1];
                    v[i-1] = t;
                    scambio = true;
                }
            }
            inizio++;
        }
    }
    /**
     * funzione che testa la correttezza del programma (se il vettore è stato orinato correttamente o no)
     * @param a il vettore da esaminare
     * @return "true" se il vettore è ordinato e quindi il programma funziona o "false" in caso contrario
     */
    public static boolean ordinato(int[] a) {
        if (a.length <= 1)
            return true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1])
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int []v= new int[DIM];
        for (int i = 0; i < v.length; i++) {
            v[i] = (int)(Math.random() * 100000000);
        }
        long inizio = System.currentTimeMillis();
        bubbleSort(v);
        for (int i = 0; i < DIM; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println(); System.out.println();
        if (ordinato(v))
            System.out.println(" Il vettore è ordinato!");
        if (!ordinato(v))
            System.out.println(" Il vettore non è non odinato T_T");
        long fine = System.currentTimeMillis();
        System.out.println();
        System.out.println(" Con " + DIM + " elementi, il programma ha impiegato "
                + (fine - inizio) / 1000.0 + " secondi a fornire il vettore riordinato.");
    }
}