import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pr05AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        TreeMap<String,Double> students = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] grades = scanner.nextLine().split(" ");
            double averageGrade = calcAverage(grades);
            students.put(name, averageGrade);
        }

        for (Map.Entry<String,Double> entry: students.entrySet()){
            System.out.printf("%s is graduated with %s%n", entry.getKey(), entry.getValue());
        }
    }

    private static double calcAverage(String[] grades) {
        double avg = 0;
        for (int i = 0; i < grades.length; i++) {
            avg += Double.parseDouble(grades[i]);
        }
        return avg/grades.length;
    }
}
