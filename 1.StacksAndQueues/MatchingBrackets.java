import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> openIndex = new ArrayDeque<>();

        String expr = scan.nextLine();

        for (int i = 0; i < expr.length(); i++) {
            char curr = expr.charAt(i);
            if (curr == '(') {
                openIndex.push(i);
            } else if (curr == ')') {
                int lastOpenIndex = openIndex.pop();
                String matching = expr.substring(lastOpenIndex, i + 1);
                System.out.println(matching);
            }
        }

    }
}
