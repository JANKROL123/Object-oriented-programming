import java.time.LocalTime;
public final class Spotkanie extends Aktywnosc {
    private int priorytet;
    public Spotkanie(String opis, LocalTime czasPoczątku, LocalTime czasZakończenia, int priorytet)  {
        this.opis = opis;
        this.czasPoczątku = czasPoczątku;
        this.czasZakończenia = czasZakończenia;
        this.priorytet = priorytet;
    }
    public String toString() {
        String rozpoczecie = this.czasPoczątku.toString();
        String zakonczenie = this.czasZakończenia.toString();
        return String.format("Opis: %s, priorytet: %d, godz. rozpoczecia: %s, godz. zakonczenia: %s\n",
                this.opis, this.priorytet, rozpoczecie, zakonczenie);
    }
    public int getPriorytet() {
        return this.priorytet;
    }
}