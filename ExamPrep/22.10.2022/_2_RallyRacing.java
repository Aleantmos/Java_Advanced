import java.util.Scanner;

public class _2_RallyRacing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dim = Integer.parseInt(scan.nextLine());
        String carName = scan.nextLine();

        String[][] track = getTrack(dim, scan);


        int[] currPosition = {0, 0};
        int kmPassed = 0;
        String command;
        boolean finished = false;


        while (!"End".equals(command = scan.nextLine())) {
            boolean thereIsATunnel = false;
            switch (command) {
                case "left":
                    currPosition[1] -= 1;
                    thereIsATunnel = checkForTunnelAndMoveThrough(track, currPosition);
                    if (thereIsATunnel) {
                        currPosition = moveToOtherSideOfTunnel(currPosition, track);
                        kmPassed += 30;
                    } else {
                        kmPassed += 10;
                    }
                    finished = checkForFinishLine(track, currPosition);
                    break;
                case "right":
                    currPosition[1] += 1;
                    thereIsATunnel = checkForTunnelAndMoveThrough(track, currPosition);
                    if (thereIsATunnel) {
                        currPosition = moveToOtherSideOfTunnel(currPosition, track);
                        kmPassed += 30;
                    } else {
                        kmPassed += 10;
                    }
                    finished = checkForFinishLine(track, currPosition);
                    break;
                case "up":
                    currPosition[0] -= 1;
                    thereIsATunnel = checkForTunnelAndMoveThrough(track, currPosition);
                    if (thereIsATunnel) {
                        currPosition = moveToOtherSideOfTunnel(currPosition, track);
                        kmPassed += 30;
                    } else {
                        kmPassed += 10;
                    }
                    finished = checkForFinishLine(track, currPosition);
                    break;
                case "down":
                    currPosition[0] += 1;
                    thereIsATunnel = checkForTunnelAndMoveThrough(track, currPosition);
                    if (thereIsATunnel) {
                        currPosition = moveToOtherSideOfTunnel(currPosition, track);
                        kmPassed += 30;
                    } else {
                        kmPassed += 10;
                    }
                    finished = checkForFinishLine(track, currPosition);
                    break;
            }
            if (finished) {
                track[currPosition[0]][currPosition[1]] = "C";
                break;
            }
        }

        if (finished) {
            System.out.printf("Racing car %s finished the stage!%n", carName);
        } else {
            System.out.printf("Racing car %s DNF.%n", carName);
        }

        System.out.printf("Distance covered %d km.%n", kmPassed);
        printMatrix(track, currPosition);

    }

    private static void printMatrix(String[][] track, int[] currPosition) {
        track[currPosition[0]][currPosition[1]] = "C";

        int rowsSize = track.length;
        int colSize = track.length;

        for (int row = 0; row < rowsSize; row++) {
            for (int col = 0; col < colSize; col++) {
                System.out.printf("%s", track[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean checkForFinishLine(String[][] track, int[] currPosition) {

        boolean finished = false;

        int rowInMatrix = currPosition[0];
        int colInMatrix = currPosition[1];

        if (track[rowInMatrix][colInMatrix].equals("F")) {
            finished = true;
        }

        return finished;

    }

    private static boolean checkForTunnelAndMoveThrough(String[][] track, int[] currPosition) {

        boolean tunnel = false;

        int rowInMatrix = currPosition[0];
        int colInMatrix = currPosition[1];

        if (track[rowInMatrix][colInMatrix].equals("T")) {
            track[rowInMatrix][colInMatrix] = ".";
            tunnel = true;
        }
        return tunnel;
    }

    private static int[] moveToOtherSideOfTunnel(int[] currPosition, String[][] track) {

        int rowsSize = track.length;
        int colSize = track.length;

        for (int row = 0; row < rowsSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (track[row][col].equals("T")) {
                    track[row][col] = ".";
                    currPosition[0] = row;
                    currPosition[1] = col;
                }
            }
        }
        return currPosition;
    }


    private static String[][] getTrack(int dim, Scanner scan) {

        int rows = dim;
        int cols = dim;

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] arr = scan.nextLine().split("\\s+");
            matrix[i] = arr;
        }

        return matrix;
    }
}
