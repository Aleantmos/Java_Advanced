import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class _5_AverageStudentsGrade {
    public static void main(String[] args) {
        //Todo: Redo
        Scanner scan = new Scanner(System.in);

        int lines = Integer.parseInt(scan.nextLine());

        Map<String, ArrayList<Double>> recordOfStudents = new TreeMap<>();
        Map<String, Double> averageGradeForStudent = new TreeMap<>();

        while (lines-- > 0) {
            String[] input = scan.nextLine().split("\\s+");

            String name = input[0];

            if(!recordOfStudents.containsKey(name)) {
                recordOfStudents.put(name, new ArrayList<>());
            }
            double grade = Double.parseDouble(input[1]);
            recordOfStudents.get(name).add(grade);

            double sum = 0;
            int cnt = 0;

            if(!averageGradeForStudent.containsKey(name)) {
                averageGradeForStudent.put(name, sum);
            }
            averageGradeForStudent.put(name,
                    (sum + grade));
        }

        recordOfStudents
                .forEach((k, v) -> {
                    double averageGrade = averageGradeForStudent.get(k);

                    System.out.println(k +
                            " -> " +
                            v.stream().map(
                                    x -> String.format("%.2f", x))
                            .collect(Collectors.joining(" ")) +
                            " (avg: " +
                            String.format("%.2f", averageGrade) +
                                    ")");
                });

    }
}
