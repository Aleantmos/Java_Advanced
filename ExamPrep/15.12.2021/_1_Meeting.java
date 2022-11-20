import java.util.*;
import java.util.stream.Collectors;

public class _1_Meeting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //ToDo -71/100
        String[] malesAsString = scan.nextLine().split(" ");
        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        for (int i = 0; i < malesAsString.length; i++) {
            maleStack.push(Integer.parseInt(malesAsString[i]));
        }

        String[] femalesAsString = scan.nextLine().split(" ");
        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();
        for (int i = 0; i < femalesAsString.length; i++) {
            femaleQueue.add(Integer.parseInt(femalesAsString[i]));
        }

        int matchesCnt = 0;

        while (!maleStack.isEmpty() && !femaleQueue.isEmpty()) {

            int currMale = maleStack.pop();
            int currFemale = femaleQueue.remove();

            boolean conditionMet = true;

            if (checkForNegativeValues(currMale, currFemale)) {
                conditionMet = false;
            }

            if (checkForDivisibleBy25(currMale)) {
                maleStack.pop();
                conditionMet = false;
            }
            if (checkForDivisibleBy25(currFemale)) {
                femaleQueue.remove();
                maleStack.push(currMale);
                conditionMet = false;
            }

            if (conditionMet) {
                if (currMale == currFemale) {
                    matchesCnt++;
                } else {
                    currMale -= 2;
                    if (currMale >= 0) {
                        maleStack.push(currMale);
                    }
                }
            }
        }
        System.out.printf("Matches: %d%n", matchesCnt);

        if (maleStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {

            String malesCollection = maleStack.stream()
                    .map(male -> male.toString())
                    .collect(Collectors.joining(", "));
            System.out.println("Males left: " + malesCollection);

        }

        if (femaleQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            String femaleCollection = femaleQueue.stream()
                    .map(female -> female.toString())
                    .collect(Collectors.joining(", "));
            System.out.println("Females left: " + femaleCollection);
        }
    }

    private static boolean checkForDivisibleBy25(int curr) {

        boolean isDivisible = false;

        if (curr % 25 == 0) {
            isDivisible = true;
        }
        return isDivisible;
    }

    private static boolean checkForNegativeValues(int currMale, int currFemale) {

        boolean isNegative = true;
        if (currMale >= 0 && currFemale >= 0) {
            isNegative = false;
        }
        return isNegative;
    }
}
