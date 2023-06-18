import java.time.LocalTime;
public final class Zadanie extends Aktywnosc {
    private int status;
    public Zadanie(String opis, LocalTime czasPoczątku, LocalTime czasZakończenia, int status)  {
        this.opis = opis;
        this.czasPoczątku = czasPoczątku;
        this.czasZakończenia = czasZakończenia;
        this.status = status;
    }
    public String toString() {
        String rozpoczecie = this.czasPoczątku.toString();
        String zakonczenie = this.czasZakończenia.toString();
        return String.format("Opis: %s, status: %s, godz. rozpoczecia: %s, godz. zakonczenia: %s\n",
                this.opis, this.status, rozpoczecie, zakonczenie);
    }
    public int getStatus() {
        return this.status;
    }
}