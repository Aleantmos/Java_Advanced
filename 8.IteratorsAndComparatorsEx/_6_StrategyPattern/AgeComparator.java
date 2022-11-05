package _6_StrategyPattern;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person firstPerson, Person secondPerson) {

        int result = Integer.compare(firstPerson.getAge(), secondPerson.getAge());
        return result;
    }
}
