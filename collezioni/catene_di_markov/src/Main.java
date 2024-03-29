import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<String> parole = letturaFile();
        genera(parole);
    }

    public static ArrayList<String> letturaFile() {
        ArrayList<String> testo = new ArrayList<>();
        Scanner nome = new Scanner(System.in);
        System.out.print("Inserisci il nome del file da leggere: ");
        String nomeFile = nome.nextLine();
        try {
            Scanner letturaFile = new Scanner(new File(nomeFile));
            while (letturaFile.hasNext()) {
                testo.add(letturaFile.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato.");
            System.exit(50);
        }
        System.out.println(testo.size());
        return testo;
    }
    public static void genera(ArrayList<String> testo) throws IOException {
        int i = 0;
        Scanner in = new Scanner(System.in);
        GenerazioneTesto gt = new GenerazioneTesto();
        gt.allena(testo);
        System.out.print("Inserisci il numero di parole che desideri per il tuo testo: ");
        int n = in.nextInt();
        ArrayList<String> testoGenerato = gt.genera(n);
        StringBuilder output = new StringBuilder();
        for (String word : testoGenerato) {
            if (word == ".")
                output.delete(output.length()-1, output.length());
            output.append(word).append(' ');
            if (i == 0){
                char c = output.charAt(0);
                c -= 32;
                output.deleteCharAt(0);
                output.insert(0, c);
            }
            i++;
            if (i==15){
                output.append("\n");
                i=1;
            }

        }
        output.delete(output.length()-1, output.length());
        output.append(".");
        FileWriter out = new FileWriter("output.txt");
        out.write(output.toString());
        out.close();
    }
}