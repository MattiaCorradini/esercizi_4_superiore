package AInformatica;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Movimento {

    private String descrizione;
    private float importo;
    private LocalDateTime data;

    public Movimento(String descrizione, float importo){
        this.descrizione = descrizione;
        this.importo = importo;
        this.data = LocalDateTime.now();
    }

    private String FormattaData(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd - HH:mm:ss", Locale.ITALY)
                .withZone(ZoneId.of("Europe/Rome"));
        String text = data.format(formatter);
        return text;
    }

    @Override
    public String toString() {
        return "-descrizione: " + descrizione + ", importo: " + importo + "€" + ", data= " + FormattaData();
    }
}