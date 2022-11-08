package AInformatica;

public class Banca {
    private final static int MAX_CONTI = 100;
    private final ContoCorrente[] conti;
    private int n_conti;

    public Banca(){
        conti = new ContoCorrente[MAX_CONTI];
        n_conti = 0;
    }

    public boolean creaConto(String nome, String cognome){
        ContoCorrente c = new ContoCorrente(n_conti + 1, nome, cognome);
        conti[n_conti] = c;
        n_conti++;
        return true;
    }

    public ContoCorrente[] ricercaPerCognome(String cognome) {
        int contatore = 0;
        for (int i = 0; i < n_conti; i++) {
            if (cognome.equals(conti[i].getCognome())) {
                contatore++;
            }
        }
        if (contatore == 0)
            return null;
        ContoCorrente[] contiCognome = new ContoCorrente[contatore];
        int j = 0;
        for (int i = 0; i < n_conti; i++) {
            if (cognome.equals(conti[i].getCognome())) {
                contiCognome[j++] = conti[i];
            }
        }
        return contiCognome;
    }

    public ContoCorrente ricercaPerId(int id){
        for (int i = 0; i < n_conti; i++) {
            if (id==conti[i].getNumeroConto())
                return conti[i];
        }
        return null;
    }

    public ContoCorrente[] getConti(){
        return conti;
    }
}