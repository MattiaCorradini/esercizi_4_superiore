import AInformatica.Banca;
import AInformatica.ContoCorrente;
import AInformatica.Movimento;

import java.util.Scanner;

public class Main {
    /**
     * Metodo crea dei conti correnti "di prova".
     * @param b l'oggetto banca che contiene i conti corrente.
     */
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

    /**
     * Metodo che stampa tutti i conti corrente contenuti nell'oggetto banca.
     * @param b l'oggetto banca che contiene i conti corrente.
     */
    static void mostraConti (Banca b){
        ContoCorrente[] a;
        a = b.getConti();
        int i = 0;
        while(a[i] != null){
            System.out.println(a[i]);
            i++;
        }
    }

    /**
     * Metodo che stampa tutti i movimenti associati a un determinato conto corrente.
     * @param b l'oggetto conto corrente di cui si vogliono sapere i movimenti.
     */
    static void mostraMovimenti(ContoCorrente b){
        Movimento[] a;
        a = b.numeroMovimenti();
        int i=0;
        while(a[i] != null){
            System.out.println(a[i]);
            i++;
        }
    }

    /**
     * Menù che permette di scegliere quale azione effettuare su di un conto.
     */
    public static void Menu(){
        System.out.println("0) torna al menù principale;");
        System.out.println("1) visualizza il conto;");
        System.out.println("2) preleva;");
        System.out.println("3) deposita;");
    }

    /**
     * Menù che mostra le varie opzioni in base a ciò che si vuole fare in banca.
     */
    public static void Menu2(){
        System.out.println("0) esci;");
        System.out.println("1) seleziona un conto;");
        System.out.println("2) crea un conto;");
        System.out.println("3) mostra tutti i conti;");
        System.out.println("4) mostra i movimenti relativi ad un conto;");
    }

    public static void main(String[] args) {
        Banca b = new Banca();
        AssegnaConti(b);
        Menu2();
        Scanner cognome = new Scanner(System.in);
        System.out.print("->Seleziona l'azione che vuoi compiere: ");
        Scanner in2 = new Scanner(System.in);
        int scelta2= in2.nextInt();
        while (scelta2!=0){
            if (scelta2==1){
                System.out.println();
                System.out.print("Inserisci il cognome associato al conto desiderato: ");
                String c = cognome.next();
                System.out.println();
                ContoCorrente[] t = b.ricercaPerCognome(c);
                ContoCorrente contoAttuale;
                for (ContoCorrente contoCorrente : t) {        //for (int i = 0; i < t.length; i++) {
                    System.out.println(contoCorrente);         //   System.out.println(t[i]);
                }                                              //}
                System.out.println();
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
                Menu();
                Scanner in0 = new Scanner(System.in);
                System.out.print("->Seleziona l'azione che vuoi compiere sul conto, oppure torna al menù principale: ");
                int scelta = in0.nextInt();
                while (scelta!=0){
                    if (scelta==1) {
                        System.out.println();
                        System.out.println(contoAttuale);
                    }
                    if (scelta == 2) {
                        System.out.println();
                        System.out.print("Denaro da prelevare: ");
                        float s = in0.nextFloat();
                        if (s > contoAttuale.getSaldo()) {
                            System.out.println("Non hai abbastanza denaro nel tuo conto.");
                        }
                        else {
                            System.out.print("Motivo del prelievo: ");
                            Scanner moti= new Scanner(System.in);
                            String motivo= moti.nextLine();
                            contoAttuale.preleva(s, motivo);
                        }
                    }
                    if (scelta==3){
                        System.out.println();
                        System.out.print("Denaro da depositare: ");
                        float p= in0.nextFloat();
                        Scanner desc = new Scanner(System.in);
                        System.out.print("Motivo del deposito: ");
                        String descrizione= desc.nextLine();
                        contoAttuale.deposita(p, descrizione);
                    }
                    System.out.println(); Menu();
                    System.out.print("->Continua o torna al menù principale inserendo il numero: ");
                    scelta = in0.nextInt(); System.out.println();
                }
            }
            if (scelta2==2){
                System.out.println();
                System.out.print("Inserisci il nome: ");
                String n= cognome.nextLine();
                System.out.print("Inserisci il cognome: ");
                String c= cognome.nextLine();
                b.creaConto(n, c);
            }
            if (scelta2==3){
                System.out.println();
                mostraConti(b);
            }
            if (scelta2==4){
                System.out.println();
                System.out.print("Inserisci il cognome associato al conto di cui vuoi vedere i movimenti: ");
                String c = cognome.next();
                System.out.println();
                ContoCorrente[] t = b.ricercaPerCognome(c);
                ContoCorrente contoAttuale;
                for (ContoCorrente contoCorrente : t) {
                    System.out.println(contoCorrente);
                }
                System.out.println();
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
                if (contoAttuale.numeroMovimenti()[0]!=null)
                    mostraMovimenti(contoAttuale);
                else
                    System.out.println("Non sono ancora stati effettuati movimenti su questo conto.");
            }
            System.out.println(); Menu2();
            System.out.print("->Continua o esci inserendo il numero: ");
            scelta2 = in2.nextInt();
        }
    }
}
