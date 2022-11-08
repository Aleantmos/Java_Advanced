import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _5_FilterByAge {
    public static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Function<String, Person> parsePerson = str -> {
            String[] tokens = str.split(", ");
            return new Person(tokens[0], Integer.parseInt(tokens[1]));
        };

        List <Person> people = new ArrayList<>();

        while (n-- > 0) {
            people.add(parsePerson.apply(scan.next()));
        }

        String condition = scan.nextLine();
        int ageCondition = Integer.parseInt(scan.nextLine());
        String format = scan.nextLine();

        people = condition.equals("older") ?
                filterPeople(people, p -> p.age >= ageCondition)
                : filterPeople(people, p -> p.age < ageCondition);



        System.out.println(formatPeople(people, getFormatterFunction(format), System.lineSeparator()));
    }

    private static Function<Person, String> getFormatterFunction(String type) {
        switch (type) {
            case "name":
                return p -> p.name;

            case "age":
                return p -> String.valueOf(p.age);

            case "name age":
                return p -> p.name + " - " + p.age;
            default:
                throw new IllegalStateException(
                        "Unknown format type " + type);
        }
    }


    public static String formatPeople (Collection <Person> people,
                                       Function<Person, String> formatter, String delimiter) {

        return people.stream()
                .map(p -> formatter.apply(p))
                .collect(Collectors.joining(delimiter));
    }

    public static List<Person> filterPeople (Collection<Person> people,
                                             Predicate<Person> predicate) {
        return people.stream()
                .filter(predicate)
                .collect((Collectors.toList()));
    }
}
