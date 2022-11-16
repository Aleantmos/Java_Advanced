import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _2_TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int[] dimensions = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(num -> Integer.parseInt(num))
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] field = new String[rows][cols];
        int[] myPosition = new int[2];

        boolean foundMyPosition = false;

        for (int row = 0; row < rows; row++) {
            String[] arr = scan.nextLine().split(" ");
            field[row] = arr;

            if (!foundMyPosition) {
                for (int col = 0; col < arr.length; col++) {
                    if (field[row][col].equals("Y")) {
                        myPosition[0] = row;
                        myPosition[1] = col;
                        foundMyPosition = true;
                    }
                }
            }
        }

        System.out.println();
        String command;
        boolean treasureFound = false;
        List<String> directionsToTreasure = new ArrayList<>();

        while (!"Finish".equals(command = scan.nextLine())) {

            //boolean invalidMove = false;
            switch (command) {

                case "up":
                    //invalidMove = checkIfThereIsTree(field, myPosition, command, rows, cols);
                    myPosition[0] -= 1;
                    if ((myPosition[0] > 0) &&
                            (!field[myPosition[0]][myPosition[1]].equals("T"))) {
                        field[myPosition[0] + 1][myPosition[1]] = "-";

                        directionsToTreasure.add(command);

                        if (field[myPosition[0]][myPosition[1]].equals("X")) {
                            treasureFound = true;
                        } else {
                            field[myPosition[0]][myPosition[1]] = ("Y");
                        }
                    }
                    break;
                case "down":
                    myPosition[0] += 1;
                    if ((myPosition[0] < rows) &&
                            (!field[myPosition[0]][myPosition[1]].equals("T"))) {
                        field[myPosition[0] - 1][myPosition[1]] = "-";

                        directionsToTreasure.add(command);

                        if (field[myPosition[0]][myPosition[1]].equals("X")) {
                            treasureFound = true;
                        } else {
                            field[myPosition[0]][myPosition[1]] = ("Y");
                        }
                    }
                    break;
                case "left":
                    myPosition[1] -= 1;
                    if ((myPosition[1] > 0) &&
                            (!field[myPosition[0]][myPosition[1]].equals("T"))) {
                        field[myPosition[0] + 1][myPosition[1]] = "-";

                        directionsToTreasure.add(command);

                        if (field[myPosition[0]][myPosition[1]].equals("X")) {
                            treasureFound = true;
                        } else {
                            field[myPosition[0]][myPosition[1]] = ("Y");
                        }
                    }
                    break;
                case "right":
                    myPosition[1] += 1;
                    if ((myPosition[1] < cols) &&
                            (!field[myPosition[0]][myPosition[1]].equals("T"))) {
                        field[myPosition[0] - 1][myPosition[1]] = "-";

                        directionsToTreasure.add(command);

                        if (field[myPosition[0]][myPosition[1]].equals("X")) {
                            treasureFound = true;
                        } else {
                            field[myPosition[0]][myPosition[1]] = ("Y");
                        }
                    }
                    break;
            }
            if (treasureFound) {
                break;
            }
        }

        if (treasureFound) {
            System.out.println("I've found the treasure!");
            System.out.println("The right path is " + String.join(", ", directionsToTreasure));
        } else {
            System.out.println("The map is fake!");
        }
    }


}
