package kalendarz.kalendarz;

import kalendarz.aktywnosc.Aktywnosc;

import java.util.ArrayList;
import java.util.function.Predicate;
import kalendarz.aktywnosc.Spotkanie;
import kalendarz.aktywnosc.Zadanie;
import java.util.List;

public class Kalendarz {
    private final ArrayList<ArrayList<Aktywnosc>> dniTygodnia;

    public int getLiczbaDni() {
        return this.dniTygodnia.size();
    }

    public Kalendarz(final int liczbaDni) {
        this.dniTygodnia = new ArrayList<ArrayList<Aktywnosc>>();
        for (int i = 0; i < liczbaDni; ++i) {
            this.dniTygodnia.add(new ArrayList<Aktywnosc>());
        }
        System.out.println(this.dniTygodnia.size());
    }

    // public void dodajAktywnosc(final int dzien, final Aktywnosc aktywnosc) {
    // this.dniTygodnia.get(dzien).add(aktywnosc);
    // }

    public void dodajAktywnosc(final int dzien, final Spotkanie spotkanie) {
        this.dniTygodnia.get(dzien - 1).add(spotkanie);
    }

    public void dodajAktywnosc(final int dzien, final Zadanie zadanie) {
        this.dniTygodnia.get(dzien - 1).add(zadanie);
    }

    public List<Zadanie> pobierzZadania(final int dzien) {
        final AktywnoscFilterZadanieVisitor visitor = new AktywnoscFilterZadanieVisitor();
        this.dniTygodnia.get(dzien - 1).forEach(aktywnosc -> aktywnosc.accept(visitor));
        return visitor.getZadania();
    }
}
