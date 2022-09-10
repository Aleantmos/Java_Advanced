import java.util.*;

public class _3_Voina {
    public static void main(String[] args) {
        //ToDo - 80/100
        Scanner scan = new Scanner(System.in);

        Set<Integer> cards1 = new LinkedHashSet<>();
        Set<Integer> cards2 = new LinkedHashSet<>();

        cards1 = readNumbers(scan);
        cards2 = readNumbers(scan);

        int cnt = 50;

        boolean player1wins = false;
        boolean player2wins = false;
        boolean draw = false;

        while (0 != cnt--) {


            if (cards1.isEmpty() && cards2.isEmpty()) {
                draw = true;
                break;
            } else if (cards2.isEmpty()) {
                player1wins = true;
                break;
            } else if (cards1.isEmpty()) {
                player2wins = true;
                break;
            }

            int bestCard1 = cards1.iterator().next();
            cards1.remove(bestCard1);

            int bestCard2 = cards2.iterator().next();
            cards2.remove(bestCard2);

            if (bestCard1 > bestCard2) {
                cards1.add(bestCard1);
                cards1.add(bestCard2);
            } else if (bestCard2 < bestCard1) {
                cards2.add(bestCard1);
                cards2.add(bestCard2);
            }

            if (cnt == 0) {
                if (cards1.size() > cards2.size()) {
                    player1wins = true;
                    break;
                } else if (cards1.size() < cards2.size()){
                    player2wins = true;
                    break;
                }
            }

        }
        if (draw) {
            System.out.println("Draw!");
        } else if (player1wins) {
            System.out.println("First player win!");
        } else if (player2wins) {
            System.out.println("Second player win!");
        }

    }


    public static Set<Integer> readNumbers (Scanner scan) {

        int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();


        LinkedHashSet cards = new LinkedHashSet<>();


        for (int card : arr) {
            if (!cards.contains(card)) {
                cards.add(card);
            }
        }

        return cards;
    }
}
