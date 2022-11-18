import java.util.Scanner;

public class Main {
    public static void menu(){
        System.out.println("0) esci.");
        System.out.println("1) modalità normale.");
        System.out.println("2) modalità impostazione ore orario.");
        System.out.println("3) modalità impostazione minuti orario.");
        System.out.println("4) modalità impostazione ore sveglia.");
        System.out.println("5) modalità impostazione munti sveglia.");
    }
    public static void main(String[] args) {
        Sveglia s = new Sveglia();
        Scanner in = new Scanner(System.in);
        menu();
        System.out.print("Inserisci il numero in base a quello che desideri fare: ");
        int modalita= in.nextInt();
        int o = s.setModalita(modalita);
        while (o!=0) {
            if (modalita == 1){
                System.out.println();
                System.out.println(s);
                System.out.println();
            }
            if (modalita==2) {
                System.out.println();
                s.impostaOrario();
                s.setOre();
                System.out.println(s);
                System.out.println();
            }
            if (modalita==3){
                System.out.println();
                s.impostaOrario();
                s.setMinuti();
                System.out.println(s);
                System.out.println();
            }
            if (modalita==4){
                System.out.println();
                s.impostaSveglia();
                s.setOre();
                System.out.println(s);
                System.out.println();
            }
            if (modalita==5){
                System.out.println();
                s.impostaSveglia();
                s.setMinuti();
                System.out.println(s);
                System.out.println();
            }
            menu();System.out.println();
            System.out.print("Premere 0 per uscire o una diversa opzione in base al menù: ");
            modalita= in.nextInt();
            o = s.setModalita(modalita);
        }
    }
}