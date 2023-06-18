import java.util.ArrayList;
import java.util.function.Predicate;
public class Kalendarz {
    private ArrayList<ArrayList<Aktywnosc>> dniTygodnia;
    public Kalendarz() {
        this.dniTygodnia = new ArrayList<ArrayList<Aktywnosc>>();
    }
    public void setAktywnosci(int liczbaDni) {
        for (int i = 0; i < liczbaDni; i++) {
            this.dniTygodnia.add(new ArrayList<Aktywnosc>());
        }
    }
    public void dodajAktywnosc(int dzien, Aktywnosc aktywnosc) {
        ArrayList<Aktywnosc> dzienTygodnia = this.dniTygodnia.get(dzien);
        dzienTygodnia.add(aktywnosc);
    }
    public void test() {
        System.out.println(this.dniTygodnia);
    }
}
