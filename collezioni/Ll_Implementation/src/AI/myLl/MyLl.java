package AI.myLl;

public class MyLl {

    private Nodo head;
    private int n_items;

    public MyLl() {
        head = null;
        n_items = 0;
    }

    public boolean add(int n){
        Nodo nodo = new Nodo(n, head);
        nodo.next = head;
        head = nodo;
        n_items ++;
        return true;
    }

    public void clear(){
        n_items = 0;
        head = null;
    }

    public int get(int n){
        Nodo nodo = head;
        for (int i = 0; i < n; i++) {
            nodo = nodo.next;
        }
        return nodo.info;
    }



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
}
