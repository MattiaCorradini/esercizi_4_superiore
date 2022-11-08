package AInformatica;

import java.time.LocalDateTime;
public class Movimento {
    private final String descrizione;
    private final float importo;
    private final LocalDateTime data;

    public Movimento(String descrizione, float importo, LocalDateTime data) {
        this.descrizione = descrizione;
        this.importo = importo;
        this.data = data;
    }

    public Movimento(String descrizione, float importo){
        this.descrizione = descrizione;
        this.importo = importo;
        this.data = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "descrizione= " + descrizione + " importo= " + importo + " data= " + data;
    }
}