import java.util.Scanner;

public class _2_NavyBattle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dim = Integer.parseInt(scan.nextLine());
        int[] uPosition = new int[2];
        String[][] northSea = new String[dim][dim];

        getInfo(scan, dim, northSea, uPosition);

        int cruiserCnt = 3;
        int uLives = 3;

        while (cruiserCnt != 0 && uLives != 0) {

            String command = scan.nextLine();

            northSea[uPosition[0]][uPosition[1]] = "-";
            switch (command) {

                case "up":
                    uPosition[0] -= 1;
                    if (northSea[uPosition[0]][uPosition[1]].equals("*")) {
                        uLives--;
                        if (uLives == 0) {
                            northSea[uPosition[0]][uPosition[1]] = "*";
                        } else {
                            northSea[uPosition[0]][uPosition[1]] = "S";
                        }
                    } else if (northSea[uPosition[0]][uPosition[1]].equals("C")) {
                        cruiserCnt--;
                        northSea[uPosition[0]][uPosition[1]] = "S";
                    }
                    break;
                case "down":
                    uPosition[0] += 1;
                    if (northSea[uPosition[0]][uPosition[1]].equals("*")) {
                        uLives--;
                        if (uLives == 0) {
                            northSea[uPosition[0]][uPosition[1]] = "*";
                        } else {
                            northSea[uPosition[0]][uPosition[1]] = "S";
                        }
                    } else if (northSea[uPosition[0]][uPosition[1]].equals("C")) {
                        cruiserCnt--;
                        northSea[uPosition[0]][uPosition[1]] = "S";
                    }
                    break;
                case "left":
                    uPosition[1] -= 1;
                    if (northSea[uPosition[0]][uPosition[1]].equals("*")) {
                        uLives--;
                        if (uLives == 0) {
                            northSea[uPosition[0]][uPosition[1]] = "*";
                        } else {
                            northSea[uPosition[0]][uPosition[1]] = "S";
                        }
                    } else if (northSea[uPosition[0]][uPosition[1]].equals("C")) {
                        cruiserCnt--;
                        northSea[uPosition[0]][uPosition[1]] = "S";
                    }
                    break;
                case "right":
                    uPosition[1] += 1;
                    if (northSea[uPosition[0]][uPosition[1]].equals("*")) {
                        uLives--;
                        if (uLives == 0) {
                            northSea[uPosition[0]][uPosition[1]] = "*";
                        } else {
                            northSea[uPosition[0]][uPosition[1]] = "S";
                        }
                    } else if (northSea[uPosition[0]][uPosition[1]].equals("C")) {
                        cruiserCnt--;
                        northSea[uPosition[0]][uPosition[1]] = "S";
                    }
                    break;
            }
        }

        northSea[uPosition[0]][uPosition[1]] = "S";

        if (cruiserCnt == 0) {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        } else if (uLives == 0) {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", uPosition[0], uPosition[1]);
        }

        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                System.out.print(northSea[row][col]);
            }
            System.out.println();
        }
    }

    private static void getInfo(Scanner scan, int dim, String[][] northSea, int[] uPosition) {

        for (int row = 0; row < dim; row++) {
            String[] arr = scan.nextLine().split("");
            for (int col = 0; col < dim; col++) {
                northSea[row][col] = arr[col];

                if (northSea[row][col].equals("S")) {
                    uPosition[0] = row;
                    uPosition[1] = col;
                }
            }
        }
    }
}
