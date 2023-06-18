package kalendarz.kalendarz;

import kalendarz.aktywnosc.AktywnoscVisitor;
import kalendarz.aktywnosc.Spotkanie;
import kalendarz.aktywnosc.Zadanie;
import java.util.ArrayList;

public class AktywnoscFilterZadanieVisitor implements AktywnoscVisitor {
    private ArrayList<Zadanie> zadania;

    public AktywnoscFilterZadanieVisitor() {
        this.zadania = new ArrayList<Zadanie>();
    }

    public void visit(Zadanie zadanie) {
        zadania.add(zadanie);
    }

    public void visit(Spotkanie spotkanie) {
        // do nothing
    }

    public ArrayList<Zadanie> getZadania() {
        return this.zadania;
    }
}
