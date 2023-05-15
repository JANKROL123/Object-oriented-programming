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
        kalendarz.setSpotkania(liczbaDni);
        System.out.println("Utworzono kalendarz");
        wyswietlOpcje(dzialaj, mojSkaner, czyDzialac, kalendarz);
    }
    private static void wyswietlOpcje(boolean dzialaj, Scanner mojSkaner, Scanner czyDzialac, Kalendarz kalendarz) {
        while (dzialaj) {
            wyswietlMenu();
            String status = czyDzialac.nextLine();
            switch (status) {
                case "a" -> dodajSpotkanie(mojSkaner, kalendarz);
                case "b" -> usunSpotkanie(mojSkaner, kalendarz);
                case "c" -> wyswietlSpotkania(mojSkaner, kalendarz);
                case "d" -> testZadanie();
                case "x" -> dzialaj = false;
                default -> System.out.println("Nieobsługiwana opcja");
            }
        }
    }
    private static void testZadanie() {
        LocalTime najwczesniejsza = Zadanie.getNajwczesniejsza();
        LocalTime start = LocalTime.of(12,0,0);
        LocalTime stop = LocalTime.of(12,30,0);
        boolean bladGodzin = zwrocBladGodzin(start, stop, najwczesniejsza);
        if (bladGodzin) {
            System.out.println("Nieprawidłowo wypełnione dane");
            return;
        }
        Zadanie zadanie = new Zadanie("zadanie1", start, stop, "normalny");
        String drukuj = zadanie.toString();
        System.out.println(zadanie);
    }
    private static void wyswietlSpotkania(Scanner mojSkaner, Kalendarz kalendarz) {
        int dzien = zwrocDzien(mojSkaner);
        wyswietlPredykaty();
        String opcja = pobierzOpcje();
        Predicate<Spotkanie> pred = utworzPredykat(mojSkaner, opcja);
        ArrayList<Spotkanie> spotkania = kalendarz.pobierzSpotkaniaZPredykatem(dzien, pred);
        for (Spotkanie spotkanie : spotkania) {
            String result = spotkanie.toString();
            System.out.println(result);
        }
    }
    private static Predicate<Spotkanie> utworzPredykat(Scanner mojSkaner, String opcja) {
        Predicate<Spotkanie> pred;
        int priorytet;
        LocalTime start;
        switch (opcja) {
            case "a" -> pred = (i) -> true;
            case "b" -> pred = (i) -> i.getPriorytet() == zwrocPriorytet(mojSkaner);
            case "c" -> pred = (i) -> i.getCzasPoczątku().compareTo(zwrocGodzine(mojSkaner)) >= 0;
            case "d" -> pred = (i) -> i.getCzasPoczątku().compareTo(zwrocGodzine(mojSkaner)) >= 0 && zwrocGodzine(mojSkaner).compareTo(i.getCzasZakończenia()) >= 0;
            case "e" -> pred = (i) -> i.getPriorytet() == zwrocPriorytet(mojSkaner) && i.getCzasPoczątku().compareTo(zwrocGodzine(mojSkaner)) >= 0;
            default -> pred = (i) -> true;
        }
        return pred;
    }
    private static String pobierzOpcje() {
        Scanner skanerOpcji = new Scanner(System.in);
        String opcja = skanerOpcji.nextLine();
        return opcja;
    }

    private static void wyswietlPredykaty() {
        System.out.println("Wybierz predykat:");
        System.out.println("a) Wszystkie spotkania w wybranym dniu");
        System.out.println("b) Wszystkie spotkania w wybranym dniu o wybranym priorytecie");
        System.out.println("c) Wszystkie spotkania w wybranym dniu od podanego czasu");
        System.out.println("d) Wyświetl spotkania w wybranym dniu pomiędzy podanymi czasami");
        System.out.println("e) Wszystkie spotkania w wybranym dniu od podanego czasu i zadanym priorytecie");
    }
    private static void wyswietlMenu() {
        System.out.println("Wybierz opcje:");
        System.out.println("a) Dodaj spotkanie");
        System.out.println("b) Usun spotaknie");
        System.out.println("c) Wyświetl spotkania według predykatu");
        System.out.println("d) Test zadanie");
        System.out.println("x) Exit");
    }
    private static void dodajSpotkanie(Scanner mojSkaner, Kalendarz kalendarz) {
        int dzien = zwrocDzien(mojSkaner);
        boolean bladDnia = zwrocBladDnia(dzien, kalendarz);
        LocalTime godzinaRozpoczecia = zwrocGodzine(mojSkaner);
        LocalTime najwczesniejsza = Spotkanie.getNajwczesniejsza();
        LocalTime godzinaZakonczenia = zwrocGodzine(mojSkaner);
        boolean bladGodzin = zwrocBladGodzin(godzinaRozpoczecia, godzinaZakonczenia, najwczesniejsza);
        String opis  = zwrocOpis();
        int priorytet = zwrocPriorytet(mojSkaner);
        boolean bladPriorytetu = zwrocBladPriorytetu(priorytet);
        if (bladDnia || bladGodzin || bladPriorytetu) {
            System.out.println("Nieprawidłowo wypełnione dane");
            return;
        }
        Spotkanie noweSpotkanie = new Spotkanie(opis, godzinaRozpoczecia, godzinaZakonczenia, priorytet);
        kalendarz.dodajSpotkanie(dzien, noweSpotkanie);
        System.out.println("Dodano spotkanie");
    }
    private static void usunSpotkanie(Scanner mojSkaner, Kalendarz kalendarz) {
        int dzien = zwrocDzien(mojSkaner);
        boolean bladDnia = zwrocBladDnia(dzien, kalendarz);
        int liczbaSpotkan = kalendarz.iloscSpotkan(dzien);
        System.out.println("W tym dniu masz zaplanowanych: "+liczbaSpotkan+" spotkań. Które z kolei chcesz usunąć?");
        int spotkanieDoUsuniecia = zwrocSpotkaniaDoUsuniecia(mojSkaner);
        boolean bladSpotkania = zwrocBladSpotkania(spotkanieDoUsuniecia, liczbaSpotkan);
        if (bladDnia || bladSpotkania) {
            System.out.println("Nieprawidłowo wypełnione dane");
            return;
        }
        kalendarz.usunSpotkanie(dzien, spotkanieDoUsuniecia);
        System.out.println("Spotkanie usuniete");
    }
    private static LocalTime zwrocGodzine(Scanner mojSkaner) {
        System.out.println("Podaj godzine rozpoczecia HH:MM");
        String rozpoczecie  = mojSkaner.next();
        String[] hhMM = rozpoczecie.split(":");
        LocalTime godzina = LocalTime.of(Integer.parseInt(hhMM[0]), Integer.parseInt(hhMM[1]), 0);
        return godzina;
    }
    private static String zwrocOpis() {
        System.out.println("Podaj opis spotkania");
        Scanner skanerOpisu = new Scanner(System.in);
        String opis  = skanerOpisu.nextLine();
        return opis;
    }
    private static int zwrocPriorytet(Scanner mojSkaner) {
        System.out.println("Podaj priorytet spotkania: [1-niski, 2-średni, 3-wysoki]");
        int priorytet = mojSkaner.nextInt();
        return priorytet;
    }
    private static int zwrocDzien(Scanner mojSkaner) {
        System.out.println("Podaj dzien tygodnia:");
        int dzien = mojSkaner.nextInt();
        return dzien-1;
    }
    private static int zwrocSpotkaniaDoUsuniecia(Scanner mojSkaner) {
        int spotkanieDoUsuniecia = mojSkaner.nextInt();
        return spotkanieDoUsuniecia-1;
    }
    private static boolean zwrocBladGodzin(LocalTime godzinaRozpoczecia, LocalTime godzinaZakonczenia, LocalTime najwczesniejsza) {
        if ((godzinaRozpoczecia.compareTo(najwczesniejsza) == -1) || (godzinaZakonczenia.compareTo(godzinaRozpoczecia) == -1)) {
            return true;
        }
        return false;
    }
    private static boolean zwrocBladDnia(int dzien, Kalendarz kalendarz) {
        int dniTygodnia = kalendarz.getDlugoscTygodnia();
        if (dzien < 0 || dzien >= dniTygodnia) {
            return true;
        }
        return false;
    }
    private static boolean zwrocBladPriorytetu(int priorytet) {
        if (priorytet < 1 || priorytet > 3) {
            return true;
        }
        return false;
    }
    private static boolean zwrocBladSpotkania(int spotkanieDoUsuniecia, int liczbaSpotkan) {
        if (spotkanieDoUsuniecia < 0 || spotkanieDoUsuniecia >= liczbaSpotkan) {
            return true;
        }
        return false;
    }
}