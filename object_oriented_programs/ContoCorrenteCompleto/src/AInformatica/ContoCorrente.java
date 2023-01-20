package AInformatica;

import java.io.Serializable;

public class ContoCorrente implements Serializable {

    private int numeroConto;
    private String nome;
    private String cognome;
    private float saldo;
    private Movimento[] movimenti;
    private int n_movimenti;
    private static int MAX_MOVIMENTI = 100;

    public ContoCorrente(int numeroConto, String nome, String cognome) {
        this.numeroConto = numeroConto;
        this.nome = nome;
        this.cognome = cognome;
        this.saldo = 0;
        this.movimenti = new Movimento[MAX_MOVIMENTI];
        this.n_movimenti = 0;
    }

    public void preleva(float prelievo, String descrizione){
        movimenti[n_movimenti]= new Movimento(descrizione, -prelievo);
        saldo -= prelievo;
        n_movimenti++;
    }

    public void deposita(float deposito, String descrizione){
        movimenti[n_movimenti]= new Movimento(descrizione, deposito);
        saldo += deposito;
        n_movimenti++;
    }

    public Movimento[] numeroMovimenti(){
        return movimenti;
    }

    public String getCognome() {
        return cognome;
    }

    public float getSaldo() {
        return saldo;
    }

    public int getNumeroConto(){
        return numeroConto;
    }

    @Override
    public String toString() {
        return "-nome: " + nome + ", cognome: " + cognome + ", saldo: " + saldo + "€" + ", numero conto: " + numeroConto;
    }
}