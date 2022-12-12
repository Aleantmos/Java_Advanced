import java.util.Scanner;

public class _2_ReVolt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        /*
        f -> player
        "-" empty slots
        F -> finish (reach it)
        B -> bonuses (forward)
        T -> traps (backward)

        end
        1) get to F
        2) commandsCnt == 0
         */

        int dim = Integer.parseInt(scan.nextLine());
        int commandsCnt = Integer.parseInt(scan.nextLine());

        int[] myPosition = new int[2];
        String[][] matrix = new String[dim][dim];

        getData(scan, dim, myPosition, matrix);
        boolean isFinished = false;

        for (int i = 0; i < commandsCnt; i++) {
            String command = scan.nextLine();
            matrix[myPosition[0]][myPosition[1]] = "-";
            movePlayer(command, matrix, myPosition, dim);
            if (checkForFinish(matrix, myPosition)) {
                isFinished = true;
                matrix[myPosition[0]][myPosition[1]] = "f";
                break;
            }
            matrix[myPosition[0]][myPosition[1]] = "f";
        }

        if (isFinished) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        printMatrix(matrix, dim);

    }

    private static void printMatrix(String[][] matrix, int dim) {
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean checkForFinish(String[][] matrix, int[] myPosition) {
        String element = "F";
        boolean isFinish = checkForElement(matrix, myPosition, element);
        return isFinish;
    }

    private static void movePlayer(String command, String[][] matrix, int[] myPosition, int dim) {

        matrix[myPosition[0]][myPosition[1]].equals("-");

        switch (command) {
            case "up":
                myPosition[0] -= 1;
                if (outOfScope(myPosition, dim)) {
                    myPosition[0] = dim - 1;
                }
                if (checkForBonus(matrix, myPosition)) {
                    myPosition[0] -= 1;
                    if (outOfScope(myPosition, dim)) {
                        myPosition[0] = dim - 1;
                    }
                }
                if (checkForTrap(matrix, myPosition)) {
                    myPosition[0] += 1;
                    if (outOfScope(myPosition, dim)) {
                        myPosition[0] = dim - 1;
                    }
                }
                break;
            case "down":
                myPosition[0] += 1;
                if (outOfScope(myPosition, dim)) {
                    myPosition[0] = 0;
                }
                if (checkForBonus(matrix, myPosition)) {
                    myPosition[0] += 1;
                    if (outOfScope(myPosition, dim)) {
                        myPosition[0] = 0;
                    }
                }
                if (checkForTrap(matrix, myPosition)) {
                    myPosition[0] -= 1;
                    if (outOfScope(myPosition, dim)) {
                        myPosition[0] = 0;
                    }
                }
                break;
            case "left":
                myPosition[1] -= 1;
                if (outOfScope(myPosition, dim)) {
                    myPosition[1] = dim - 1;
                }
                if (checkForBonus(matrix, myPosition)) {
                    myPosition[1] -= 1;
                    if (outOfScope(myPosition, dim)) {
                        myPosition[1] = dim - 1;
                    }
                }
                if (checkForTrap(matrix, myPosition)) {
                    myPosition[1] += 1;
                    if (outOfScope(myPosition, dim)) {
                        myPosition[1] = dim - 1;
                    }
                }
                break;
            case "right":
                myPosition[1] += 1;
                if (outOfScope(myPosition, dim)) {
                    myPosition[1] = 0;
                }
                if (checkForBonus(matrix, myPosition)) {
                    myPosition[1] += 1;
                    if (outOfScope(myPosition, dim)) {
                        myPosition[1] = 0;
                    }
                }
                if (checkForTrap(matrix, myPosition)) {
                    myPosition[1] -= 1;
                    if (outOfScope(myPosition, dim)) {
                        myPosition[1] = 0;
                    }
                }
                break;
        }
    }

    private static boolean checkForElement(String[][] matrix, int[] myPosition, String element) {

        boolean isFound = false;

        if (matrix[myPosition[0]][myPosition[1]].equals(element)) {
            isFound = true;
        }
        return isFound;
    }

    private static boolean checkForBonus(String[][] matrix, int[] myPosition) {
        String element = "B";
        boolean isBonus = checkForElement(matrix, myPosition, element);
        return isBonus;
    }

    private static boolean checkForTrap(String[][] matrix, int[] myPosition) {
        String element = "T";
        boolean isTrap = checkForElement(matrix, myPosition, element);
        return isTrap;
    }

    private static boolean outOfScope(int[] myPosition, int dim) {
        boolean outOfScope = myPosition[0] < 0 || myPosition[0] >= dim || myPosition[1] < 0 || myPosition[1] >= dim;
        return outOfScope;
    }

    private static void getData(Scanner scan, int dim, int[] myPosition, String[][] matrix) {
        for (int row = 0; row < dim; row++) {
            String[] arr = scan.nextLine().split("");
            matrix[row] = arr;
            for (int col = 0; col < dim; col++) {
                if (matrix[row][col].equals("f")) {
                    myPosition[0] = row;
                    myPosition[1] = col;
                }
            }
        }
    }
}
