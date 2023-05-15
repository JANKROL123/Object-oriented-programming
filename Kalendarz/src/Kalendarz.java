import java.util.ArrayList;
import java.util.function.Predicate;
public class Kalendarz {
    private ArrayList<ArrayList<Spotkanie>> dniTygodnia;
    public Kalendarz() {
         this.dniTygodnia = new ArrayList<ArrayList<Spotkanie>>();
    }
    public void dodajSpotkanie(int dzien, Spotkanie spotkanie) {
        ArrayList<Spotkanie> dzienTygodnia = this.dniTygodnia.get(dzien);
        dzienTygodnia.add(spotkanie);
    }
    public void usunSpotkanie(int dzien, int numerSpotkania) {
        ArrayList<Spotkanie> dzienTygodnia = this.dniTygodnia.get(dzien);
        dzienTygodnia.remove(numerSpotkania);
    }
    public ArrayList<Spotkanie> pobierzSpotkaniaZPredykatem(int dzien, Predicate<Spotkanie> pred) {
        ArrayList<Spotkanie> result = new ArrayList<Spotkanie>();
        ArrayList<Spotkanie> dzienTygodnia = this.dniTygodnia.get(dzien);
        for (Spotkanie spotkanie : dzienTygodnia) {
            if (pred.test(spotkanie)) {
                result.add(spotkanie);
            }
        }
        return result;
    }
    public int iloscSpotkan(int dzien) {
        ArrayList<Spotkanie> dzienTygodnia = this.dniTygodnia.get(dzien);
        return dzienTygodnia.size();
    }
    public void setSpotkania(int liczbaDni) {
        for (int i = 0; i < liczbaDni; i++) {
            this.dniTygodnia.add(new ArrayList<Spotkanie>());
        }
    }
    public ArrayList<ArrayList<Spotkanie>> getSpotkania() {
        return this.dniTygodnia;
    }
    public int getDlugoscTygodnia() {
        return this.dniTygodnia.size();
    }
}