public class ContoCorrente {
    private final String nome;
    private final String cognome;
    private float saldo;
    public ContoCorrente(String nome, String cognome) {
        this.nome= nome;
        this.cognome= cognome;
        this.saldo= 0;
    }

    public float getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "nome: " + nome + " cognome: " + cognome + " saldo: " + saldo;
    }

    public float preleva(float prelievo){
        this.saldo-= prelievo;
        return this.saldo;
    }

    public float deposita(float deposito){
        this.saldo+= deposito;
        return this.saldo;
    }
}
