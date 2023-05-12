public class Myll {
    int n_items;

    public Nodo getHead() {
        return head;
    }

    Nodo head;

    public boolean add(int n){
        Nodo nodo = new Nodo(head, n);
        head = nodo;
        n_items++;
        return true;
    }

    public boolean add(int posizione, int n){
        if (posizione > n_items || posizione < 0)
            throw new IndexOutOfBoundsException();
        Nodo nodo;
        Nodo temp = head;

        int giri = 0;
        if (posizione == 0){

            nodo = new Nodo(head, n);
            head = nodo;

            return true;
        }

        while (giri != posizione-1){
            temp = temp.next;
            giri++;
        }
        nodo = new Nodo();
        nodo.next = temp.next;
        temp.next = nodo;
        nodo.info = n;
        n_items++;
        return true;
    }


    public boolean remove(int posizione){
        if (posizione > n_items || posizione < 0)
            throw new IndexOutOfBoundsException();

        Nodo temp = head;

        int giri = 0;
        if (posizione == 0){
            head = head.next;


            return true;
        }
        while (giri != posizione-1){
            temp = temp.next;
            giri++;
        }

        Nodo s = temp.next;
        temp.next = s.next;

        return true;
    }


    public boolean contains(int n){

        Nodo temp = head;

        for (int i = 0; i < n_items; i++) {
            if (temp.info == n)
                return true;
            temp = temp.next;
        }

        return false;
    }

    public int get(int posizione){
        Nodo temp = head;
        for (int i = 0; i < posizione; i++) {

            temp = temp.next;
        }
        return temp.info;
    }

    public int indexof(int n){
        Nodo temp = head;
        for (int i = 0; i < n_items; i++) {
            if (temp.info == n)
                return i;
            temp = temp.next;
        }
        return -1;
    }

    public boolean isempty(){
        if (n_items == 0)
            return true;
        return false;
    }

    public int size() {
        return n_items;
    }

    public Nodo next(Nodo nodo){
        return nodo.next;
    }

    @Override
    public String toString(){
        Nodo nodo = head;
        String s = "[";
        while (nodo != null) {
            s += nodo.info + ", ";
            nodo = nodo.next;
        }
        if (n_items == 0)
            return "[]";
        return s.substring(0, s.length() -2) + "]";
    }

    public void efv (int n){
        Nodo nodo = new Nodo(null, n);
        if (head == null) {
            head = nodo;
        } else {
            Nodo current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = nodo;
        }
        n_items++;
    }

    public void eliminaInCoda() {
        Nodo current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void concatena(Lista otherList) {
        // If the other list is empty, there's nothing to concatenate
        if (otherList.head == null) {
            return;
        }
        // If this list is empty, simply set the head to the head of the other list
        if (head == null) {
            head = otherList.head;
            return;
        }
        // Otherwise, traverse this list until the last node is reached
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        // Once the last node is reached, set its next reference to the head of the other list
        current.next = otherList.head;
    }

    public void inserisciZeri(String quali) {
        // If the list is empty, there's nothing to do
        if (head == null) {
            return;
        }
        // Determine whether to insert zeroes at even or odd positions
        boolean isEven = false;
        if (quali.equals("pari")) {
            isEven = true;
        } else if (!quali.equals("dispari")) {
            return;
        }
        // Traverse the list and insert zeroes at the appropriate positions
        Nodo current = head;
        int pos = 1;
        while (current != null && current.next != null) {
            if ((isEven && pos % 2 == 0) || (!isEven && pos % 2 == 1)) {
                Nodo zero = new Nodo(0);
                zero.next = current.next;
                current.next = zero;
                pos++;
            }
            current = current.next;
            pos++;
        }
    }

    public void rimuoviMinoriDellaMedia() {
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

    public void eliminaDaPosizione(int pos) {
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



}
