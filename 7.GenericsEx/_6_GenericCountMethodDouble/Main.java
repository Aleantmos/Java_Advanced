package _6_GenericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cnt = Integer.parseInt(scan.nextLine());
        Box6 box = new Box6();
        for (int i = 0; i < cnt; i++) {
            double num = Double.parseDouble(scan.nextLine());
            box.add(num);
        }

        double magicNum = Double.parseDouble(scan.nextLine());

        double result = box.getGreaterOf(magicNum);
        System.out.printf("%.0f", result);
    }
}
