
package kalendarz;

import kalendarz.interfejs.Interfejs;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final Interfejs interfejs = new Interfejs(new Scanner(System.in));
        interfejs.start();
    }
}
