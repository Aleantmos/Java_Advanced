import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dim = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        List<List<Integer>> matrix = createMatrix(dim);

        String command;

        while (!"Nuke it from orbit".equals(command = scan.nextLine())) {
            String[] attribute = command.split("\\s+");

            int row = Integer.parseInt(attribute[0]);
            int col = Integer.parseInt(attribute[1]);
            int radius = Integer.parseInt(attribute[2]);

            for (int i = Math.max(0, row - radius); i <= Math.min(matrix.size() - 1, row + radius); i++) {
                if (i != row && col >= 0 && matrix.get(i).size() > col) {
                    matrix.get(i).remove(col);
                }
                if(i == row) {
                    for (int j = Math.min(matrix.get(i).size() - 1, col + radius); j >= Math.max(0, col - radius); j--) {
                        matrix.get(i).remove(j);
                    }
                }
            }
            matrix.removeIf(List::isEmpty);
        }
        matrix.forEach(s -> System.out.println(s.toString().replaceAll("[\\[\\],],", "")));
    }

    private static List<List<Integer>> createMatrix(int[] dim) {

        int cnt = 1;

        int rows = dim[0];
        int cols = dim[1];

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(cnt);
                cnt++;
            }
            matrix.add(row);
        }
        return matrix;
    }
}
