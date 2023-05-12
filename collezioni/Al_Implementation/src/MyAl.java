public class MyAl {
    private final static int START_DIM = 16;
    private int[] v;
    private int n_items = 0;

    /**
     * costruttore per istanziare l'oggetto
     */
    public MyAl(){
        v = new int[START_DIM];
    }

    /**
     * aggiunge l'elemento specificato in coda alla lista
     * @param n il numero da aggiungere
     * @return true se l'aggiunta è andata a buon fine
     */
    public boolean add(int n){
        if (n_items >= v.length){
            int[] new_v = new int[v.length*2];
            System.arraycopy(v, 0, new_v, 0, n_items);
            v = new_v;
        }
        v[n_items] = n;
        n_items++;
        return true;
    }

    /**
     * aggiunge l'elemento specificato nella posizione specificata alla lista
     * @param n il numero da aggiungere
     * @param index la posizione a cui aggiungere n
     * @throws IndexOutOfBoundsException controlla che l'indice sia presente nella lista
     * @return true se l'aggiunta è andata a buon fine
     */
    public boolean add(int n, int index) throws IndexOutOfBoundsException{
        if (index >= n_items || index < 0)
            throw new IndexOutOfBoundsException();
        v[index] = n;
        n_items++;
        return true;
    }

    /**
     * Returns the number of elements in the list.
     * @return number of elements in the list
     */
    public int size(){
        return n_items;
    }

    /**
     * ritorna l'elemento associato alla posizione nella lista
     * @param n l'elemento da cercare
     * @return la posizione dell'elemento
     * @throws IndexOutOfBoundsException controlla che l'indice sia presente nella lista
     */
    public int get(int n) throws IndexOutOfBoundsException{
        if (n >= n_items || n < 0)
            throw new IndexOutOfBoundsException();
        return v[n];
    }

    /**
     * rimuove tutti gli elementi della lista
     */
    public void clear(){
        n_items=0;
    }

    /**
     * verifica la presenza di un elemento all'interno della lista
     * @param n l'elemento de cercare
     * @return true se l'elemento è presente
     */
    public boolean contains(int n){
        for (int i = 0; i < n_items; i++) {
            if (v[i]==n)
                return true;
        }
        return false;
    }

    /**
     * controlla se la lista è vuota
     * @return true se la lista è vuota
     */
    public boolean isEmpty(){
        return v.length == 0;
    }

    /**
     * rimuove l'elemento in posizione index e lo ritorna
     * @param index l'indice dell'elemento da ritornare
     * @return l'elemento associato all'indice eliminato
     * @throws IndexOutOfBoundsException controlla che l'indice sia presente
     */
    public int remove(int index) throws IndexOutOfBoundsException{
        if (index >= n_items || index < 0)
            throw new IndexOutOfBoundsException();
        int n = v[index];
        for (int i = index; i < n_items-1; i++) {
            v[i]=v[i+1];
        }
        n_items--;
        return n;
    }

    /**
     * ritorna l'indice della prima occorrenza di n, se non è presente ritorna -1
     * @param n l'elemento da cercare
     * @return la prima occorrenza di n o -1 se non è presente
     */
    public int indexOf(int n){
        for (int i = 0; i < n_items; i++) {
            if (v[i] == n){
                return i;
            }
        }
        return -1;
    }
}
