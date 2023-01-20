import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> parole = letturaFile();
        menu(parole);
    }

    public static ArrayList<String> letturaFile() {
        ArrayList<String> parole = new ArrayList<>();
        Scanner nome = new Scanner(System.in);
        System.out.print("Inserisci il nome del file da leggere: ");
        String nomeFile = nome.nextLine();
        try {
            Scanner letturaFile = new Scanner(new File(nomeFile));
            while (letturaFile.hasNext()) {
                parole.add(letturaFile.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato.");
            System.exit(50);
        }
        return parole;
    }

    public static void menu(ArrayList<String> parole) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Scegli un'opzione:");
            System.out.println("1)Numero di caratteri;");
            System.out.println("2)Numero di parole;");
            System.out.println("3)Numero di parole che iniziano con lettera maiuscola;");
            System.out.println("4)Numero di segni di interpunzione;");
            System.out.println("5)Esci.\n");
            String scelta = in.nextLine();
            switch (scelta) {
                case "1":
                    int numeroParole = 0;
                    for (String p : parole) {
                        numeroParole += p.length();
                    }
                    System.out.println("\nIl numero di caratteri è: " + numeroParole + "\n");
                    break;
                case "2":
                    System.out.println("\nIl numero di parole è: " + parole.size() + "\n");
                    break;
                case "3":
                    int letteraMaiuscola = 0;
                    for (String p : parole) {
                        if (Character.isUpperCase(p.charAt(0))) {
                            letteraMaiuscola++;
                        }
                    }
                    System.out.println("\nIl numero di parole che iniziano con lettera maiuscola è: " + letteraMaiuscola + "\n");
                    break;
                case "4":
                    int segni = 0;
                    for (String p : parole) {
                        for (int i = 0; i < p.length(); i++) {
                            if (",.;:!?-".contains(Character.toString(p.charAt(i)))) {
                                segni++;
                            }
                        }
                    }
                    System.out.println("\nIl numero di segni di interpunzione è: " + segni + "\n");
                    break;
                case "5":
                    System.out.println("\nProgramma terminato");
                    return;
                default:
                    System.out.println("Opzione non valida, riprova.\n");
                    break;
            }
        }
    }
}