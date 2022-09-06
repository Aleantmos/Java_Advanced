import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _3_PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lines = Integer.parseInt(scan.nextLine());

        Set<String> elements = new TreeSet<>();

        while (lines-- > 0) {
            String[] input = scan.nextLine().split("\\s+");

            for (int i = 0; i < input.length; i++) {
                if(!elements.contains(input[i])) {
                    elements.add(input[i]);
                }
            }
        }
        elements.forEach(element -> System.out.print(element + " "));
    }
}
