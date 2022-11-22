import java.util.Scanner;

public class _2_Python {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dim = Integer.parseInt(scan.nextLine());

        String[] commands = scan.nextLine().split(", ");
        int commandsCnt = 0;

        String[][] screen = new String[dim][dim];
        screen = getScreen(scan, dim, screen);

        int[] pythonPosition = new int[2];
        pythonPosition = findPosition(screen, dim, pythonPosition);

        boolean steppedOnEnemy = false;
        int pythonLength = 1;

        while (commands.length - 1 - commandsCnt >= 0) {
            String command = commands[commandsCnt];

            switch (command) {
                case "up":
                    pythonPosition[0] -= 1;
                    if (pythonOutOfScope(pythonPosition, dim)) {
                        pythonPosition[0] = dim - 1;
                    }
                    if (pythonStumblesOnEnemy(screen, dim, pythonPosition)) {
                        steppedOnEnemy = true;
                    }
                    if (pythonStumblesOnFood(screen, dim, pythonPosition)) {
                        pythonLength++;
                        screen[pythonPosition[0]][pythonPosition[1]] = "*";
                    }
                    break;
                case "down":
                    pythonPosition[0] += 1;
                    if (pythonOutOfScope(pythonPosition, dim)) {
                        pythonPosition[0] = 0;
                    }
                    if (pythonStumblesOnEnemy(screen, dim, pythonPosition)) {
                        steppedOnEnemy = true;
                    }
                    if (pythonStumblesOnFood(screen, dim, pythonPosition)) {
                        pythonLength++;
                        screen[pythonPosition[0]][pythonPosition[1]] = "*";
                    }
                    break;
                case "left":
                    pythonPosition[1] -= 1;
                    if (pythonOutOfScope(pythonPosition, dim)) {
                        pythonPosition[1] = dim - 1;
                    }
                    if (pythonStumblesOnEnemy(screen, dim, pythonPosition)) {
                        steppedOnEnemy = true;
                    }
                    if (pythonStumblesOnFood(screen, dim, pythonPosition)) {
                        pythonLength++;
                        screen[pythonPosition[0]][pythonPosition[1]] = "*";
                    }
                    break;
                case "right":
                    pythonPosition[1] += 1;
                    if (pythonOutOfScope(pythonPosition, dim)) {
                        pythonPosition[1] = 0;
                    }
                    if (pythonStumblesOnEnemy(screen, dim, pythonPosition)) {
                        steppedOnEnemy = true;
                    }
                    if (pythonStumblesOnFood(screen, dim, pythonPosition)) {
                        pythonLength++;
                        screen[pythonPosition[0]][pythonPosition[1]] = "*";
                    }
                    break;

            }
            if (steppedOnEnemy) {
                break;
            }
            commandsCnt++;
        }


        int foodLeft = checkIfFoodLeftOnScreen(screen, dim);

        if (steppedOnEnemy) {
            System.out.println("You lose! Killed by an enemy!");
        } else if (foodLeft != 0) {
            System.out.printf("You lose! There is still %d food to be eaten.", foodLeft);
        } else {
            System.out.printf("You win! Final python length is %d%n", pythonLength);
        }
    }

    private static int checkIfFoodLeftOnScreen(String[][] screen, int dim) {
        int foodLeft = 0;

        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                if (screen[row][col].equals("f")) {
                    foodLeft++;
                }
            }
        }
        return foodLeft;
    }

    private static boolean pythonStumblesOnFood(String[][] screen, int dim, int[] pythonPosition) {
        String findElement = "f";
        return foundElement(screen, dim, pythonPosition, findElement);
    }

    private static boolean pythonStumblesOnEnemy(String[][] screen, int dim, int[] pythonPosition) {

        String findElement = "e";
        return foundElement(screen, dim, pythonPosition, findElement);
    }

    private static boolean foundElement(String[][] screen, int dim, int[] pythonPosition, String findElement) {
        boolean elementFound = false;

        if (screen[pythonPosition[0]][pythonPosition[1]].equals(findElement)) {
            elementFound = true;
        }

        return elementFound;
    }

    private static boolean pythonOutOfScope(int[] pythonPosition, int dim) {
        boolean isOutOfScope = false;

        if (pythonPosition[0] < 0 || pythonPosition[0] >= dim ||
                pythonPosition[1] < 0 || pythonPosition[1] >= dim) {
            isOutOfScope = true;
        }
        return isOutOfScope;
    }


    private static int[] findPosition(String[][] screen, int dim, int[] pythonPosition) {

        boolean positionFound = false;

        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                if (screen[row][col].equals("s")) {
                    pythonPosition[0] = row;
                    pythonPosition[1] = col;
                    positionFound = true;
                    break;
                }
            }
            if (positionFound) {
                break;
            }
        }
        return pythonPosition;
    }

    private static String[][] getScreen(Scanner scan, int dim, String[][] screen) {

        for (int row = 0; row < dim; row++) {
            String[] arr = scan.nextLine().split("\\s+");
            screen[row] = arr;
        }
        return screen;
    }
}
