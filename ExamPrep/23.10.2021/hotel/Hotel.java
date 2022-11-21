package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roaster = new ArrayList<>();


    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void add(Person person) {
        int freeSpace = roaster.size();

        if (freeSpace < capacity) {
            this.roaster.add(person);
        }
    }

    public boolean remove(String name) {
        boolean isRemoved = false;

        for (Person person : roaster) {
            if (person.getName().equals(name)) {
                roaster.remove(person);
                isRemoved = true;
                break;
            }
        }
        return isRemoved;
    }

    public Person getPerson(String name, String hometown) {
        Person personToGet = null;

        for (Person person : roaster) {
            if (person.getName().equals(name) && person.getHometown().equals(hometown)) {
                personToGet = person;
                break;
            }
        }
        return personToGet;
    }

    public int getCount() {
        int size = roaster.size();
        return size;
    }

    public String getStatistics() {
        StringBuilder statisticFormat = new StringBuilder();
        statisticFormat.append(String.format("The people in the hotel %s are:", getName())).append(System.lineSeparator());

        for (Person person : roaster) {
            statisticFormat.append(person.toString()).append(System.lineSeparator());
        }
        return statisticFormat.toString();
    }
}
