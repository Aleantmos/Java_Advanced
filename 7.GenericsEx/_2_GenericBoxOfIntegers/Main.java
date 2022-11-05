package _2_GenericBoxOfIntegers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Box2 box2 = new Box2();

        for (int i = 0; i < n; i++) {
            int element = Integer.parseInt(scan.nextLine());
            box2.add(element);
        }

        System.out.println(box2);
    }
}
