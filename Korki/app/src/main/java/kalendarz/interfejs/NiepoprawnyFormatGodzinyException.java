package kalendarz.interfejs;

public class NiepoprawnyFormatGodzinyException extends Exception {
    public NiepoprawnyFormatGodzinyException() {
        super("Niepoprawny format godziny");
    }
}