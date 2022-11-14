package _8_FamilyTree1;

import java.util.LinkedHashMap;
import java.util.Map;

public class Person {
    private static int id;
    String name;
    String birthday;
    Map<String, Person> parents = new LinkedHashMap<>();
    Map<String, Person> children = new LinkedHashMap<>();


    public Person(String name, String birthday) {
        id++;
        this.name = name;
        this.birthday = birthday;
    }

    public Person(String input) {
        id++;
        if (input.contains("/")) {
            this.birthday = input;
        } else {
            this.name = input;
        }
    }

    public void addChild (Person child) {
        this.children.putIfAbsent(child.getName(), child);
    }
    public void addParent (Person parent) {
        this.parents.putIfAbsent(parent.getName(), parent);
    }

    public String getName() {
        return this.name;
    }

    public int getID() {
        return this.id = id;
    }

   // public void setName() {
   //     this.name = name;
   // }
}
