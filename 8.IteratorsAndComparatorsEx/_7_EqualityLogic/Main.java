package _7_EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        //Todo - check this once more
        Scanner scan = new Scanner(System.in);

        Set<Person> treeSet = new TreeSet<>();
        Set<Person> hashSet = new HashSet<>();

        int cnt = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < cnt; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            Person person = createPerson(tokens);

            treeSet.add(person);
            hashSet.add(person);

        }
        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }

    private static Person createPerson(String[] tokens) {
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        Person person = new Person(name, age);

        return person;
    }
}
