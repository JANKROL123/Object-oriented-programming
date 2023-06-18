package kalendarz.aktywnosc;

import java.time.LocalTime;

public final class Spotkanie extends Aktywnosc {
    private final Priorytet priorytet;

    public Spotkanie(final String opis, final LocalTime czasPoczątku, final LocalTime czasZakończenia,
            final Priorytet priorytet) {
        super(opis, czasPoczątku, czasZakończenia);
        this.priorytet = priorytet;
    }

    public String toString() {
        final String rozpoczecie = this.czasPoczątku.toString();
        final String zakonczenie = this.czasZakończenia.toString();
        return String.format("Opis: %s, priorytet: %d, godz. rozpoczecia: %s, godz. zakonczenia: %s\n",
                this.opis, this.priorytet, rozpoczecie, zakonczenie);
    }

    public Priorytet getPriorytet() {
        return this.priorytet;
    }

    public void accept(final AktywnoscVisitor visitor) {
        visitor.visit(this);
    }
}