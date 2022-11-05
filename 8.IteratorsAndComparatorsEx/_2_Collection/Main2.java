package _2_Collection;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        ListIterator2 elements2 = null;
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create":
                    int size = tokens.length;
                    if (size > 1) {
                        elements2 = new ListIterator2(Arrays.copyOfRange(tokens, 1, size));
                    } else {
                        elements2 = new ListIterator2();
                    }
                    break;
                case "Move":
                    System.out.println(elements2.move());
                    break;
                case "HasNext":
                    System.out.println(elements2.iterator().hasNext());
                    break;
                case "Print":
                    elements2.print();
                    break;
                case "PrintAll":
                    elements2.printAll();
                    break;
            }
            input = scan.nextLine();
        }


    }
}
