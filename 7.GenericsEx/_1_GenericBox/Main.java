package _1_GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Box<Integer> box = new Box();

        for (int i = 0; i < n; i++) {
            Integer element = Integer.parseInt(scan.nextLine());
            box.add(element);
        }

        System.out.println(box);
    }
}