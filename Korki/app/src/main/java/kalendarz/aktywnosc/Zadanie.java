package kalendarz.aktywnosc;

import java.time.LocalTime;

public final class Zadanie extends Aktywnosc {
    private final Status status;

    public Zadanie(final String opis, final LocalTime czasPoczątku, final LocalTime czasZakończenia,
            final Status status) {
        super(opis, czasPoczątku, czasZakończenia);
        this.status = status;
    }

    public String toString() {
        final String rozpoczecie = this.czasPoczątku.toString();
        final String zakonczenie = this.czasZakończenia.toString();
        return String.format("Opis: %s, status: %s, godz. rozpoczecia: %s, godz. zakonczenia: %s\n",
                this.opis, this.status, rozpoczecie, zakonczenie);
    }

    public Status getStatus() {
        return this.status;
    }

    public void accept(final AktywnoscVisitor visitor) {
        visitor.visit(this);
    }
}