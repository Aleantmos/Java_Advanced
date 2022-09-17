import java.util.Arrays;
import java.util.Scanner;
//Todo: 80/100?
public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] matrixSize = readArrInt(scan);
        int[] dim = new int[2];
        dim[0] = Integer.parseInt(matrixSize[0]);
        dim[1] = Integer.parseInt(matrixSize[1]);
        String[][] matrix;

        matrix = readMatrix(dim, scan);



        String[] input  = scan.nextLine().split("\\s+");
        String  command = input[0];
        boolean isInRange;
        while (!"END".equals(command)) {
            //Expected command check
            if (input[0].equals("swap")) {
                int[] point1 = new int[2];
                point1[0] = Integer.parseInt(input[1]);
                point1[1] = Integer.parseInt(input[2]);

                int[] point2 = new int[2];
                point2[0] = Integer.parseInt(input[3]);
                point2[1] = Integer.parseInt(input[4]);

                //Range check
                //1) inRange
                if(isInRange = checkRange(dim, point1, point2)) {
                    matrix = problemLogic(matrix, point1, point2);
                    printResult(matrix, dim, isInRange);
                }
                //2) not inRange
                else {
                    isInRange = false;
                    printResult(matrix, dim, isInRange);

                }
            } else {
                isInRange = false;
                printResult(matrix, dim, isInRange);
            }
            input = scan.nextLine().split("\\s+");
            command = input[0];
        }
    }

    private static void printResult(String[][] matrix,int[] dim ,boolean isInRange) {

        int rows = dim[0];
        int cols = dim[1];

        if (isInRange) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid input!");
        }
    }

    private static boolean checkRange(int[] dim, int[] point1, int[] point2) {

        int rowLength = dim[0];
        int colLength = dim[1];

        if(point1[0] <= rowLength && point2[0] <= rowLength) {
            if(point1[1] <= colLength && point2[1] <= colLength) {
                return true;
            }
        }
        return false;
    }

    private static String[][] problemLogic(String[][] matrix, int[] point1, int[] point2) {

        String temp = matrix[point2[0]][point2[1]];
        matrix[point2[0]][point2[1]] = matrix[point1[0]][point1[1]];
        matrix[point1[0]][point1[1]] = temp;

        return matrix;
    }

    private static String[] readArrInt(Scanner scan) {

        String [] arr = scan.nextLine().split("\\s+");

        return arr;
    }

    private static String[][] readMatrix(int[] dim, Scanner scan) {

        int rows = dim[0];
        int cols = dim[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] arr = readArrInt(scan);
            matrix[row] = arr;
        }

        return matrix;
    }
}
