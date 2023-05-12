public class Nodo {
    Nodo next;
    int info;

    public Nodo() {

    }
    public Nodo(Nodo next, int info) {
        this.next = next;
        this.info = info;
    }

    public Nodo(int info) {
        this.info = info;
    }
}
