public class Main {
    public static final int DIM = 100000;
    /**
     * funzione che fonde tra loro due vettori ordinati
     * @param v vettore in cui fondere i due vettori
     * @param inizio posizione iniziale v[0] del vettore
     * @param fine posizione finale v[v.lenght-1] del vettore
     * @param centro posizione del vettore che lo separa dagli altri due
     */
    public static void merge(int[] v, int inizio, int fine, int centro){
        int i = inizio, j = centro + 1, k = inizio;
        int[] vett = new int[DIM];
        while (i <= centro && j <= fine){
            if (v[i] < v[j]){
                vett[k] = v[i];
                i++;
            }
            else{
                vett[k] = v[j];
                j++;
            }
            k++;
        }
        while (i <= centro){
            vett[k] = v[i];
            k++;
            i++;
        }
        while (j <= fine){
            vett[k] = v[j];
            k++;
            j++;
        }
        for (i=inizio; i <= fine; i++)
            v[i] = vett[i];
    }
    /**
     * funzione che serve a riordinare un vettore
     * @param v vettore da ordinare
     * @param inizio posizione iniziale del vettore
     * @param fine posizione finale del vettore
     */
    public static void mergeSort(int[] v, int inizio, int fine){
        if (inizio >= fine)
            return;
        int m = (inizio + fine) / 2;
        mergeSort(v, inizio, m);
        mergeSort(v, m + 1, fine);
        merge(v, inizio, fine, m);
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
        int[] v = new int[DIM];
        long inizio = System.currentTimeMillis();
        for (int i = 0; i < DIM; i++) {
            v[i] = (int)(Math.random()*1000000);
        }
        mergeSort(v, 0, DIM-1);
        for (int i = 0; i < DIM; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println(); System.out.println();
        if (ordinato(v))
            System.out.println(" Il vettore è ordinato!");
        if (!ordinato(v))
            System.out.println(" Il vettore non è non ordinato T_T");
        long fine = System.currentTimeMillis();
        System.out.println();
        System.out.println(" Con " + DIM + " elementi, il programma ha impiegato "
                + (fine - inizio) / 1000.0 + " secondi a fornire il vettore riordinato.");
    }
}
