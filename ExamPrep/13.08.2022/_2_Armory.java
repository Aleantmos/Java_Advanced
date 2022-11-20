import java.util.Scanner;

public class _2_Armory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dimensions = Integer.parseInt(scan.nextLine());

        String[][] armory = new String[dimensions][dimensions];
        armory = getArmory(scan, dimensions);


        int[] officersPosition = new int[2];
        officersPosition = getOfficersPosition(armory, dimensions);

        int kingsBudget = 65;
        int coinsSpent = 0;

        String command;
        boolean outOfArmory = false;

        while (kingsBudget > coinsSpent) {

            command = scan.nextLine();

            switch (command) {
                case "up":
                    armory[officersPosition[0]][officersPosition[1]] = "-";
                    officersPosition[0] -= 1;

                    outOfArmory = checkIfOfficerIsEscortedOut(officersPosition, armory);
                    if (outOfArmory) {
                        break;
                    }

                    if (armory[officersPosition[0]][officersPosition[1]].equals("M")) {
                        armory[officersPosition[0]][officersPosition[1]] = "-";
                        officersPosition = moveToOtherMirror(armory, officersPosition, dimensions);
                        armory[officersPosition[0]][officersPosition[1]] = "-";
                    }
                    coinsSpent = checkForSwords(armory, officersPosition, coinsSpent);
                    armory[officersPosition[0]][officersPosition[1]] = "A";

                    break;
                case "down":
                    armory[officersPosition[0]][officersPosition[1]] = "-";
                    officersPosition[0] += 1;

                    outOfArmory = checkIfOfficerIsEscortedOut(officersPosition, armory);
                    if (outOfArmory) {
                        break;
                    }

                    if (armory[officersPosition[0]][officersPosition[1]].equals("M")) {
                        armory[officersPosition[0]][officersPosition[1]] = "-";
                        officersPosition = moveToOtherMirror(armory, officersPosition, dimensions);
                        armory[officersPosition[0]][officersPosition[1]] = "-";
                    }
                    coinsSpent = checkForSwords(armory, officersPosition, coinsSpent);
                    armory[officersPosition[0]][officersPosition[1]] = "A";
                    break;
                case "left":
                    armory[officersPosition[0]][officersPosition[1]] = "-";
                    officersPosition[1] -= 1;

                    outOfArmory = checkIfOfficerIsEscortedOut(officersPosition, armory);
                    if (outOfArmory) {
                        break;
                    }

                    if (armory[officersPosition[0]][officersPosition[1]].equals("M")) {
                        armory[officersPosition[0]][officersPosition[1]] = "-";
                        officersPosition = moveToOtherMirror(armory, officersPosition, dimensions);
                        armory[officersPosition[0]][officersPosition[1]] = "-";
                    }
                    coinsSpent = checkForSwords(armory, officersPosition, coinsSpent);
                    armory[officersPosition[0]][officersPosition[1]] = "A";
                    break;
                case "right":
                    armory[officersPosition[0]][officersPosition[1]] = "-";
                    officersPosition[1] += 1;

                    outOfArmory = checkIfOfficerIsEscortedOut(officersPosition, armory);
                    if (outOfArmory) {
                        break;
                    }

                    if (armory[officersPosition[0]][officersPosition[1]].equals("M")) {
                        armory[officersPosition[0]][officersPosition[1]] = "-";
                        officersPosition = moveToOtherMirror(armory, officersPosition, dimensions);
                        armory[officersPosition[0]][officersPosition[1]] = "-";
                    }
                    coinsSpent = checkForSwords(armory, officersPosition, coinsSpent);
                    armory[officersPosition[0]][officersPosition[1]] = "A";
                    break;
            }
            if(outOfArmory) {
                break;
            }
        }
        if (outOfArmory) {
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n", coinsSpent);

        printArmory(armory);
    }

    private static void printArmory(String[][] armory) {

        int armoryLength = armory.length - 1;
        int armoryWidth = armory[0].length - 1;

        for (int row = 0; row <= armoryLength; row++) {
            for (int col = 0; col <= armoryWidth; col++) {
                System.out.print(armory[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean checkIfOfficerIsEscortedOut(int[] officersPosition, String[][] armory) {

        boolean isOut = false;

        int row = officersPosition[0];
        int col = officersPosition[1];

        int armoryLength = armory.length - 1;
        int armoryWidth = armory[0].length - 1;

        if (row < 0 || row > armoryLength || col < 0 || col > armoryWidth) {
            isOut = true;
        }
        return isOut;
    }

    private static int checkForSwords(String[][] armory, int[] officersPosition, int coinsSpent) {

        int row = officersPosition[0];
        int col = officersPosition[1];


        if (!armory[row][col].equals("-")) {
            int priceOfSword = Integer.parseInt(armory[row][col]);
            coinsSpent += priceOfSword;
        }
        return coinsSpent;
    }

    private static int[] moveToOtherMirror(String[][] armory, int[] officersPosition, int dimensions) {

        int[] position = new int[2];

            for (int row = 0; row < dimensions; row++) {
                for (int col = 0; col < dimensions; col++) {
                    if (armory[row][col].equals("M")) {
                        position[0] = row;
                        position[1] = col;

                    }
                }
            }
        return position;
    }

    private static int[] getOfficersPosition(String[][] armory, int dimensions) {

        int[] position = new int[2];

        for (int row = 0; row < dimensions; row++) {
            for (int col = 0; col < dimensions; col++) {
                if (armory[row][col].equals("A")) {
                    position[0] = row;
                    position[1] = col;
                }
            }
        }
        return position;
    }

    private static String[][] getArmory(Scanner scan, int dimensions) {

        String[][] armory = new String[dimensions][dimensions];

        for (int row = 0; row < dimensions; row++) {
            String[] arr = scan.nextLine().split("");
            armory[row] = arr;
        }
        return armory;
    }
}
