public class Main {
    private static final int DIM = 100000;
    /**
     * scorrendo tutto il vettore porta il valore minimo nella posizione v[0] del sottovettore
     * @param v vettore da riordinare
     */
    public static void selectionSort(int[] v) {
        for (int i = 0; i < v.length; i++) {
            int min = i;
            for (int j = i + 1; j < v.length; j++) {
                if (v[min] > v[j]){
                    min = j;
                }
            }
            int t = v[min];
            v[min] = v[i];
            v[i] = t;
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
            v[i] = (int)(Math.random() * 1000000);
        }
        long inizio = System.currentTimeMillis();
        selectionSort(v);
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
