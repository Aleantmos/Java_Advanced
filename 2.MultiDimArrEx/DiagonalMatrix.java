import java.util.Arrays;
import java.util.Scanner;

public class DiagonalMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int dim = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[dim][dim];

        matrix = readMatrix(matrix, scan, dim);

        int[] diagonal1 = new int[dim];
        diagonal1 = findDiag1(diagonal1, matrix);
        int[] diagonal2 = new int[dim];
        diagonal2 = findDiag2(diagonal2, matrix);

        int sum1 = calculateSum(diagonal1);
        int sum2 = calculateSum(diagonal2);

        int diff = calculateDiff(sum1, sum2);

        System.out.println(diff);
    }

    private static int calculateDiff(int sum1, int sum2) {
        int diff = Math.abs(sum1 - sum2);
        return diff;
    }

    public static int calculateSum(int[] nums){

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    private static int[] findDiag2(int[] diagonal2, int[][] matrix) {
        int rows = matrix.length;
        int cnt = matrix.length - 1;
        for (int row = 0; row < rows; row++) {
            diagonal2[row] = matrix[row][cnt];
            cnt--;
        }

        return diagonal2;
    }

    private static int[] findDiag1(int[] diagonal1, int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix.length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(row == col) {
                    diagonal1[row] = matrix[row][col];
                }
            }
        }
        return diagonal1;
    }

    public static int[][] readMatrix(int[][] matrix, Scanner scan, int dim) {

        int rows = dim;
        int cols = dim;

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();
            matrix[row] = arr;
        }

        return matrix;
    }
}
