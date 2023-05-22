import java.util.Iterator;
import java.util.LinkedList;

public class Nodo {
    private int info;
    private LinkedList<Nodo> figli;

    public Nodo(int info) {
        this.info = info;
        figli = new LinkedList<>();
    }

    public int getInfo() {
        return info;
    }

    public Iterator<Nodo> getIteratoreFigli() {
        return figli.iterator();
    }

    public void aggiungiFiglio(int n) {
        figli.add(new Nodo(n));
    }
}