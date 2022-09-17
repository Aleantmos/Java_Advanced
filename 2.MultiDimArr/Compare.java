import java.util.Arrays;
import java.util.Scanner;

public class Compare {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scan);
        int[][] secondMatrix = readMatrix(scan);

        boolean areEqual = compareMatrices(firstMatrix, secondMatrix);


        String output = areEqual ? "equal" : "not equal";
        System.out.println(output);


        //printMatrix(firstMatrix);
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {

        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArr = firstMatrix[row];
            int[] secondArr = secondMatrix[row];

            if (firstArr.length != secondArr.length) {
                return false;
            }

            for (int col = 0; col < firstArr.length; col++) {
                int firstEl = firstArr[col];
                int secondEl = secondArr[col];

                if(firstEl != secondEl) {
                    return false;
                }
            }
        }


        return true;
    }

    private static int[][] readMatrix(Scanner scan) {
        String[] input = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];


        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = matrix[row];
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
