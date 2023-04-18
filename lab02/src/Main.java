import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean dzialaj = true;
        String status;
        Scanner mojScanner = new Scanner(System.in);
        Scanner czyDzialac = new Scanner(System.in);
        Walec cylinder = stworzWalec(mojScanner);
        while (dzialaj) {
            wyswietlMenu();
            status = czyDzialac.nextLine();
            switch (status) {
                case "a":
                    wyswietlWartosci(cylinder);
                    break;
                case "b":
                    ustawNoweWartosci(mojScanner, cylinder);
                    break;
                case "c":
                    wyswietlPoleObjetosc(cylinder);
                    break;
                case "d":
                    dzialaj = false;
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja");
            }
        }
    }
    private static Walec stworzWalec(Scanner mojScanner) {
        System.out.println("Ten program służy do wykonywania operacji na walcu takich jak obliczanie pól i objętości");
        System.out.println("Ustaw wysokosc:");
        double h = mojScanner.nextDouble();
        System.out.println("Ustaw promien:");
        double r = mojScanner.nextDouble();
        Walec nowyCylinder = new Walec(h, r);
        return nowyCylinder;
    }

    private static void wyswietlMenu() {
        System.out.println("Wybierz opcję:");
        System.out.println("a) Wyświetl wartości zmiennych instancji obiektu klasy Walec");
        System.out.println("b) Zmień wartości zmiennych instancji obiektu klasy Walec");
        System.out.println("c) Wylicz i wyświetl w konsoli pole powierzchni i objętość klasy Walec");
        System.out.println("d) Wyjdź z programu");
    }
    private static void wyswietlWartosci(Walec cylinder) {
        System.out.println("Promien podstawy walca wynosi " + cylinder.zwrocPromien());
        System.out.println("Wysokosc walca wynosi " + cylinder.zwrocWysokosc());
    }
    private static void ustawNoweWartosci(Scanner mojScanner, Walec cylinder) {
        System.out.println("Ustaw nową wysokosc:");
        double h = mojScanner.nextDouble();
        System.out.println("Ustaw nowy promien:");
        double r = mojScanner.nextDouble();
        cylinder.ustawWysokosc(h);
        cylinder.ustawPromien(r);
        System.out.println("Promien podstawy walca wynosi " + cylinder.zwrocPromien());
        System.out.println("Wysokosc walca wynosi " + cylinder.zwrocWysokosc());
    }
    private static void wyswietlPoleObjetosc(Walec cylinder) {
        System.out.println("Pole powierzchni walca wynosi " + cylinder.obliczPolePowierzchniCalkowitej());
        System.out.println("Objętość walca wynosi " + cylinder.obliczObjetosc());
    }

}