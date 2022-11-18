public class Sveglia {
    private int ore, minuti,oreSveglia, minutiSveglia;
    private int modalita;

    public Sveglia() {
        this.ore = 0;
        this.minuti = 0;
        this.oreSveglia = 0;
        this.minutiSveglia = 0;
    }

    public Sveglia(int ore, int minuti) {
        this.ore = ore;
        this.minuti = minuti;
    }

    public void impostaOrario(){
        if (modalita==2)
            return;
        else
            modalita=2;
    }

    public void impostaSveglia(){
        if (modalita==3)
            return;
        else
            modalita=3;
    }

    public void setOre(){
        if (modalita==2)
            ore++;
        else if (modalita==3)
            oreSveglia++;
        ore %= 24;
        oreSveglia%=24;
    }

    public void setMinuti(){
        if (modalita==2)
            minuti++;
        else if (modalita==3)
            minutiSveglia++;
        minuti %= 60;
        minutiSveglia %= 60;
    }

    public int setModalita(int modalita) {
        this.modalita = modalita;
        return modalita;
    }

    public String toString(){
        String risultato;
        risultato = "Modalità";
        if (modalita==2) {
            risultato += " regolazione orario";
            risultato += "\nOrario: " + (ore < 10 ? "0" + ore : ore);
            risultato += ":" + (minuti < 10 ? "0" + minuti : minuti);
        }
        else if(modalita==3) {
            risultato += " regolazione sveglia";
            risultato += "\nSveglia: " + (oreSveglia < 10 ? "0" + oreSveglia : oreSveglia);
            risultato += ":" + (minutiSveglia < 10 ? "0" + minutiSveglia : minutiSveglia);
        }
        else {
            risultato += " normale";
            risultato += "\nOrario: " + (ore < 10 ? "0" + ore : ore);
            risultato += ":" + (minuti < 10 ? "0" + minuti : minuti);
            risultato += "\nSveglia: " + (oreSveglia < 10 ? "0" + oreSveglia : oreSveglia);
            risultato += ":" + (minutiSveglia < 10 ? "0" + minutiSveglia : minutiSveglia);
        }
        return risultato;
    }
}
