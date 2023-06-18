package kalendarz.interfejs;

import java.util.Scanner;
import kalendarz.kalendarz.Kalendarz;
import java.time.LocalTime;
import kalendarz.aktywnosc.Aktywnosc;
import kalendarz.aktywnosc.Spotkanie;
import kalendarz.aktywnosc.Zadanie;
import kalendarz.aktywnosc.Priorytet;
import kalendarz.aktywnosc.Status;
import java.util.List;

public class Interfejs {
    final Scanner scanner;

    public Interfejs(final Scanner scanner) {
        this.scanner = scanner;
    }

    public int zapytajOLiczbęDni() {
        System.out.println("Podaj liczbę dni");
        return this.scanner.nextInt();
    }

    public int pobierzDzien(final int liczbaDni) {
        while (true) {
            System.out.println("Podaj dzień");
            final int dzień = this.scanner.nextInt();
            if (dzień >= 1 && dzień <= liczbaDni) {
                return dzień;
            }
            System.out.println("Nieprawidłowy dzień");
        }
    }

    public LocalTime pobierzGodzinęRozpoczęcia(final LocalTime najwcześniejszaMożliwaGodzinaRozpoczęcia) {
        while (true) {
            System.out.println("Podaj godzinę rozpoczęcia w formacie HH:MM");
            try {
                final LocalTime wczytanaGodzina = Pomocnicze.wczytajGodzinęZeScannera(this.scanner);
                if (wczytanaGodzina.isBefore(najwcześniejszaMożliwaGodzinaRozpoczęcia)) {
                    System.out.println("Godzina rozpoczęcia nie może być wcześniejsza niż "
                            + najwcześniejszaMożliwaGodzinaRozpoczęcia);
                    continue;
                }
                return wczytanaGodzina;
            } catch (final NiepoprawnyFormatGodzinyException e) {
                System.out.println("Nieprawidłowa godzina");
            }

        }
    }

    public LocalTime pobierzGodzinęZakończenia(final LocalTime godzinaRozpoczęcia) {
        while (true) {
            System.out.println("Podaj godzinę zakończenia w formacie HH:MM");
            try {
                final LocalTime wczytanaGodzina = Pomocnicze.wczytajGodzinęZeScannera(this.scanner);
                if (wczytanaGodzina.isBefore(godzinaRozpoczęcia)) {
                    System.out.println("Godzina zakończenia nie może być wcześniejsza niż " + godzinaRozpoczęcia);
                    continue;
                }
                return wczytanaGodzina;
            } catch (final NiepoprawnyFormatGodzinyException e) {
                System.out.println("Nieprawidłowa godzina");
            }

        }
    }

    public String pobierzOpis() {
        System.out.println("Podaj opis");
        return this.scanner.nextLine();
    }

    // public enum Priorytet {
    // NIEWAZNY, ZWYKLY, WAZNY
    // }

    public Priorytet pobierzPriorytet() {
        while (true) {
            System.out.println("Podaj priorytet");
            System.out.println("1 - nieważny");
            System.out.println("2 - zwykły");
            System.out.println("3 - ważny");
            final int priorytet = this.scanner.nextInt();
            switch (priorytet) {
                case 1:
                    return Priorytet.NIEWAZNY;
                case 2:
                    return Priorytet.ZWYKLY;
                case 3:
                    return Priorytet.WAZNY;
                default:
                    System.out.println("Nieprawidłowy priorytet");
            }
        }
    }

    public Status pobierzStatus() {
        while (true) {
            System.out.println("Podaj status");
            System.out.println("1 - nieważny");
            System.out.println("2 - zwykły");
            System.out.println("3 - ważny");
            final int status = this.scanner.nextInt();
            switch (status) {
                case 1:
                    return Status.NIEWAZNY;
                case 2:
                    return Status.ZWYKLY;
                case 3:
                    return Status.WAZNY;
                default:
                    System.out.println("Nieprawidłowy status");
            }
        }
    }

    public Spotkanie wczytajSpotkanieDoDodania() {
        final LocalTime godzinaRozpoczęcia = pobierzGodzinęRozpoczęcia(Aktywnosc.NAJWCZESNIEJSZA);
        final LocalTime godzinaZakończenia = pobierzGodzinęZakończenia(godzinaRozpoczęcia);

        final String opis = pobierzOpis();
        final Priorytet priorytet = pobierzPriorytet();

        final Spotkanie spotkanie = new Spotkanie(opis, godzinaRozpoczęcia, godzinaZakończenia, priorytet);
        return spotkanie;

    }

    public Zadanie wczytajZadanieDoDodania() {
        final LocalTime godzinaRozpoczęcia = pobierzGodzinęRozpoczęcia(Aktywnosc.NAJWCZESNIEJSZA);
        final LocalTime godzinaZakończenia = pobierzGodzinęZakończenia(godzinaRozpoczęcia);

        final String opis = pobierzOpis();
        final Status status = pobierzStatus();

        final Zadanie zadanie = new Zadanie(opis, godzinaRozpoczęcia, godzinaZakończenia, status);
        return zadanie;

    }

    public void wyświetlDodawanieSpotkania(final Kalendarz kalendarz) {
        final int dzień = pobierzDzien(kalendarz.getLiczbaDni());

        final Spotkanie spotkanie = wczytajSpotkanieDoDodania();
        kalendarz.dodajAktywnosc(dzień, spotkanie);
    }

    public void wyświetlDodawanieZadania(final Kalendarz kalendarz) {
        final int dzień = pobierzDzien(kalendarz.getLiczbaDni());

        final Zadanie zadanie = wczytajZadanieDoDodania();
        kalendarz.dodajAktywnosc(dzień, zadanie);
    }

    public void wyświetlListęZadań(final Kalendarz kalendarz) {
        final int dzień = pobierzDzien(kalendarz.getLiczbaDni());
        final List<Zadanie> zadania = kalendarz.pobierzZadania(dzień);
        // iterate over list getting indexes and values
        for (int i = 0; i < zadania.size(); i++) {
            System.out.println((i + 1) + ". " + zadania.get(i).toString());
        }

    }

    public void wyświetlMenu(final Kalendarz kalendarz) {
        System.out.println("Co chcesz zrobić?");
        System.out.println("1. Dodaj zadanie");
        System.out.println("2. Dodaj spotkanie");
        // 3 - usuniecie spotkanie
        // 4 - usuniecie zadania
        // w 3 i 4 najpierw wyświetlListęZadań/ spotkań a potem zapytaj o numer
        // i usuń korzystając z metody w kalendarzu
        // 5 - implementacja analogiczna do 6

        System.out.println("6. Wyświetl listę zadań");
        final int wybór = this.scanner.nextInt();
        switch (wybór) {
            case 1:
                wyświetlDodawanieZadania(kalendarz);
                break;
            case 2:
                wyświetlDodawanieSpotkania(kalendarz);
                break;
            case 6:
                wyświetlListęZadań(kalendarz);
                break;
            default:
                System.out.println("Nieprawidłowy wybór");
        }
    }

    public void start() {
        final int liczbaDni = zapytajOLiczbęDni();
        final Kalendarz kalendarz = new Kalendarz(liczbaDni);
        while (true) {
            wyświetlMenu(kalendarz);
        }
    }

}