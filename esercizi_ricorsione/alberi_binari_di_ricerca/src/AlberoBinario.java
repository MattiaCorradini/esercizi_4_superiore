public class AlberoBinario {
    private Nodo root;
    private int quanti;

    public AlberoBinario(int n) {
        root = new Nodo(n);
        quanti++;
    }

    public void add(int n) {
        if (root == null)
            root = new Nodo(n);
        else
            addR(root, n);
    }

    private void addR(Nodo nodo, int n) {
        if (n < nodo.info){
            if (nodo.sx == null)
                nodo.sx = new Nodo(n);
            else
                addR(nodo.sx, n);
        }
        if (n > nodo.info) {
            if (nodo.dx == null)
                nodo.dx = new Nodo(n);
            else
                addR(nodo.dx, n);
        }
    }

    private void visitaAnticipataR(Nodo attuale){
        System.out.print(attuale.info + " -> ");
        if (attuale.sx != null)
            visitaAnticipataR(attuale.sx);
        if (attuale.dx != null)
            visitaAnticipataR(attuale.dx);
    }

    public void visitaAnticipata(){
        visitaAnticipataR(root);
    }

    private void visitaPosticipataR(Nodo attuale){
        if (attuale.sx != null)
            visitaPosticipataR(attuale.sx);
        if (attuale.dx != null)
            visitaPosticipataR(attuale.dx);
        System.out.print(attuale.info + " -> ");
    }

    public void visitaPosticipata(){
        visitaPosticipataR(root);
    }

    private void visitaInOrdineR(Nodo nodo){
        if (nodo == null)
            return;
        visitaInOrdineR(nodo.sx);
        System.out.println(nodo.info);
        visitaInOrdineR(nodo.dx);
    }

    public void visitaInOrdine() {
        visitaInOrdineR(root);
    }

    private boolean ricercaR(Nodo nodo, int n){
        if (nodo == null)
            return false;
        if (nodo.info == n)
            return true;
        if (n < nodo.info)
            return ricercaR(nodo.sx, n);
        else
            return ricercaR(nodo.dx, n);
    }

    public boolean ricerca(int n) {
        return ricercaR(root, n);
    }

    private int quantiMinoriR(int n, Nodo nodo){
        if (nodo == null)
            return 0;
        if (nodo.info < n){
            return 1 + quantiMinoriR(n, nodo.sx) + quantiMinoriR(n, nodo.dx);
        }
        else
            return quantiMinoriR(n, nodo.sx);
    }

    public int quantiMinori(int n){
        return quantiMinoriR(n, root);
    }

    private int sommaMinoreR(Nodo nodo){
        if (nodo.dx == null && nodo.sx == null)
            return nodo.info;
        int d = Integer.MAX_VALUE, s = Integer.MAX_VALUE;
        if (nodo.dx != null)
            d = sommaMinoreR(nodo.dx);
        if (nodo.sx != null)
            s = sommaMinoreR(nodo.sx);
        if (s < d)
            return s + nodo.info;
        else
            return d + nodo.info;
    }

    public int sommaMinore(){
        return sommaMinoreR(root);
    }
}
