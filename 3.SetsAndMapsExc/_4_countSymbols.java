import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _4_countSymbols {
    public static void main(String[] args) {
        //todo 80/100
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Map<Character, Integer> symbols = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {

            char charToAdd = input.charAt(i);
            symbols.putIfAbsent(charToAdd, 0);
            symbols.put(charToAdd, symbols.get(charToAdd) + 1);

        }
        symbols.forEach((k, v) -> System.out.printf("%s: %d time/s%n", k, v));








        //String[] input = scan.nextLine().split("");
        //int cnt = 0;
        //Map<String, Integer> elements = new TreeMap<>();
        //for (int i = 0; i < input.length; i++) {
        //    elements.putIfAbsent(input[i], cnt);
        //    elements.put(input[i], elements.get(input[i]) + 1);
//
        //}
//
        //elements.forEach((k,v) -> System.out.printf("%s: %d time/s%n", k, v));
    }
}
