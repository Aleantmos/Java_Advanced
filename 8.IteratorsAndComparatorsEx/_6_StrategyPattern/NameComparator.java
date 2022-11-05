package _6_StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person first, Person second) {
        int firstNameLength = first.getName().length();
        int secondNameLength = second.getName().length();

        int result = Integer.compare(firstNameLength, secondNameLength);

        if (result == 0) {
            char firstPersonChar = Character.toLowerCase(first.getName().charAt(0));
            char secondPersonChar = Character.toLowerCase(second.getName().charAt(0));

            return Character.compare(firstPersonChar, secondPersonChar);
        }
        return result;
    }
}
