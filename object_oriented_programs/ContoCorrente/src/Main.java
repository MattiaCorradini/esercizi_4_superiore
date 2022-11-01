import java.util.Scanner;
public class Main {

    public static void Menu(){
        System.out.println("0) esci");
        System.out.println("1) visualizza il denaro residuo");
        System.out.println("2) preleva");
        System.out.println("3) deposita");
    }

    public static void main(String[] args) {
        Scanner nome = new Scanner(System.in);
        System.out.print("Inserisci nome e cognome del titolare del conto: ");
        ContoCorrente c = new ContoCorrente(nome.next(), nome.next()); System.out.println();
        System.out.println(c); System.out.println();
        Scanner in0 = new Scanner(System.in);
        Menu();
        System.out.print("Inserisci la tua scelta: ");
        int scelta = in0.nextInt();
        System.out.println();
        while (scelta != 0) {
            if (scelta == 1)
                System.out.println(c);
            if (scelta == 2) {
                System.out.print("Inserisci la somma da prelevare: ");
                Scanner in1 = new Scanner(System.in);
                float s = in1.nextFloat();
                if (s >= c.getSaldo()) {
                    System.out.println("Non hai abbastanza denaro nel tuo conto, seleziona 1 per depositare o 2 per uscire.");
                    Scanner in2 = new Scanner(System.in);
                    int a = in2.nextInt();
                    if (a == 1) {
                        System.out.print("Inserisci al somma da depositare: ");
                        Scanner in3 = new Scanner(System.in);
                        float d = in3.nextFloat();
                        c.deposita(d);
                    }
                    if (a == 2)
                        return;
                } else
                    c.preleva(s);
            }
            if (scelta == 3) {
                System.out.print("Inserisci al somma da depositare: ");
                Scanner in3 = new Scanner(System.in);
                float d = in3.nextFloat();
                c.deposita(d);
            }
            System.out.println(); Menu();
            System.out.print("Continua o esci inserendo il numero: ");
            scelta = in0.nextInt(); System.out.println();
        }
    }
}