import java.util.*;
import java.util.stream.Collectors;

public class _1_Blacksmith {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = readIntArray(scan);
        ArrayDeque<Integer> steelAmounts = new ArrayDeque<>();
        for (int number : numbers) {
            steelAmounts.add(number);
        }

        numbers = readIntArray(scan);
        ArrayDeque<Integer> carbonAmounts = new ArrayDeque<>();
        for (int number : numbers) {
            carbonAmounts.push(number);
        }

        Map<String, Integer> swordsProduced = new TreeMap<>();

        while (!carbonAmounts.isEmpty() && !steelAmounts.isEmpty()) {

            int currSteel = steelAmounts.peek();
            int currCarbon = carbonAmounts.peek();

            int resourcesNeeded = currSteel + currCarbon;

            String sword = checkSwordProduction(resourcesNeeded);

            if (sword.equals("noSword")) {
                currCarbon += 5;
                carbonAmounts.pop();
                carbonAmounts.push(currCarbon);
            } else {
                swordsProduced.putIfAbsent(sword, 0);
                swordsProduced.put(sword, swordsProduced.get(sword) + 1);
                carbonAmounts.remove();
            }
            steelAmounts.remove();
        }

        if (swordsProduced.isEmpty()) {
            System.out.println("You did not have enough resources to forge a sword.");
        } else {
            int sum = swordsProduced.values().stream()
                    .mapToInt(n -> n).sum();
            System.out.printf("You have forged %d swords.%n", sum);
        }

        if (steelAmounts.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            String steelCollection = steelAmounts.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));

            System.out.println("Steel left: " + steelCollection);
        }

        if (carbonAmounts.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            String carbonCollection = carbonAmounts.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));

            System.out.println("Carbon left: " + carbonCollection);
        }

        swordsProduced.entrySet().stream()
                .forEach(sword -> System.out.println(sword.getKey() + ": " + sword.getValue()));

    }

    private static String checkSwordProduction(int resourcesNeeded) {

        String sword = "noSword";

        if (resourcesNeeded == 70) {
            sword = "Gladius";
        } else if (resourcesNeeded == 80) {
            sword = "Shamshir";
        } else if (resourcesNeeded == 90) {
            sword = "Katana";
        } else if (resourcesNeeded == 110) {
            sword = "Sabre";
        }
        return sword;
    }

    public static int[] readIntArray(Scanner scan) {
        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(num -> Integer.parseInt(num))
                .toArray();

        return numbers;
    }
}