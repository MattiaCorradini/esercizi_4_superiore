import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Frazione g= new Frazione(in.nextInt(), in.nextInt());
        Frazione f= new Frazione(in.nextInt(), in.nextInt());
        System.out.println(g.somma(f));
        System.out.println(g.sottrazione(f));
        System.out.println(g.moltiplicazione(f));
        System.out.println(g.divisione(f));
    }
}