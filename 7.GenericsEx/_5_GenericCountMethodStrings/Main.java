package _5_GenericCountMethodStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Box5 box5 = new Box5();

        for (int i = 0; i < n; i++) {
            String element = scan.nextLine();
            box5.add(element);
        }
        String elementToCompare = scan.nextLine();
        System.out.println(box5.countGreaterItems(elementToCompare));
    }
}
