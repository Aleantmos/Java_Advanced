import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _11_ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> guests = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Map<String, Predicate<String>> predicates = new HashMap<>();
        String line;

        while (!"Print".equals(line = scan.nextLine())) {
            String[] tokens = line.split(";");
            String predicateName = tokens[1] + tokens[2];
            if(tokens[0].contains("Add filter")) {
                Predicate<String> predicate = getPredicate(tokens);
                predicates.put(predicateName, predicate);
            } else {
                predicates.remove(predicateName);
            }
        }
        guests.stream().filter(guest -> {
            boolean isValid = true;
            for (Predicate<String> predicate : predicates.values()) {
                if (predicate.test(guest)) {
                    isValid = false;
                    break;
                }
            }
            return isValid;
        }).forEach(e -> System.out.print(e + " "));
    }
    public static Predicate <String> getPredicate (String[] tokens) {
        Predicate<String> predicate = null;

        if (tokens[1].equals("Starts with")) {
            predicate = name -> name.startsWith(tokens[2]);
        } else if (tokens[1].equals("Ends with")) {
            predicate = name -> name.endsWith(tokens[2]);
        } else if (tokens[1].equals("Length")) {
            predicate = name -> name.length() == Integer.parseInt(tokens[2]);
        } else {
            predicate = name -> name.contains(tokens[2]);
        }
        return predicate;
    }
}
