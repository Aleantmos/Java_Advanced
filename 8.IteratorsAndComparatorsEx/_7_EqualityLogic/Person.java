package _7_EqualityLogic;


import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }


    @Override
    public int compareTo(Person other) {
        System.out.println();
        if (this.getName().equals(other.getName())) {
            return Integer.compare(this.getAge(), other.getAge());
        }
        return this.getName().compareTo(other.getName());
    }

    @Override
    public boolean equals(Object o) {
        System.out.println();
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        System.out.println();
        return Objects.hash(name, age);
    }

}
