import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean dzialaj = true;
        Scanner myString = new Scanner(System.in);
        Scanner czyDzialac = new Scanner(System.in);
        while (dzialaj) {
        System.out.println("Wpisz potęgę dwójki");
        int n = myString.nextInt();
        int p = oblicz(n);
        String a = String.format("Wartość 2^%d wynosi %d", n, p);
        System.out.println(a);

            System.out.println("Czy kontynuować program (tak/nie)");
            String status = czyDzialac.nextLine();
            if (status.equals("nie")) {
                dzialaj = false;
            }
            /*else if (status.equals("tak")) {
                System.out.println("Podaj wykładnik dla potęgi dwójki");
                int number = myString.nextInt();
                int power = oblicz(number);
                String answer = String.format("Wartość 2^%d wynosi %d", number, power);
                System.out.println(answer);
            } else {
                System.out.println("Zła opcja");
            }*/
        }
    }
    public static int oblicz(int n) {
        int result = 1;
        for (int i = n; i > 0; i--) {
            result *= 2;
        }
        return result;
    }
}