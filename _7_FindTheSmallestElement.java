import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _7_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());


        Function<List<Integer>, Integer> getIndexOfMinElement =
                list -> list.lastIndexOf(list.stream().min(Integer::compare).get());

        System.out.println(getIndexOfMinElement.apply(numbers));
    }
}
