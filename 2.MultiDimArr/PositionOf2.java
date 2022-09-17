import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PositionOf2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] matrix = readMatrix(scan);

        int magicNum = Integer.parseInt(scan.nextLine());

        ArrayList<String> outputLines = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == magicNum) {
                    outputLines.add(row + " " + col);
                }
            }
        }

        if (outputLines.isEmpty()) {
            System.out.println("not found");
        } else {
            for (String outputLine : outputLines) {
                System.out.println(outputLine);
            }
        }

    }

    private static int[][] readMatrix(Scanner scan) {

        String[] dimensions = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }
        return matrix;
    }
}
