import java.util.Scanner;

public class _2_PawnWars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        char[][] chessBoard = new char[8][8];
        
        int wRow = -1;
        int wCol = -1;
        int bRow = -1;
        int bCol = -1;


        for (int row = 0; row < chessBoard.length; row++) {
            char[] arr = scan.nextLine().toCharArray();
            for (int col = 0; col < arr.length; col++) {
                chessBoard[row][col] = arr[col];
                if (chessBoard[row][col] == 'w') {
                    wRow = row;
                    wCol = col;
                } else if (chessBoard[row][col] == 'b') {
                    bRow = row;
                    bCol = col;
                }
            }
        }
        boolean isHit = false;

        while (wRow != 0 && bRow != 7 && !isHit) {

            if (whitePawnHitBlack(wRow, wCol, bRow, bCol)) {
                String coordinates = findCoordinates(bRow, bCol);
                System.out.printf("Game over! White capture on %s.", coordinates);
                isHit = true;
            }
            wRow -= 1;
            if (blackPawnHitWhite(bRow, bCol, wRow, wCol)) {
                String coordinates = findCoordinates(wRow, wCol);
                System.out.printf("Game over! White capture on %s.", coordinates);
                isHit = true;
            }
            bRow += 1;
        }

        if (!isHit) {
            System.out.printf(wRow == 0
                    ? "Game over! White pawn is promoted to a queen at " + findCoordinates(wRow, wCol) + "."
                    : "Game over! Black pawn is promoted to a queen at " + findCoordinates(bRow, bCol) + "."
            );
        }
    }

    private static String findCoordinates(int plWhoIsHitRow, int plWhoIsHitCol) {
        char[] col = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] row = new char[]{'8', '7', '6', '5', '4', '3', '2', '1'};
        StringBuilder sb = new StringBuilder();
        sb.append(col[plWhoIsHitCol]).append(row[plWhoIsHitRow]);
        return sb.toString();
    }

    private static boolean blackPawnHitWhite(int bRow, int bCol, int wRow, int wCol) {
        boolean isHit = false;

        if (wRow + 1 == bRow && (wCol + 1 == bCol || wCol - 1 == bCol)) {
            isHit = true;
        }
        return isHit;

    }

    private static boolean whitePawnHitBlack(int wRow, int wCol, int bRow, int bCol) {
        boolean isHit = false;

        if (bRow + 1 == wRow && (bCol + 1 == wCol) || bCol - 1 == wCol) {
            isHit = true;
        }
        return isHit;
    }
}
