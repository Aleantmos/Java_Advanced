import java.util.Scanner;

public class TheHeigenDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//Todo 10,11,12
        int playerRow = 7;
        int playerCol = 7;
        int playerHP = 18_500;

        double heiganHP = 3_000_000;
        double heiganDamage = Double.parseDouble(scan.nextLine());
        boolean cloud = false;

        String spell = "";

        while (playerHP > 0 && heiganDamage > 0) {

            heiganHP -= heiganDamage;

            if (cloud) {
                playerHP -= 3500;
                cloud = false;
            }
            if (playerHP < 0 || heiganHP < 0) continue;//break;

            String[] input = scan.nextLine().split("\\s+");
            spell = input[0];

            int rowHit = Integer.parseInt(input[1]);
            int colHit = Integer.parseInt(input[2]);


            if ((playerRow >= Math.max(0, rowHit - 1) && playerRow <= Math.min(14, rowHit + 1))
                    &&
                    (playerCol >= Math.max(0, colHit - 1) && (playerCol <= Math.min(14, colHit + 1)))) {

                if (playerRow - 1 >= 0 && playerRow - 1 < Math.max(0, rowHit - 1)) {
                    playerRow--;
                } else if (playerCol + 1 <= 14 && playerCol + 1 > Math.min(14, colHit + 1)) {
                    playerCol++;
                } else if (playerRow + 1 <= 14 && playerCol + 1 > Math.min(14, colHit + 1)) {
                    playerRow++;
                } else if (playerCol - 1 >= 0 && playerCol - 1 < Math.max(0, colHit - 1)) {
                    playerCol--;
                } else if (heiganHP > 0) {
                    switch (spell) {
                        case "Cloud":
                            playerHP -= 3500;
                            spell = "Plague Cloud";
                            cloud = true;
                            break;
                        case "Eruption":
                            playerHP -= 6000;
                            break;
                    }
                }
            }
        }
        if (heiganHP > 0) {
            System.out.printf("Heigan: %.2f%n", heiganHP);
        } else {
            System.out.println("Heigan: Defeated!");
        }

        if (playerHP > 0) {
            System.out.printf("Player: %d%n", playerHP);
        } else {
            System.out.printf("Player: Killed by %s%n", spell);
        }
        System.out.printf("Final position: %d %d", playerRow, playerCol);
    }
}
