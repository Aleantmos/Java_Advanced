import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String[] input = scan.nextLine().split(", ");

        int n = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[n][n];

        if ("A".equals(pattern)) {
            int cnt = 1;
            for (int col = 0; col < n; col++) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = cnt;
                    cnt++;
                }
            }
        }
        if ("B".equals(pattern)) {
            int cnt = 1;
            for (int col = 0; col < n; col++) {
                if (col % 2 == 0) {
                    for (int row = 0; row < n; row++) {
                        matrix[row][col] = cnt;
                        cnt++;
                    }
                } else {
                    for (int row = n - 1; row >= 0; row--) {
                        matrix[row][col] = cnt;
                        cnt++;
                    }
                }
            }
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}


//    String[] input = scan.nextLine().split(", ");
//
//    int dim = Integer.parseInt(input[0]);
//
//    String pattern = input[1];
//    int[][] matrix = new int[dim][dim];
//
//    if ("A".equals(pattern)) {
//        matrix = matrixWithPatternA(matrix);
//    } else if ("B".equals(pattern)) {
//        matrix = matrixWithPatternB(matrix);
//    }
//
//    printMatrix(matrix);
//
//}
//
//
//private static void printMatrix(int[][] matrix) {
//
//    for (int i = 0; i < matrix.length; i++) {
//        for (int j = 0; j < matrix[i].length; j++) {
//            System.out.print(matrix[i][j] + " ");
//        }
//        System.out.println();
//    }
//}
//
//private static int[][] matrixWithPatternB(int[][] matrix) {
//    int rows = matrix.length;
//    int cols = matrix.length;
//
//    int cnt = 1;
//
//    for (int col = 0; col < cols; col++) {
//        if (col % 2 == 0) {
//            for (int row = 0; row < rows; row++) {
//                matrix[col][row] = cnt;
//                cnt++;
//            }
//        } else {
//            for (int row = rows; row >= 0; row--) {
//                matrix[row][col] = cnt;
//                cnt++;
//            }
//        }
//    }
//
//    return matrix;
//}
//
//public static int[][] matrixWithPatternA(int[][] matrix) {
//
//    int rows = matrix.length;
//    int cols = matrix.length;
//
//    int cnt = 1;
//
//    for (int col = 0; col < cols; col++) {
//        int[] arr = new int[rows];
//        int currNum = cnt;
//        for (int row = 0; row < rows; row++) {
//            arr[row] = currNum;
//            currNum += 3;
//        }
//        matrix[col] = arr;
//        cnt++;
//
//    }
//
//    return matrix;
//}

