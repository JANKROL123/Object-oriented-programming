import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;
import java.util.function.Predicate;
public class Main {
    public static void main(String[] args) {
        boolean dzialaj = true;
        Scanner mojSkaner = new Scanner(System.in);
        Scanner czyDzialac = new Scanner(System.in);
        System.out.println("Program będzie obsługiwał kalendarz tygodniowy spotkań.");
        System.out.println("Podaj liczbę dni:");
        int liczbaDni = mojSkaner.nextInt();
        Kalendarz kalendarz = new Kalendarz();
        kalendarz.setAktywnosci(liczbaDni);
        System.out.println("Utworzono kalendarz");
        wyswietlOpcje(dzialaj, mojSkaner, czyDzialac, kalendarz);
    }
    private static void wyswietlOpcje(boolean dzialaj, Scanner mojSkaner, Scanner czyDzialac, Kalendarz kalendarz) {
        while (dzialaj) {
            wyswietlMenuGlowne();
            String status = czyDzialac.nextLine();
            switch (status) {
                case "a" -> dodajAktywnosc(mojSkaner, kalendarz);
                case "x" -> dzialaj = false;
                default -> System.out.println("Nieobsługiwana opcja");
            }
        }
    }
    private static void dodajAktywnosc(Scanner mojSkaner, Kalendarz kalendarz) {
        int dzien = stworzDzien(mojSkaner);
        LocalTime godzinaRozpoczecia = stworzGodzine(mojSkaner, true);
        LocalTime godzinaZakonczenia = stworzGodzine(mojSkaner, false);
        String opis = stworzOpis();
        System.out.println("Podaj rodzaj aktywnosci: zadanie/spotkanie");
        String opcjaAktywnosci = stworzOpcjeAktywnosci();
        if (opcjaAktywnosci.equals("spotkanie")) {
            dodajSpotkanie(mojSkaner, kalendarz, dzien, godzinaRozpoczecia, godzinaZakonczenia, opis);
        } else if (opcjaAktywnosci.equals("zadanie")) {
            dodajZadanie(mojSkaner, kalendarz, dzien, godzinaRozpoczecia, godzinaZakonczenia, opis);
        } else {
            System.out.println("Nie");
        }
    }
    private static String stworzOpcjeAktywnosci() {
        Scanner skaner = new Scanner(System.in);
        String opcja = skaner.next();
        return opcja;
    }
    private static void dodajSpotkanie(Scanner mojSkaner, Kalendarz kalendarz, int dzien, LocalTime godzinaRozpoczecia, LocalTime godzinaZakonczenia, String opis) {
        int priorytet = stworzPriorytetStatus(mojSkaner, true);
        Spotkanie noweSpotkanie = new Spotkanie(opis, godzinaRozpoczecia, godzinaZakonczenia, priorytet);
        kalendarz.dodajAktywnosc(dzien, noweSpotkanie);
        System.out.println("Dodano spotkanie");
    }
    private static void dodajZadanie(Scanner mojSkaner, Kalendarz kalendarz, int dzien, LocalTime godzinaRozpoczecia, LocalTime godzinaZakonczenia, String opis) {
        int status = stworzPriorytetStatus(mojSkaner, false);
        Zadanie noweZadanie = new Zadanie(opis, godzinaRozpoczecia, godzinaZakonczenia, status);
        kalendarz.dodajAktywnosc(dzien, noweZadanie);
        System.out.println("Dodano zadanie");
    }
    private static LocalTime stworzGodzine(Scanner mojSkaner, boolean start) {
        String informacjaKonsolowa = start ? "Podaj godzine rozpoczecia HH:MM" : "Podaj godzine zakonczenia HH:MM";
        System.out.println(informacjaKonsolowa);
        String rozpoczecie  = mojSkaner.next();
        String[] hhMM = rozpoczecie.split(":");
        LocalTime godzina = LocalTime.of(Integer.parseInt(hhMM[0]), Integer.parseInt(hhMM[1]), 0);
        return godzina;
    }
    private static String stworzOpis() {
        System.out.println("Podaj opis aktywnosci");
        Scanner skanerOpisu = new Scanner(System.in);
        String opis  = skanerOpisu.nextLine();
        return opis;
    }
    private static int stworzDzien(Scanner mojSkaner) {
        System.out.println("Podaj dzien tygodnia:");
        int dzien = mojSkaner.nextInt();
        return dzien-1;
    }
    private static int stworzPriorytetStatus(Scanner mojSkaner, boolean czySpotkanie) {
        String informacjaKonsolowa = czySpotkanie ? "Podaj priorytet: [1-niski, 2-sredni, 3-wysoki]" : "Podaj status: [1-planowane, 2-potwierdzone, 3-realizowane, 4-wykonane]";
        int statusPriorytet = mojSkaner.nextInt();
        return statusPriorytet;
    }
    private static void wyswietlMenuGlowne() {
        System.out.println("Wybierz opcje:");
        System.out.println("a) Dodaj aktywnosc");
        System.out.println("x) Exit");
    }
}