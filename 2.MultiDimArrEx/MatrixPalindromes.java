import java.util.Arrays;
import java.util.Scanner;

public class MatrixPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] data = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int rows = data[0];
        int cols = data[1];
        int elements = 3;
        String[][][] matrix = new String[rows][cols][elements];

        char letterAsChar = 97;
        char middleLetterAsChar = 97;
        for (int row = 0; row < rows; row++) {
            middleLetterAsChar = letterAsChar;
            for (int col = 0; col < cols; col++) {
                String letter = Character.toString(letterAsChar);
                matrix[row][col][0] =  letter;

                String middleLetter = Character.toString(middleLetterAsChar);
                matrix[row][col][1] = middleLetter;
                middleLetterAsChar++;

                matrix[row][col][2] =  letter;
            }
            letterAsChar++;
        }
        print(matrix);

    }

    public static void print(String[][][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                for (int element = 0; element < matrix[row][col].length; element++) {
                    System.out.print(matrix[row][col][element]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
