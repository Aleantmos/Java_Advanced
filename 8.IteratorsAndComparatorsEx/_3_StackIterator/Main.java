package _3_StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Stack currentStack = new Stack();

        String input = scan.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+|,\\s+");
            String command = tokens[0];

            switch (command) {
                case "Push":
                    currentStack.push(Arrays.copyOfRange(tokens,1, tokens.length));
                    break;
                case "Pop":
                    try {
                        currentStack.pop();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }

            input = scan.nextLine();
        }

        for (int i = 0; i < 2; i++) {
            Stack.print(currentStack);
        }
    }
}
