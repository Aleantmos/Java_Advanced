import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dim = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int rows = dim[0];
        int cols = dim[1];

        int[][] matrix = new int[rows][cols];

        matrix = readMatrix(rows, cols, scan);

        int[] dataResult;
        dataResult = findMaxSum3x3(matrix);


        printResult(dataResult, matrix);

    }

    private static int[] findMaxSum3x3(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[rows - 1].length;

        int maxSum = Integer.MIN_VALUE;
        int bestStartingRow = -1;
        int bestStartingCol = -1;

        int[] resultData = new int[3];
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (sum > maxSum) {
                    bestStartingRow = row;
                    bestStartingCol = col;

                    maxSum = sum;
                    resultData[0] = sum;
                    resultData[1] = bestStartingRow;
                    resultData[2] = bestStartingCol;
                }
            }
        }
        return resultData;
    }


    private static void printResult(int[] data, int[][] matrix) {

        int maxSum = data[0];


        System.out.println("Sum = " + maxSum);
        int endRow = data[1] + 3;
        int endCol = data[2] + 3;

        for (int startRow = data[1]; startRow < endRow; startRow++) {
            for (int startCol = data[2]; startCol < endCol; startCol++) {
                System.out.print(matrix[startRow][startCol] + " ");
            }
            System.out.println();
        }

    }


    private static int[][] readMatrix(int rows, int cols, Scanner scan) {

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();
            matrix[row] = arr;
        }
        return matrix;
    }
}
