import java.util.ArrayList;

public class GradeList {
    public ArrayList<Double> grades;
    public GradeList(ArrayList<Double> grades) {
        this.grades = grades;
    }
    public String addNewGrade(double newGrade) {
        if (newGrade > 0) {
            this.grades.add(newGrade);
            return "New grade added";
        } else {
            return "New grade cannot be less or equal than zero";
        }
    }
    public double getAvg() {
        int listSize = this.grades.size();
        if (listSize == 0) {
            return 0;
        }
        double sum = 0;
        for (double grade : this.grades) {
            sum += grade;
        }
        double result = sum / listSize;
        return result;
    }
    public double getMax() {
        double result = 0;
        for (double grade : this.grades) {
            if (result < grade) {
                result = grade;
            }
        }
        return result;
    }
    public double getMin() {
        double result = 0;
        for (double grade : this.grades) {
            if (result == 0  || result > grade) {
                result = grade;
            }
        }
        return result;
    }
}
