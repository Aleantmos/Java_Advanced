package shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private List<Animal> animals = new ArrayList<>();
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
    }

    public void add(Animal animal) {
        int shelterSize = animals.size();
        if (shelterSize < capacity) {
            animals.add(animal);
        }
    }

    public boolean remove(String name) {
        boolean animalRemoved = false;
        Animal animalToRemove = null;
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                animalToRemove = animal;
                animalRemoved = true;
                break;
            }
        }
        animals.remove(animalToRemove);
        return animalRemoved;
    }

    public Animal getAnimal(String name, String caretaker) {
        Animal animalToReturn = null;

        for (Animal animal : animals) {
            if (animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)) {
                animalToReturn = animal;
            }
        }
        return animalToReturn;
    }

    public Animal getOldestAnimal() {
        int ageOfOldest = 0;
        Animal oldestAnimal = null;

        for (Animal animal : animals) {
            int ageOfCurrAnimal = animal.getAge();
            if (ageOfCurrAnimal > ageOfOldest) {
                ageOfOldest = ageOfCurrAnimal;
                oldestAnimal = animal;
            }
        }
        return oldestAnimal;
    }

    public int getCount() {
        int animalsCnt = animals.size();
        return animalsCnt;
    }

    public StringBuilder getStatistics() {
        StringBuilder statisticAsString = new StringBuilder();
        statisticAsString.append("The shelter has the following animals:").append(System.lineSeparator());

        for (Animal animal : animals) {
            statisticAsString.append(String.format("%s %s", animal.getName(), animal.getCaretaker()))
                    .append(System.lineSeparator());
        }
        return statisticAsString;
    }
}
