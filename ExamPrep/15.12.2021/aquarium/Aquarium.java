package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.fishInPool = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
        this.size = size;
    }


    public int getFishInPool() {
        return fishInPool.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public void add(Fish fish) {

        boolean fishWithSameNameFound = false;

        if(this.fishInPool.size() < this.capacity) {
            for (Fish currFish : fishInPool) {
                if (currFish.getName().equals(fish.getName())) {
                    fishWithSameNameFound = true;
                    break;
                }
            }
        }
        if (!fishWithSameNameFound) {
            this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {

        boolean fishRemoved = false;

        for (Fish currFish : this.fishInPool) {
            if (currFish.getName().equals(name)) {
                fishInPool.remove(currFish);
                fishRemoved = true;
                break;
            }
        }
        return fishRemoved;
    }

    public Fish findFish(String name) {

        Fish fishToFind = null;

        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                fishToFind = fish;
            }
        }
        return fishToFind;
    }

    public String report() {
        StringBuilder reportFormat = new StringBuilder();

        reportFormat.append(String.format("Aquarium: %s ^ Size: %s%n", getName(), getSize()));

        for (Fish fish : this.fishInPool) {
            reportFormat.append(fish.toString() + System.lineSeparator());
        }
        return reportFormat.toString();
    }
}
