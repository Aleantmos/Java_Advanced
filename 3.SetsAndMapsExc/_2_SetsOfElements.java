import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _2_SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] lengths = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();


        Set<String> first = new LinkedHashSet<>();
        Set<String> second = new LinkedHashSet<>();

        int lines = lengths[0] + lengths[1];
        int cnt = 0;
        while (cnt < lines) {
            String input = scan.nextLine();
            if (cnt < lengths[0]) {
                first.add(input);
            } else {
                second.add(input);
            }
            cnt++;
        }
        first.retainAll(second);
        first.forEach(number -> System.out.print(number + " "));
    }
}
