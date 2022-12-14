import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _8_CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(num -> Integer.parseInt(num))
                .collect(Collectors.toList());

        Comparator<Integer> comparator = (num1, num2) -> {
          if (num1 % 2 == 0 && num2 % 2 != 0) {
              return -1;
          } else if (num1 % 2 != 0 && num2 % 2 == 0){
              return 1;
          }
          return num1.compareTo(num2);
        };

        numbers.stream()
                .sorted(comparator)
                .forEach(e -> System.out.print(e + " "));
    }
}
