public class Main {
    /**
     * funzione che restituisce la posizione finale del pivot riordinando tutti i numeri
     * minori di esso alla sua "sinistra" e tutti i numeri maggiori di esso alla "destra"
     * @param v vettore da dividere
     * @param inizio posizione iniziale dell'indice i
     * @param fine posizione iniziale dell'indice j
     * @return posizione finale e definitiva del pivot
     */
    public static int partition(int[] v, int inizio, int fine){
        int i=inizio, j=fine-1;
        while(i<=j){
            while (v[i] < v[fine])
                i++;
            while (j > inizio && v[j] >= v[fine])
                j--;
            if(j<=i)
                break;
            int t = v[i];
            v[i] = v[j];
            v[j] = t;
        }
        //scambio del pivot per posizionarlo nella sua posizione finale
        int t = v[i];
        v[i] = v[fine];
        v[fine] = t;
        return i;
    }
    /**
     * funzione ricorsiva che riordina il vettore di partenza dividendolo in sottovettori
     * @param v vettore da ordinare
     * @param inizio indice "i" del sottovettore (vedi descrizione funzione partition)
     * @param fine indice "j" del sottovettore (vedi descrizione funzione partition)
     */
    public static void quickSorrt(int[] v, int inizio, int fine){
        if (inizio >= fine)
            return;
        int i = partition(v, inizio, fine);
        quickSorrt(v, inizio, i - 1);
        quickSorrt(v, i + 1, fine);
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
        final int DIM = 100000;
        int[] v = new int[DIM];
        long inizio = System.currentTimeMillis();
        for (int i = 0; i < DIM; i++) {
            v[i] = (int)(Math.random()*1000000);
        }
        quickSorrt(v, 0, v.length-1);
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