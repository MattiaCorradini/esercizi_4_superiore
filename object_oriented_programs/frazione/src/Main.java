public class Main {
    public static void main(String[] args) {
        Frazione g= new Frazione(1,2);
        Frazione f= new Frazione(3,2);
        System.out.println(g.somma(f));
        System.out.println(g.sottrazione(f));
        System.out.println(g.moltiplicazione(f));
        System.out.println(g.divisione(f));
    }
}