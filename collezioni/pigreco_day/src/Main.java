import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Myll ll = new Myll();
        StringBuilder pi = new StringBuilder();
        Scanner in = new Scanner(new File("one-million.txt"));
        while (in.hasNext()){
            String s =in.nextLine();
            pi.append(s);
        }
        for (int i = pi.length()-1; i >= 0;  i--) {
            ll.add((Character.getNumericValue(pi.charAt(i))));
        }
//        HashMap<Integer, Integer> mappa = new HashMap<>();
//        for (int i = 0; i < pi.length(); i++) {
//            if (mappa.containsKey(ll.get(i))) {
//                Integer n = mappa.get(ll.get(i));
//                n++;
//                mappa.put(ll.get(i), n);
//            }else
//                mappa.put(ll.get(i), 1);
//        }
//        System.out.println(mappa);
//        int index = pi.indexOf("494808863207734526534495606973");
//        System.out.println(index);
        int max = 0;
        Nodo nodo = ll.getHead();
        for (int i = 0; i < pi.length(); i++) {


            int distanza =0;
            int n = nodo.info;
            Nodo n2 = nodo.next;
            while (n2.info != n){
                distanza++;
                n2 = nodo.next;
            }
            max = Math.max(distanza, max);
            nodo = nodo.next;
        }
        System.out.println(max);
    }
}