package _3_GenericSwapMethodStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        theBox<String> box = new theBox<>();

        for (int i = 0; i < num; i++) {
            String element = scan.nextLine();

            box.add(element);
        }

        String[] indices = scan.nextLine().split("\\s+");

        int firstIndex = Integer.parseInt(indices[0]);
        int secondIndex = Integer.parseInt(indices[1]);
        box.swap(firstIndex, secondIndex);
        System.out.println(box);
    }
}
