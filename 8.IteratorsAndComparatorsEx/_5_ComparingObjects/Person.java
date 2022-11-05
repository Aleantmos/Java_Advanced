package _5_ComparingObjects;

public class Person implements Comparable<Person> {

    //name, age, town
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }
    @Override
    public int compareTo(Person other) {
        if(this.name.equals(other.getName())) {
            if(this.age == other.getAge()) {
                return this.town.compareTo(other.getTown());
            } return Integer.compare(this.age, other.getAge());
        } return this.name.compareTo(other.getName());
    }
}
