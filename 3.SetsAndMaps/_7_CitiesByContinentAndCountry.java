import java.util.*;
import java.util.stream.Collectors;

public class _7_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int linesToRead = Integer.parseInt(scan.nextLine());

        Map<String,Map<String, List<String>>> places = new LinkedHashMap<>();

        while (linesToRead-- > 0) {
            String[] input = scan.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            places.putIfAbsent(continent, new LinkedHashMap<>());
            places.get(continent).putIfAbsent(country, new ArrayList<>());
            places.get(continent).get(country).add(city);
        }
        places.entrySet().stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ":");
                    entry.getValue()
                            .forEach((k, v) -> {
                                System.out.printf(" %s -> %s%n", k,
                                        v.stream().collect(Collectors.joining(", ")));
                            });
                });
    }
}
