import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        if (number == 0) {
            System.out.println("0");
        } else {
            ArrayDeque<Integer> binary = new ArrayDeque<>();

            while (number != 0) {
                int digit = number % 2;
                binary.push(digit);
                number /= 2;
            }

            while (!binary.isEmpty()) {
                System.out.print(binary.pop());
            }
        }
    }
}

