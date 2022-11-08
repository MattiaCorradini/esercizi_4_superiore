import AInformatica.Banca;
import AInformatica.ContoCorrente;
import java.util.Scanner;

public class Main {
    public static void AssegnaConti(Banca b){
        b.creaConto("Sandro", "Tonali");
        b.creaConto("Marco", "Del Lungo");
        b.creaConto("Andrea", "Bonometti");
        b.creaConto("Luca", "Stornati");
        b.creaConto("Luisa", "Vacca");
        b.creaConto("Alessandro", "Scarsato");
        b.creaConto("Francesco", "Rossi");
        b.creaConto("Daniele", "Gollini");
        b.creaConto("Gianluca", "Corradini");
        b.creaConto("Riccardo", "Vacca");
        b.creaConto("Gabriele", "Pea");
        b.creaConto("Mattia", "Zicari");
        b.creaConto("Samuele", "Bugatti");
        b.creaConto("Federico", "Ippolito");
        b.creaConto("Ercole", "Bonometti");
        b.creaConto("Giovanni", "Chiellini");
    }
    static void mostraConti (Banca b){
        ContoCorrente[] a;
        a = b.getConti();
        int i = 0;
        while(a[i] != null){
            System.out.println(a[i]);
            i++;
        }
    }
    public static void Menu(){
        System.out.println("0) torna al menù principale");
        System.out.println("1) visualizza il conto");
        System.out.println("2) preleva");
        System.out.println("3) deposita");
    }
    public static void Menu2(){
        System.out.println("0) esci");
        System.out.println("1) seleziona un conto");
        System.out.println("2) crea un conto");
        System.out.println("3) mostra tutti i conti");
        System.out.println("4) mostra i movimenti relativi al conto");
    }

    public static void main(String[] args) {
        Banca b = new Banca();
        AssegnaConti(b);
        Menu2(); System.out.println();
        System.out.print("Seleziona l'azione che vuoi compiere: ");
        Scanner in3 = new Scanner(System.in);
        int scelta2= in3.nextInt();
        while (scelta2!=0){
            if (scelta2==1){
                Scanner cognome = new Scanner(System.in);
                System.out.print("Inserisci il cognome associato al conto desiderato: ");
                String c = cognome.next();
                System.out.println();
                ContoCorrente[] t = b.ricercaPerCognome(c);
                ContoCorrente contoAttuale;
                for (ContoCorrente contoCorrente : t) {        //for (int i = 0; i < t.length; i++) {
                    System.out.println(contoCorrente);         //   System.out.println(t[i]);
                    System.out.println();                      //}
                }
                if (b.ricercaPerCognome(c).length>1){
                    Scanner id = new Scanner(System.in);
                    System.out.print("Inserisci il numero di conto associato al cognome: ");
                    int i = id.nextInt();
                    System.out.println();
                    contoAttuale = b.ricercaPerId(i);
                    System.out.println(contoAttuale); System.out.println();
                }
                else
                    contoAttuale = t[0];
                Menu(); System.out.println();
                Scanner in0 = new Scanner(System.in);
                System.out.print("Seleziona l'azione che vuoi compiere sul conto: ");
                int scelta = in0.nextInt();
                while (scelta!=0){
                    if (scelta==1) {
                        System.out.println();
                        System.out.println(contoAttuale);
                    }
                    if (scelta == 2) {
                        System.out.print("Denaro da prelevare: ");
                        float s = in0.nextFloat();
                        if (s > contoAttuale.getSaldo()) {
                            System.out.println("Non hai abbastanza denaro nel tuo conto.");
                            break;
                        }
                        else {
                            System.out.print("Motivo del prelievo: ");
                            String motivo= cognome.next();
                            contoAttuale.preleva(s, motivo);
                        }
                    }
                    if (scelta==3){
                        System.out.print("Denaro da depositare: ");
                        float p= in0.nextFloat();
                        System.out.print("Motivo del deposito: ");
                        String descrizione= cognome.next();
                        contoAttuale.deposita(p, descrizione);
                    }
                    System.out.println(); Menu();
                    System.out.print("Continua o esci inserendo il numero: ");
                    scelta = in0.nextInt(); System.out.println();
                }
            }
            if (scelta2==2){
                Scanner nomi= new Scanner(System.in);
                System.out.print("Inserisci il nome: ");
                String n= nomi.nextLine();
                System.out.print("Inserisci il cognome: ");
                String c= nomi.nextLine();
                b.creaConto(n, c);
            }
            if (scelta2==3){
                System.out.println();
                mostraConti(b);
            }
            if (scelta2==4){
                System.out.println("Non so come farlo");
            }
            System.out.println(); Menu2();
            System.out.print("Continua o esci inserendo il numero: ");
            scelta2 = in3.nextInt();
        }
    }
}
