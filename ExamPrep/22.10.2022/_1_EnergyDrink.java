import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _1_EnergyDrink {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int currInput = 0;

        //milligrams if caffeineMilligrams (int) - stack
        currInput++;
        ArrayDeque<Integer> caffeineMilligrams = readInput(scan, currInput);
        //energy drinks (int) - queue
        currInput++;
        ArrayDeque<Integer> energyDrinks = readInput(scan, currInput);

        int maxCaffeine = 300;
        int totalCaffeine = 0;
        int currCaffeine;

        while (totalCaffeine < maxCaffeine) {

            int currCaffeineElement = caffeineMilligrams.peek();
            int currEnergyDrinkElement = energyDrinks.peek();

            currCaffeine = currCaffeineElement * currEnergyDrinkElement;

            boolean hasExceeded = checkCaffeineAmount(currCaffeine, totalCaffeine, maxCaffeine);

            if (hasExceeded) {
                int currDrink = energyDrinks.remove();
                energyDrinks.add(currDrink);

                totalCaffeine -= 30;
                if (totalCaffeine < 0) {
                    totalCaffeine = 0;
                }

            } else {
                energyDrinks.remove();
                totalCaffeine += currCaffeine;
            }
            caffeineMilligrams.pop();

            if (checkIfOutOfCaffeineOrDrinks(caffeineMilligrams, energyDrinks)) {
                break;
            }
        }

        if (energyDrinks.isEmpty()) {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {
            String toPrint = String.join(", ", List.of(energyDrinks.toString().
                    substring(1, energyDrinks.toString().length() - 1)));
            System.out.println("Drinks left: " + toPrint);
        }
        System.out.printf("Stamat is going to sleep with %s mg caffeine.", totalCaffeine);
    }

    private static boolean checkIfOutOfCaffeineOrDrinks(ArrayDeque<Integer> caffeineMilligrams, ArrayDeque<Integer> energyDrinks) {
        return caffeineMilligrams.isEmpty() || energyDrinks.isEmpty();
    }

    private static boolean checkCaffeineAmount(int currCaffeine, int totalCaffeine, int maxCaffeine) {

        boolean hasExceeded = false;
        totalCaffeine += currCaffeine;

        if (maxCaffeine < totalCaffeine) {
            totalCaffeine -= currCaffeine;
            hasExceeded = true;
        }

        return hasExceeded;
    }

    public static ArrayDeque<Integer> readInput(Scanner scan, int curr) {

        int[] numbers = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(num -> Integer.parseInt(num))
                .toArray();

        ArrayDeque<Integer> deque = new ArrayDeque();

        for (int i = 0; i < numbers.length; i++) {
            if (curr == 1) {
                deque.push(numbers[i]);
            } else if (curr == 2) {
                deque.add(numbers[i]);
            }
        }
        return deque;
    }
}
