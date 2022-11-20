package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {

    private String name;
    private int capacity;
    private List<Parrot> data;


    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        int freeSpace = data.size();

        if (freeSpace < this.capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {

        boolean isRemoved = false;

        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {
                this.data.remove(parrot);
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    public Parrot sellParrot(String name) {
        Parrot parrotToSell = null;
        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {
                parrot.setAvailable(false);
                parrotToSell = parrot;
                break;
            }
        }
        return parrotToSell;
    }

    public List<Parrot> sellParrotBySpecies(String species) {

        List<Parrot> parrotsToBySpecies = new ArrayList<>();

        for (Parrot parrot : this.data) {
            if (parrot.getSpecies().equals(species)) {
                parrot.setAvailable(false);
                parrotsToBySpecies.add(parrot);
            }
        }
        return parrotsToBySpecies;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {

        StringBuilder reportFormat = new StringBuilder();
        reportFormat.append("Parrots available at ").append(this.name).append(":").append(System.lineSeparator());

        for (Parrot parrot : this.data) {
            if (parrot.isAvailable()) {
                reportFormat.append(parrot).append(System.lineSeparator());
            }
        }
        return reportFormat.toString().trim();
    }
}
