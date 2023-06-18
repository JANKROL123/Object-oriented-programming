package kalendarz.aktywnosc;

public interface AktywnoscVisitor {
    void visit(Spotkanie spotkanie);

    void visit(Zadanie zadanie);
}