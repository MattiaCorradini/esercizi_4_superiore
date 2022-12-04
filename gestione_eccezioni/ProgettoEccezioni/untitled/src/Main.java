import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /**
     * Metodo che crea una ricorsione infinita dando origine a uno StackOverFlowError
     * @param n 1
     * @return 1
     */
    public static int problema (int n){
        if (n == 0)
            return 1;
        return problema(1);
    }

    public static void main(String[] args) {
        /*
        try { //"quando farai l'operazione al mio interno, se succede qualcosa chiama il catch"
            int n = problema(1);
        }catch (StackOverflowError a){ //sempre meglio essere specifici nelle eccezioni, si possono lanciare più catch
            System.out.println(a);
        }
        */

        /*
        //Le eccezioni unchecked in generale non si intercettano, se capitano il programma crolla e si interviene
        Integer a;
        a = 12;
        a = null;
        try {
            System.out.println(a.byteValue());
        }catch (NullPointerException e){
            System.out.println(e);
        }
         */

        //Eccezioni checked gestibili
        int []v = new int[10];
        for (int i = 0; i < v.length; i++) {
            v[i]=i;
        }
        for (int i = 0; i < v.length-1; i++) { //so che così esce dal vettore se metto v.lenght(), quindi aggiungo il -1
            if (v[i] > v[i+1]){
                System.out.println("Fai qualcosa");
            }
        }

        //Eccezione recuperabile
        Scanner in = new Scanner(System.in);
        int n=0;
        do {
            try {
                n = in.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Devi inserire un intero.");
                in.nextLine();
            }
        }while (n == 0);


        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = buf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}