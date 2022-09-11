import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> nums = new ArrayDeque<>();

        String[] numbersAsString = scan.nextLine().split(" ");
        for (int i = 0; i < numbersAsString.length; i++) {
            nums.push(numbersAsString[i]);
        }

        for (String num : nums) {
            System.out.print(num + " ");

        }

    }
}
