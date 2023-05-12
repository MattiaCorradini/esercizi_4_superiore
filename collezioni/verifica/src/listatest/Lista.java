package listatest;

//CORRADINI MATTIA

/**
 * Attenzione, la parte public non deve assolutamente essere modificata
 * pena il fallimento dei test e una forte penalizzazione nei punteggi
 * Si possono riutilizzare pezzi di codici già scritti a lezione o in
 * laboratorio, senza però utilizzare le classi di libreria come
 * ArrayList, LinkedList o altro. Viene consigliato di mantenere
 * l'implementazione con un solo riferimento a head e semplicemente
 * concatenata, ma anche altre implementazioni sono valide basta
 * che siano delle liste (usare un vettore è evidentemente non valido)
 * e che rispettino l'interfaccia pubblica e quanto richiesto
 */

public class Lista {
    //Implementazione suggerita, può essere modificata
    private Nodo head;
    private int n_items;

    /**
     * Crea una lista vuota
     */
    public Lista(){
        head = null;
        n_items = 0;
    }

    /**
     <pre>Ritorna il contenuto della lista nella esatta
     forma indicata negli esempi seguenti.
     Se la lista fosse 34, 23, 65
     la stringa ritornata sarebbe
     34 -> 23 -> 65 -|
     Se la lista fosse vuota la lista sarebbe
     -|
     da notare lo spazio prima di -|</pre>
     * @return La stringa che rappresenta la lista nel formato indicato
     */
    @Override
    public String toString()
    {
        if (n_items == 0)
            return " -|";
        Nodo nodo = head;
        String s = "";
        while (nodo != null) {
            s += nodo.info + " -> ";
            nodo = nodo.next;
        }
        return s.substring(0, s.length() -2) + "-|";
    }

    /**
     * Inserisce l'elemento n in testa alla lista.
     * Se la lista fosse 34, 23, 65 e n valesse 13
     * la lista diventerebbe 13, 34, 23, 65
     * @param n L'elemento da inserire in testa alla lista
     */
    public void inserisciInTesta(int n)
    {
        Nodo nodo = new Nodo(n, head);
        head = nodo;
        n_items ++;
    }

    /**
     * Inserisce l'elemento n in fondo alla lista.
     * Se la lista fosse 34, 23, 65 e n valesse 13
     * la lista diventerebbe 34, 23, 65, 13
     * @param n L'elemento da inserire in fondo alla lista
     */
    public void inserisciInCoda(int n)
    {
        Nodo nodo = new Nodo(n, null);
        if (head == null) {
            head = nodo;
        } else {
            Nodo temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = nodo;
        }
        n_items++;
    }

    /**
     * Inserisce l'elemento n nella posizione indicata da pos
     * Vedere la lista come un vettore : 0,1,2,3...
     * posizione 2 = terza "casella"
     * posizione 0 = "casella" iniziale
     * Se la posizione è fuori dalla lista l'elemento
     * viene inserito comunque, in prima posizione se
     * pos è negativo, in ultima se è maggiore del numero
     * di elementi.
     * Se la lista fosse 34, 23, 65, se pos valesse 2 e n valesse 13
     * la lista diventerebbe 34, 23, 13, 65
     * @param pos posizione dove inserire l'elemento
     * @param n elemento da inserire
     */
    public void inserisciInPosizione(int pos, int n)
    {
        Nodo nodo;
        Nodo temp = head;
        if (pos < 0){
            inserisciInTesta(n);
            return;
        }
        if (pos > n_items){
            inserisciInCoda(n);
            return;
        }
        int giri = 0;
        while (giri != pos-1){
            temp = temp.next;
            giri++;
        }
        nodo = new Nodo();
        nodo.next = temp.next;
        temp.next = nodo;
        nodo.info = n;
        n_items++;
    }

    /**
     * Elimina il primo elemento della lista
     * Se la lista fosse vuota, non produrrebbe nessun effetto
     * Se la lista fosse 34, 23, 65
     * la lista diventerebbe 23, 65
     */
    public void eliminaInTesta()
    {
        head = head.next;
    }

    /**
     * Elimina l'ultimo elemento della lista
     * Se la lista fosse vuota, non produrrebbe nessun effetto
     * Se la lista fosse 34, 23, 65
     * la lista diventerebbe 34, 23
     */

    public void eliminaInCoda()
    {
        Nodo nodo = head;
        while (nodo.next.next != null) {
            nodo = nodo.next;
        }
        nodo.next = null;
    }

    /**
     * Elimina l'elemento in posizione pos della lista
     * Se la posizione non fosse valida, non produrrebbe nessun effetto
     * Se la lista fosse 34, 23, 65, 13 e pos fosse 2
     * la lista diventerebbe 34, 23, 13
     * @param pos posizione dell'elemento da eliminare
     */
    public void eliminaInPosizione(int pos)
    {
        Nodo temp = head;
        if (pos < 0 || pos > n_items)
            return;
        int giri = 0;
        while (giri != pos-1){
            temp = temp.next;
            giri++;
        }
        Nodo s = temp.next;
        temp.next = s.next;
    }

    /**
     * Ritorna il numero di elementi della lista
     * che hanno valore n
     * Se la lista fosse 34, 23, 65, 23 e n fosse 23
     * ritornerebbe 2
     * @param n Il valore da cercare
     * @return Il numero di occorrenze di n nella lista
     */
    public int quanti(int n)
    {
        Nodo temp = head;
        int c = 0;
        for (int i = 0; i < n_items; i++) {
            if (temp.info == n)
                c++;
            temp = temp.next;
        }
        return c;
    }

