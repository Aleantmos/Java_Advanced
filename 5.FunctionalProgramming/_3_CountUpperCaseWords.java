import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _3_CountUpperCaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        List<String> upperCaseWords = Arrays.stream(scan.nextLine().split("\\s+"))
                .filter(startsWithUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperCaseWords.size());
        System.out.println(upperCaseWords
                .stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }

    public static Predicate<String> startsWithUpperCase
            = str -> str != null
            && !str.isEmpty()
            && Character.isUpperCase(str.charAt(0));
}
