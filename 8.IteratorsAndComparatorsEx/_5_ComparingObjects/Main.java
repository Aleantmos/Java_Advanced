package _5_ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        int equalCnt = 0;
        int notEqualCnt = 0;
        int sumOfPeople = 0;

        String input;

        while (!"END".equals(input = scan.nextLine())) {
            String[] tokens = input.split("\\s+");

            Person person = setPerson(tokens);
            people.add(person);
        }

        int magicNum = Integer.parseInt(scan.nextLine());

        Person personToCompare = people.get(magicNum - 1);

        sumOfPeople = people.size();
        for (Person otherPerson : people) {
            if (personToCompare.compareTo(otherPerson) == 0) {
                equalCnt++;
            } else {
                notEqualCnt++;
            }
        }

        if (equalCnt == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", equalCnt, notEqualCnt, sumOfPeople);
        }
    }

    private static Person setPerson(String[] tokens) {
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        String town = tokens[2];

        Person person = new Person(name, age, town);
        return person;
    }
}
