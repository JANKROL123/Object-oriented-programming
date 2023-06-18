package kalendarz.interfejs;

import java.time.LocalTime;
import java.util.Scanner;

import java.time.DateTimeException;
import java.lang.ArrayIndexOutOfBoundsException;

public class Pomocnicze {
    // Checked exception
    // vs
    // Unchecked exception
    public static LocalTime wczytajGodzinęZeScannera(final Scanner scanner) throws NiepoprawnyFormatGodzinyException {
        final String linia = scanner.nextLine();
        final String[] godzinaIMinuty = linia.split(":");
        if (godzinaIMinuty.length != 2) {
            throw new NiepoprawnyFormatGodzinyException();
        }
        try {
            final int godzina = Integer.parseInt(godzinaIMinuty[0]);
            final int minuty = Integer.parseInt(godzinaIMinuty[1]);
            return LocalTime.of(godzina, minuty, 0);
        } catch (NumberFormatException | DateTimeException e) {
            throw new NiepoprawnyFormatGodzinyException();
        }
    }
}