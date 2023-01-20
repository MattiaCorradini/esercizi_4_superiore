import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numeri = new ArrayList<>();
        while (numeri.size()!=5){
            int i = (int)(Math.random()*20);
            if (!numeri.contains(i))
                numeri.add(i);
        }
        int tentativi=0;
        Scanner in = new Scanner(System.in);
        while (!numeri.isEmpty()){
            tentativi++;
            int i = in.nextInt();
            if (numeri.contains(i)) {
                numeri.remove((Integer)i);
                System.out.println("c'è");
            }else
                System.out.println("non c'è");
        }
        System.out.println("tutti i numeri indovinati in " + tentativi + " tentativi");
    }
}