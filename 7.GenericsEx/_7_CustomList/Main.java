package _7_CustomList;

import java.util.Scanner;

public class Main {
    //ToDo: finish 9, 10, 11
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Data data = new Data();

        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];


            switch (command) {
                case "Add":
                    String aVar = tokens[1];
                    data.add(aVar);
                    break;
                case "Remove":
                    int aVarIndex = Integer.parseInt(tokens[1]);
                    data.remove(aVarIndex);
                    break;
                case "Contains":
                    aVar = tokens[1];
                    System.out.println(data.contains(aVar));
                    break;
                case "Swap":
                    int aVarIndex1 = Integer.parseInt(tokens[1]);
                    int aVarIndex2 = Integer.parseInt(tokens[2]);
                    data.swap(aVarIndex1, aVarIndex2);
                    break;
                case "Greater":
                    String greaterThan = tokens[1];
                    System.out.println(data.greater(greaterThan));
                    break;
                case "Max":
                    System.out.println(data.getMax());
                    break;
                case "Min":
                    System.out.println(data.getMin());
                    break;
                case "Sort":
                    Sorter.sort(data);
                    break;
                case "Print":
                    System.out.println(data);
                    break;
            }
            input = scan.nextLine();
        }
    }
}
