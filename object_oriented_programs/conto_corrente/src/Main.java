import java.util.Scanner;
public class Main {
    public static void Menu() {
        System.out.println("0) vedi lo stato del conto");
        System.out.println("1) preleva");
        System.out.println("2) deposita");
        System.out.println("3) esci");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ContoCorrente c = new ContoCorrente("simone", "vacca");
        Menu();
        System.out.print("Inserisci un numero in base a ciò che vuoi fare: ");
        int scelta = in.nextInt();
        System.out.println();
        while (true) {
            if (scelta == 0)
                System.out.println(c);
            if (scelta == 1) {
                System.out.print("inserisci i soldi da prelevare: ");
                Scanner in5 = new Scanner(System.in);
                float ritiro= in5.nextFloat();
                if (c.getSaldo()<ritiro) {
                    System.out.println("non hai abbastanza soldi, premi 2 per depositarne o 3 per uscire");
                    Scanner in2 = new Scanner(System.in);
                    int s=in2.nextInt();
                    if (s==2) {
                        Scanner in4 = new Scanner(System.in);
                        System.out.print("inserisci la somma da depositare: ");
                        float deposito = in4.nextFloat();
                        c.deposita(deposito);
                    }
                    if (s==3)
                        return;
                }
                else
                    c.preleva(ritiro);
            }
            if (scelta == 2) {
                System.out.print("Inserisci quanti soldi vuoi depositare: ");
                Scanner in3 = new Scanner(System.in);
                float deposito= in3.nextFloat();
                c.deposita(deposito);
            }
            if (scelta == 3)
                break;
            System.out.println();
            System.out.println("Seleziona la prossima scelta:");
            Menu();
            System.out.println();
            scelta=in.nextInt();
        }
    }
}