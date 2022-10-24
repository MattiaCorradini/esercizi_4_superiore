public class Frazione {
    private int num;
    private int den;
    public Frazione(int num, int den){
        this.setNum(num);
        this.setDen(den);
    }
    public Frazione() {
        this.num=this.den=1;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public int getDen() {
        return den;
    }
    public void setDen(int den) {
        this.den = den;
        if (this.den==0)
            this.den=1;
    }
    @Override
    public String toString() {
        if (den==1)
            return Integer.toString(num);
        else
            return num + " / " + den;
    }
    public int mcd(int a, int b){
        if (b == 0)
            return a;
        return mcd(b, Math.abs(a - b));
    }
    private void semplifica(){
        boolean segno= num*den<0;
        num= Math.abs(num);
        den= Math.abs(den);
        int mcd = mcd(num,den);
        num /= mcd;
        den /= mcd;
        if (segno)
            num*= -1;
    }
    public Frazione somma(Frazione f){
        Frazione addizione= new Frazione();
        addizione.num= this.num*f.den + this.den*f.num;
        addizione.den= this.den*f.den;
        addizione.semplifica();
        return addizione;
    }
    public Frazione sottrazione(Frazione f){
        Frazione meno= new Frazione();
        meno.num= this.num*f.den - this.den*f.num;
        meno.den= this.den*f.den;
        meno.semplifica();
        return meno;
    }
    public Frazione moltiplicazione(Frazione f){
        Frazione x= new Frazione();
        x.num= this.num*f.num;
        x.den= this.den*f.den;
        x.semplifica();
        return x;
    }
    public Frazione divisione(Frazione f){
        Frazione div= new Frazione(f.den, f.num);
        return moltiplicazione(div);
    }
}
