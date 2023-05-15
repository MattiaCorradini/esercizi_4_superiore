import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GenerazioneTesto {
    HashMap<String, HashSet<String>> mappa;

    public GenerazioneTesto(){
        this.mappa = new HashMap<>();
    }

    public void allena(ArrayList<String> testo){
        for (int i = 0; i < testo.size()-1; i++) {
            if (!mappa.containsKey(testo.get(i)))
                mappa.put(testo.get(i), new HashSet<>());
            mappa.get(testo.get(i)).add(testo.get(i+1));
        }
    }

    public ArrayList<String> genera(int dim){
        ArrayList<String> testo = new ArrayList<>();
        ArrayList<String> chiave = new ArrayList<>(mappa.keySet());
        ArrayList<String> suffissi = new ArrayList<>(mappa.get(chiave.get((int)(Math.random()*chiave.size()))));
        int j = (int)(Math.random()* suffissi.size());
        String st = suffissi.get(j);
        while ((st.charAt(0) <= 'A' || st.charAt(0) >= 'Z') && j < suffissi.size()-1) {
            j++;
            st = suffissi.get(j);
        }
        testo.add(st);

        for (int i = 1; i < dim-1; i++) {
            j = (int)(Math.random()* suffissi.size());
            if (mappa.containsKey(testo.get(i-1))){
                suffissi = new ArrayList<>(mappa.get(testo.get(i-1)));
                j = (int)(Math.random()* suffissi.size());
                testo.add(suffissi.get(j));
            }
            else{
                if (!testo.get(i-1).contains(".")) {
                    testo.add(".");
                }
                suffissi = new ArrayList<>(mappa.get(chiave.get((int)(Math.random()*chiave.size()))));
                String s = suffissi.get(j);
                while ((s.charAt(0) <= 'A' || s.charAt(0) >= 'Z') && j < suffissi.size()-1) {
                    j++;
                    s = suffissi.get(j);
                }
                testo.add(s);
            }
        }
        return testo;
    }
}

