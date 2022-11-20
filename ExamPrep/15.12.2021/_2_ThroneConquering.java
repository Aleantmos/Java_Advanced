import java.util.Scanner;

public class _2_ThroneConquering {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
// ToDo - one test incorrect
        int healthOfParis = Integer.parseInt(scan.nextLine());

        int dim = Integer.parseInt(scan.nextLine());
        String[][] sparta = new String[dim][dim];

        sparta = getSparta(scan, dim);

        int[] parisPosition = new int[2];
        parisPosition = getPositionOfParis(sparta, dim);

        boolean foundHelena = false;

        while (!foundHelena) {
            String[] input = scan.nextLine().split("\\s+");
            String command = input[0];

            int[] guardPosition = new int[2];
            guardPosition[0] = Integer.parseInt(input[1]);
            guardPosition[1] = Integer.parseInt(input[2]);

            sparta[guardPosition[0]][guardPosition[1]] = "S";
            sparta[parisPosition[0]][parisPosition[1]] = "-";

            switch (command) {
                case "up":
                    parisPosition[0] -= 1;
                    if (notInScope(sparta, parisPosition)) {
                        healthOfParis -= 1;
                        parisPosition[0] += 1;
                    } else {

                        if (checkForEnemies(sparta, parisPosition)) {
                            healthOfParis -= 2;
                        }

                        healthOfParis -= 1;

                        if (healthOfParis > 0) {
                            foundHelena = checkIfHelenaIsFound(sparta, parisPosition, healthOfParis);
                            sparta[parisPosition[0]][parisPosition[1]] = "P";
                        } else {
                            sparta[parisPosition[0]][parisPosition[1]] = "X";
                        }
                    }
                    break;
                case "down":
                    parisPosition[0] += 1;
                    if (notInScope(sparta, parisPosition)) {
                        healthOfParis -= 1;
                        parisPosition[0] -= 1;
                    } else {
                        sparta[parisPosition[0]][parisPosition[1]] = "-";
                        parisPosition[0] += 1;

                        if (checkForEnemies(sparta, parisPosition)) {
                            healthOfParis -= 2;
                        }
                        healthOfParis -= 1;

                        if (healthOfParis > 0) {
                            foundHelena = checkIfHelenaIsFound(sparta, parisPosition, healthOfParis);
                            sparta[parisPosition[0]][parisPosition[1]] = "P";
                        } else {
                            sparta[parisPosition[0]][parisPosition[1]] = "X";
                        }
                    }
                    break;
                case "left":
                    parisPosition[1] -= 1;
                    if (notInScope(sparta, parisPosition)) {
                        healthOfParis -= 1;
                        parisPosition[0] += 1;
                    } else {
                        if (checkForEnemies(sparta, parisPosition)) {
                            healthOfParis -= 2;
                        }

                        healthOfParis -= 1;

                        if (healthOfParis > 0) {
                            foundHelena = checkIfHelenaIsFound(sparta, parisPosition, healthOfParis);
                            sparta[parisPosition[0]][parisPosition[1]] = "P";
                        } else {
                            sparta[parisPosition[0]][parisPosition[1]] = "X";
                        }
                    }
                    break;
                case "right":
                    parisPosition[1] += 1;
                    if (notInScope(sparta, parisPosition)) {
                        healthOfParis -= 1;
                        parisPosition[1] -= 1;
                    } else {

                        if (checkForEnemies(sparta, parisPosition)) {
                            healthOfParis -= 2;
                        }

                        healthOfParis -= 1;

                        if (healthOfParis > 0) {
                            foundHelena = checkIfHelenaIsFound(sparta, parisPosition, healthOfParis);
                            sparta[parisPosition[0]][parisPosition[1]] = "P";
                        } else {
                            sparta[parisPosition[0]][parisPosition[1]] = "X";
                        }
                    }
                    break;
            }
            if (healthOfParis <= 0) {
                break;
            }
        }

        if (healthOfParis <= 0) {
            System.out.printf("Paris died at %d;%d.%n", parisPosition[0], parisPosition[1]);
        } else {
            sparta[parisPosition[0]][parisPosition[1]] = "-";
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", healthOfParis);
        }

        printSparta(sparta);


    }

    private static void printSparta(String[][] sparta) {

        int dim = sparta.length;

        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                System.out.print(sparta[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean checkIfHelenaIsFound(String[][] sparta, int[] parisPosition, int healthOfParis) {

        boolean helenaIsFound = false;

        if (sparta[parisPosition[0]][parisPosition[1]].equals("H")) {
            helenaIsFound = true;
        }
        return helenaIsFound;
    }

    private static boolean checkForEnemies(String[][] sparta, int[] parisPosition) {

        boolean fightEnemy = false;

        if (sparta[parisPosition[0]][parisPosition[1]].equals("S")) {
            fightEnemy = true;
        }
        return fightEnemy;
    }

    private static boolean notInScope(String[][] sparta, int[] parisPosition) {

        boolean outOfScope = false;

        if (parisPosition[0] < 0 || parisPosition[0] >= sparta.length ||
                parisPosition[1] < 0 || parisPosition[1] > sparta[0].length) {
            outOfScope = true;
        }
        return outOfScope;
    }


    private static int[] getPositionOfParis(String[][] sparta, int dim) {

        int[] position = new int[2];

        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                if (sparta[row][col].equals("P")) {
                    position[0] = row;
                    position[1] = col;
                    break;
                }
            }
        }
        return position;
    }

    private static String[][] getSparta(Scanner scan, int dim) {

        String[][] sparta = new String[dim][dim];

        for (int row = 0; row < dim; row++) {
            String[] arr = scan.nextLine().split("");
            sparta[row] = arr;
        }
        return sparta;
    }
}
