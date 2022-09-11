import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean isBalanced = true;

        String input = scan.nextLine();

        ArrayDeque<Character> openParent = new ArrayDeque<>();


        for (int i = 0; i < input.length() / 2; i++) {
            char curr = input.charAt(i);
            openParent.push(curr);
        }
        for (int i = input.length()/2; i < input.length(); i++) {
            if (openParent.isEmpty()) {
                isBalanced = false;

                break;
            }
            switch (openParent.pop()) {
                case '{':
                    if (input.charAt(i) != '}') {
                        isBalanced = false;
                    }
                    break;
                case '[':
                    if (input.charAt(i) != ']') {
                        isBalanced = false;
                    }
                    break;
                case '(':
                    if (input.charAt(i) != ')') {
                        isBalanced = false;
                    }
                    break;
            }
            if (!isBalanced) {
                break;
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
