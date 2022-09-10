import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class _6_ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String[] input = scan.nextLine().split(", ");

        Map<String,Map <String, Double>> shops = new TreeMap<>();

        while (!input[0].equals("Revision")) {
            String shop = input[0];
            String product = input[1];
            double price = Double.parseDouble(input[2]);

            if(!shops.containsKey(shop)) {
                shops.put(shop, new LinkedHashMap<>());
            }
            shops.get(shop).put(product, price);

            input = scan.nextLine().split(", ");
        }

        System.out.println(shops.entrySet()
                .stream()
                .map(shop ->
                        String.format("%s->%n%s", shop.getKey(),
                                shop.getValue()
                                        .entrySet()
                                        .stream()
                                        .map(product ->
                                                String.format("Product: %s, Price: %.1f",
                                                        product.getKey(),
                                                        product.getValue()))
                                .collect(Collectors.joining(System.lineSeparator()))))
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
