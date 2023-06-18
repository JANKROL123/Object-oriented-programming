import java.time.LocalTime;
public sealed abstract class Aktywnosc permits Spotkanie, Zadanie {
    protected static final LocalTime NAJWCZESNIEJSZA = LocalTime.of(9,15,0);
    protected String opis;
    protected LocalTime czasPoczątku;
    protected LocalTime czasZakończenia;
    public static LocalTime getNajwczesniejsza() {
        return NAJWCZESNIEJSZA;
    }
    public String getOpis() {
        return this.opis;
    }
    public LocalTime getCzasPoczątku() {
        return this.czasPoczątku;
    }
    public LocalTime getCzasZakończenia() {
        return this.czasZakończenia;
    }
}