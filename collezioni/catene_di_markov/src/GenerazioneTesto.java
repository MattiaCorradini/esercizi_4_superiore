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
        testo.add(suffissi.get((int)(Math.random()* suffissi.size())));
        for (int i = 1; i < dim-1; i++) {
            suffissi = new ArrayList<>(mappa.get(testo.get(i-1)));
            testo.add(suffissi.get((int)(Math.random()* suffissi.size())));
        }
        return testo;
    }
}

