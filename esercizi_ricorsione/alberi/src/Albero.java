import java.util.Iterator;

public class Albero {
    private final Nodo root;
    private int quanti;

    public Albero(int n) {
        root = new Nodo(n);
        quanti++;
    }

    private Nodo cercaNodo(Nodo attuale, int n){
        if (attuale.getInfo() == n)
            return attuale;
        Nodo temp = null;
        Iterator<Nodo> i = attuale.getIteratoreFigli();
        while (i.hasNext()){
            temp = cercaNodo(i.next(), n);
            if (temp != null)
                break;
        }
        return temp;
    }

    public boolean aggiungiFiglio(int dove, int n){
        Nodo padre = cercaNodo(root, dove);
        if (padre == null){
            return false;
        }
        padre.aggiungiFiglio(n);
        quanti++;
        return true;
    }

    private void visitaAnticipataR(Nodo n)
    {
        System.out.print(n.getInfo() + " -> " );
        Iterator<Nodo> i = n.getIteratoreFigli();
        while(i.hasNext()){
            visitaAnticipataR(i.next());
        }
    }

    public void visitaAnticipata()
    {
        visitaAnticipataR(root);
        System.out.println( "end");
    }

    private void visitaPosticipataR(Nodo n)
    {
        Iterator<Nodo> i = n.getIteratoreFigli();
        while(i.hasNext()){
            visitaAnticipataR(i.next());
        }
        System.out.print(n.getInfo() + " -> ");
    }

    public void visitaPosticipata()
    {
        visitaPosticipataR(root);
        System.out.println("end");
    }

    public int size(){
        return quanti;
    }

    public boolean empty(){
        return quanti == 0;
    }

    private int massimoR(Nodo nodo){
        int max = nodo.getInfo();
        Iterator <Nodo> i = nodo.getIteratoreFigli();
        while (i.hasNext()){
            max = Math.max(max, massimoR(i.next()));
        }
        return max;
    }

    public int massimo(){
        return massimoR(root);
    }

    private int profonditaR(Nodo nodo, int num, int p){
        if (nodo.getInfo() == num)
            return p;
        Iterator <Nodo> i = nodo.getIteratoreFigli();
        while (i.hasNext()){
            int temp = profonditaR(i.next(),num, p+1);
            if (temp != -1)
                return temp;
        }
        return -1;
    }
    public int profondita(int n){
        return profonditaR(root,n, 0);
    }

}