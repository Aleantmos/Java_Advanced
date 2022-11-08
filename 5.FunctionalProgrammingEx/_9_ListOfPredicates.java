import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _9_ListOfPredicates {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Set<Integer> numbersSet = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e))
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));

        Predicate<Integer> isDivisible = num -> {
            for (Integer divider : numbersSet) {
                if (num % divider != 0) {
                    return false;
                }
            }
            return true;
        };
        for (int i = 1; i <= n; i++) {
            if (isDivisible.test(i)) {
                System.out.print(i + " ");
            }

        }
    }
}
