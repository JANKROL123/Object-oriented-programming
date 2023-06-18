import java.time.LocalTime;
public final class Zadanie extends Aktywnosc {
    private String status;
    public Zadanie(String opis, LocalTime czasPoczątku, LocalTime czasZakończenia, String status)  {
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
    public String getStatus() {
        return this.status;
    }
}
