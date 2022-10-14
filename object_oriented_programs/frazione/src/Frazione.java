public class Frazione {
    private int numeratore; //private indica uno scopo di visibilità (nasconde al suo interno cosa c'è)
    private int denominatore;

    public  Frazione(int numeratore, int denominatore){
        this.numeratore = numeratore;
        this.denominatore = denominatore;
        if (this.denominatore==0)
            this.denominatore=1;
    }

    public Frazione(String s){
        this.numeratore=this.denominatore=1;
    }

    public Frazione somma(Frazione frazione){
        return null;
    }

}
