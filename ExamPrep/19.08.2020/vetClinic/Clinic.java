package vetClinic;

import java.util.ArrayList;

public class Clinic {
    private ArrayList<Pet> clinic;
    private int capacity;

    public Clinic(int capacity) {
        this.clinic = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        int size = clinic.size();
        if (this.capacity > size) {
            clinic.add(pet);
        }
    }

    public boolean remove(String name) {
        boolean isRemoved = false;

        for (Pet pet : this.clinic) {
            if (pet.getName().equals(name)) {
                this.clinic.remove(pet);
                isRemoved = true;
                break;
            }
        }
        return isRemoved;
    }

    public Pet getPet(String name, String owner) {
        Pet getThePet = null;

        if (!clinic.isEmpty()) {
            for (Pet pet : this.clinic) {
                if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                    getThePet = pet;
                    break;
                }
            }
        }
        return getThePet;
    }
    public Pet getOldestPet() {
        int oldest = 0;
        Pet oldestPet = null;

        if (!this.clinic.isEmpty()) {
            for (Pet pet : this.clinic) {
                if (pet.getAge() > oldest) {
                    oldest = pet.getAge();
                    oldestPet = pet;
                }
            }
        }
        return oldestPet;
    }

    public int getCount() {
        int size = this.clinic.size();
        return size;
    }

    public String getStatistics() {
        StringBuilder result = new StringBuilder();
        result.append("The clinic has the following patients:").append(System.lineSeparator());
        if (!this.clinic.isEmpty()) {
            for (Pet pet : clinic) {
                result.append(String.format("%s %s", pet.getName(), pet.getOwner())).append(System.lineSeparator());
            }
        }
        return result.toString();
    }
}
