import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class _4_AppliedArithmetic {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(num -> Integer.parseInt(num))
                .toArray();

        String command = "";

        Function<int[], int[]> addOne = arr -> Arrays.stream(arr)
                .map(num -> num += 1)
                .toArray();

        Function<int[], int[]> multiplyByTwo = arr -> Arrays.stream(arr)
                .map(num -> num *= 2)
                .toArray();


        Consumer <int[]> printConsumer = arr -> Arrays.stream(arr)
                .forEach(e -> System.out.print(e + " "));
        while (!"end".equals(command = scan.nextLine())) {

            switch (command) {
                case "add":
                    numbers = addOne.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyByTwo.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractOne(numbers);
                    break;
                case "print":
                    printConsumer.accept(numbers);
                    System.out.println();
                    break;
            }
        }
    }
    public static int[] subtractOne (int[] numbers) {
        return Arrays.stream(numbers)
                .map(num -> num -= 1)
                .toArray();
    }
}