    /**
     * Ritorna il numero di elementi presenti nella lista
     * Se la lista fosse 34, 23, 65, 13
     * ritornerebbe 4
     * @return Il numero di elementi presenti nella lista
     */
    public int count()
    {
        return n_items;
    }

    /**
     * Restituisce la posizione del primo elemento della lista
     * che ha valore uguale a n,-1 se non ce ne sono
     * Se la lista fosse 34, 23, 65, 13 e n fosse 65
     * ritornerebbe 2
     * @param n Il valore da cercare
     * @return L'indice della prima occorrenza di n, -1 se non è presente
     */
    public int cerca(int n)
    {
        Nodo temp = head;
        for (int i = 0; i < n_items; i++) {
            if (temp.info == n)
                return i;
            temp = temp.next;
        }
        return -1;
    }

    /**
     * Concatena la lista l alla lista corrente,
     * le due liste devono rimanere separate, nel senso che una modifica
     * successiva di una non deve influenzare l'altra
     * Se la lista corrente fosse 34, 23, 65, 13 e
     * l fosse 4, 2, 6
     * la lista corrente diventerebbe 34, 23, 65, 13, 4, 2, 6
     * @param l La lista da concatenare
     */
    public void concatena(Lista l)
    {
        if (l.head == null) {
            return;
        }
        if (head == null) {
            head = l.head;
            return;
        }
        Nodo nodo = head;
        while (nodo.next != null) {
            nodo = nodo.next;
        }
        nodo.next = l.head;
    }
    /**
     * Restituisce la somma degli elementi nella lista
     * Se la lista fosse 3, 2, 6, 1 ritornerebbe 12
     * @return La somma degli elementi presenti nella lista
     */
    public int somma()
    {
        Nodo nodo = head;
        int sum = 0;
        for (int i = 0; i < n_items; i++) {
            sum += nodo.info;
            nodo = nodo.next;
        }
        return sum;
    }

    /**
     * Elimina tre elementi dalla lista a partire dalla posizione pos
     * Se non riesce a eliminare 3 elementi perchè è finita
     * la lista, cancella solo quelli che trova da pos in poi (quindi
     * 2, 1 o nessuno).
     * Se pos non fosse una posizione valida non fa niente
     * Se la lista fosse 34, 23, 65, 13, 22, 11, 76 e pos fosse 2
     * la lista diventerebbe 34, 23, 11, 76
     * @param pos La posizione del primo degli elementi da eliminare
     */
    public void eliminaTre(int pos)
    {
        if (head == null || pos < 0) {
            return;
        }
        Nodo nodo = head;
        Nodo temp = null;
        int i = 0;
        while (i < pos && nodo != null) {
            temp = nodo;
            nodo = nodo.next;
            i++;
        }
        int count = 0;
        while (nodo != null && count < 3) {
            Nodo next = nodo.next;
            if (temp == null) {
                head = next;
            } else {
                temp.next = next;
            }
            nodo = next;
            count++;
        }
    }

    /**
     *
     * Inserisce degli zeri in posizioni pari o dispari,
     * come indicato dal
     * parametro quali che può valere "pari" o "dispari"
     * Se ad esempio la lista fosse 4, 5, 67 chiamando questo metodo
     * con quali che vale "dispari" la lista diventerebbe
     * 4, 0, 5, 0, 67
     * Se quali non è la stringa "pari" o "dispari" il metodo
     * non deve far niente
     * Se la lista è vuota deve rimanere tale
     * La lista deve sempre terminare con un elemento della lista,
     * non con uno degli zeri aggiunti
     * @param quali Una stringa che se vale "pari" o "dispari" produce
     *              gli effetti indicati nel testo, altrimenti non fa niente
     */
    public void inserisciZeri(String quali)
    {
        if (head == null) {
            return;
        }
        boolean valore = false;
        if (quali.equals("pari")) {
            valore = true;
        } else if (!quali.equals("dispari")) {
            return;
        }
        Nodo nodo = head;
        int pos = 1;
        while (nodo.next != null) {
            if ((valore && pos % 2 == 0) || (!valore && pos % 2 == 1)) {
                Nodo zero = new Nodo(0);
                zero.next = nodo.next;
                nodo.next = zero;
                pos++;
            }
            nodo = nodo.next;
            pos++;
        }
    }
    /**
     * Rimuove dalla lista gli elementi il cui valore è minore
     * della media dei valori della lista
     * Se la lista fosse 34, 23, 65, 18 la media sarebbe 35
     * e quindi la lista diventerebbe 65
     */
    public void rimuoviMinoriMedia()
    {
        if (head == null) {
            return;
        }
        double sum = 0;
        int cunt = 0;
        Nodo nodo = head;
        while (nodo != null) {
            sum += nodo.info;
            cunt++;
            nodo = nodo.next;
        }
        double media = sum / cunt;
        nodo = head;
        Nodo pre = null;
        while (nodo != null) {
            if (nodo.info < media) {
                if (pre == null) {
                    head = nodo.next;
                } else {
                    pre.next = nodo.next;
                }
            } else {
                pre = nodo;
            }
            nodo = nodo.next;
        }

    }

}
