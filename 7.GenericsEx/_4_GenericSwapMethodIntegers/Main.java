package _4_GenericSwapMethodIntegers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cnt = Integer.parseInt(scan.nextLine());
        Box4 box4 = new Box4();

        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(scan.nextLine());
            box4.add(num);
        }

        String[] indices = scan.nextLine().split("\\s+");

        int firstIndex = Integer.parseInt(indices[0]);
        int secondIndex = Integer.parseInt(indices[1]);

        box4.swap(firstIndex, secondIndex);
        System.out.println(box4);
    }
}
