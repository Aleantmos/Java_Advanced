package _8_FamilyTree1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//Todo - finish (no idea whats happening)
        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, String> birthdays = new LinkedHashMap<>();

        String root = scan.nextLine();

        Person person = new Person(root);
        if (root.contains("/")) {
            people.put(String.valueOf(person.getID()), person);
            birthdays.put(root, String.valueOf(person.getID()));
        } else {
            people.put(root, person);
        }

        String input;

        while (!"End".equals(input = scan.nextLine())) {
            String[] tokens = input.split("\\s+");

            if (tokens.length == 5) {
                String parentName = tokens[0] + " " + tokens[1];
                String childName = tokens[3] + " " + tokens[4];

                Person parent = new Person(parentName);
                Person child = new Person(childName);

                people.putIfAbsent(parentName, parent);
                people.putIfAbsent(childName, child);

                people.get(parentName).addChild(child);
                people.get(childName).addParent(parent);
            } else if (tokens.length == 4) {
                //"{FirstName} {LastName} – {day/month/year}"
                if(tokens[2].equals("-")) {
                    String parentName = tokens[0] + " " + tokens[1];
                    String childBirthday = tokens[3];

                    Person parent = new Person (parentName);
                    people.putIfAbsent(parentName, parent);

                    Person child = new Person(childBirthday);
                    if (birthdays.containsKey(childBirthday)) {
                        child = people.get(birthdays.get(childBirthday));
                    } else {
                        people.put(String.valueOf(child.getID()), child);
                        birthdays.put(childBirthday, String.valueOf(child.getID()));
                    }
                    child.addParent(people.get(parentName));
                    people.get(parentName).addParent(child);
                }
            } else {
                //"{day/month/year} – {FirstName} {LastName}"
                String parentBirthday = tokens[0];
                String childName = tokens[2] + " " + tokens[3];
                Person child = new Person(childName);
                people.putIfAbsent(childName, child);

                Person parent = new Person(parentBirthday);

                if (birthdays.containsKey(parentBirthday)) {
                    parent = people.get(birthdays.get(parentBirthday));
                } else {
                    people.put(String.valueOf(parent.getID()), parent);
                    birthdays.put(parentBirthday, String.valueOf(parent.getID()));
                }
                parent.addChild(people.get(childName));
                people.get(childName).addParent(parent);
            }
        }
    }
}
