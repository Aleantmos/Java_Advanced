package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {

    private int capacity;
    private List<Pet> pets;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.pets = new ArrayList<>();
    }

    public void add(Pet pet) {
        int freeSpace = pets.size();

        if (freeSpace < capacity) {
            pets.add(pet);
        }
    }

    public boolean remove(String name) {
        boolean petRemoved = false;

        for (Pet pet : pets) {
            if (pet.getName().equals(name)) {
                pets.remove(pet);
                petRemoved = true;
                break;
            }
        }
        return petRemoved;
    }

    public Pet getPet(String name, String owner) {
        Pet petToReturn = null;

        for (Pet pet : pets) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                petToReturn = pet;
                break;
            }
        }
        return petToReturn;
    }

    public int getCount() {
        return pets.size();
    }

    public String getStatistics() {
        StringBuilder salonFormat = new StringBuilder();

        salonFormat.append("The grooming salon has the following clients:").append(System.lineSeparator());

        for (Pet pet : pets) {
            salonFormat.append(String.format("%s %s", pet.getName(), pet.getOwner())).append(System.lineSeparator());
        }
        return salonFormat.toString();
    }
}
