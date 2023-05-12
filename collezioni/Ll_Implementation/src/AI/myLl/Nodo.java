package AI.myLl;

class Nodo {

    int info;
    Nodo next;

    public Nodo() {}
    public Nodo(int info) {
        this.info = info;
    }
    public Nodo(int info, Nodo next) {
        this.info = info;
        this.next = next;
    }
}
