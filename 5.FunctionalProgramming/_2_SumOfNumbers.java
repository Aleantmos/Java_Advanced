import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class _2_SumOfNumbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Function<String, IntStream> getIntStream = str ->
                Arrays.stream(str.split(", "))
                .mapToInt(n -> Integer.parseInt(n));

        Function<String, Long> getCnt = str -> {
            return getIntStream.apply(str).count();
        };

        Function<String, Integer> getSum = str -> {
            return getIntStream.apply(str).sum();
        };



        System.out.println("Count = " + getCnt.apply(input));
        System.out.println("Sum = " + getSum.apply(input));
    }
}
