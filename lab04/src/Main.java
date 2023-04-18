import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean go = true;
        String status;
        Scanner myScanner = new Scanner(System.in);
        Scanner shouldGo = new Scanner(System.in);
        GradeList gradeList = new GradeList(new ArrayList<Double>());
        System.out.println("In this program you can handle student's grades:");
        while (go) {
            displayMenu();
            status = shouldGo.nextLine();
            switch (status) {
                case "a":
                    addNewGrade(myScanner, gradeList);
                    break;
                case "b":
                    getAvg(gradeList);
                    break;
                case "c":
                    getMax(gradeList);
                    break;
                case "d":
                    getMin(gradeList);
                    break;
                case "x":
                    go = false;
                    break;
                default:
                    System.out.println("Incorrect option");
            }
        }
    }
    private static void displayMenu() {
        System.out.println("Choose an option:");
        System.out.println("a) Add new grade");
        System.out.println("b) Get avarage grade");
        System.out.println("c) Get the highest grade");
        System.out.println("d) Get the lowest grade");
        System.out.println("x) Exit");
    }
    private static void addNewGrade(Scanner myScanner, GradeList gradeList) {
        System.out.println("Add new grade:");
        double newGrade = myScanner.nextDouble();
        String answer = gradeList.addNewGrade(newGrade);
        System.out.println(answer);
    }
    private static void getAvg(GradeList gradeList) {
        double answer = gradeList.getAvg();
        if (answer == 0) {
            System.out.println("No grades");
        } else {
            System.out.println("Average grade is: "+answer);
        }
    }
    private static void getMax(GradeList gradeList) {
        double answer = gradeList.getMax();
        if (answer == 0) {
            System.out.println("No grades");
        } else {
            System.out.println("The highest grade is: "+answer);
        }
    }
    private static void getMin(GradeList gradeList) {
        double answer = gradeList.getMin();
        if (answer == 0) {
            System.out.println("No grades");
        } else {
            System.out.println("The lowest grade is: "+answer);
        }
    }
}