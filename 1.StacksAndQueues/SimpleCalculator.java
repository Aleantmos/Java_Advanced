import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] expr = scan.nextLine().split("\\s+");
        ArrayDeque <String> tokens = new ArrayDeque<>();

        Collections.addAll(tokens, expr);

        while (tokens.size() > 1) {
            int firstNumber = Integer.parseInt(tokens.pop());
            String sign = tokens.pop();
            int secondNumber = Integer.parseInt(tokens.pop());

            String result = "" + checkSignAndCalculate(firstNumber,sign,secondNumber);
            tokens.push(result);
        }
        System.out.println(tokens.peek());

    }

    private static int checkSignAndCalculate(int firstNumber, String sign, int secondNumber) {
        int result;

        if("-".equals(sign)) {
            result = divide(firstNumber, secondNumber);
        } else {
            result = sum(firstNumber, secondNumber);
        }
        return result;
    }

    private static int sum(int firstNumber, int secondNumber) {

        int result = firstNumber + secondNumber;
        return result;
    }

    private static int divide(int firstNumber, int secondNumber) {

        int result = firstNumber - secondNumber;
        return result;
    }
}
