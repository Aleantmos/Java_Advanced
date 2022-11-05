package _1_ListIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        ListIterator elements = new ListIterator();

        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create":
                    int size = tokens.length;
                    if (size > 1) {
                        elements = new ListIterator(Arrays.copyOfRange(tokens, 1, size));
                    } else {
                        elements = new ListIterator();
                    }
                    break;
                case "Move":
                    System.out.println(elements.move());
                    break;
                case "HasNext":
                    System.out.println(elements.hasNext());
                    break;
                case "Print":
                    elements.printElement();
            }
            input = scan.nextLine();
        }
    }
}
