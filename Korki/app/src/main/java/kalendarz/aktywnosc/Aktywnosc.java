package kalendarz.aktywnosc;

import java.time.LocalTime;

public sealed abstract class Aktywnosc permits Spotkanie, Zadanie {
    public static final LocalTime NAJWCZESNIEJSZA = LocalTime.of(9, 15, 0);
    protected final String opis;
    protected final LocalTime czasPoczątku;
    protected final LocalTime czasZakończenia;

    protected Aktywnosc(final String opis, final LocalTime czasPoczątku, final LocalTime czasZakończenia) {
        // if (czasPoczątku.isAfter(czasZakończenia)) {
        // throw new IllegalArgumentException("czasPoczątku > czasZakończenia");
        // }
        this.opis = opis;
        this.czasPoczątku = czasPoczątku;
        this.czasZakończenia = czasZakończenia;

    }

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

    public abstract void accept(final AktywnoscVisitor visitor);
}
