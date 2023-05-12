package listatest;

public class Nodo {
    int info;
    Nodo next;

    public Nodo(){
        this.info = 0;
        next = null;
    }
    public Nodo(int info){
        this.info = info;
        next = null;
    }
    public Nodo(int info, Nodo nodo){
        this.info= info;
        next = nodo;
    }
}
