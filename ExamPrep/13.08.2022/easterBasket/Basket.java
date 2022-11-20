package easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket (String material, int capacity) {
        this.data = new ArrayList<>();
        this.material = material;
        this.capacity = capacity;
    }

    public void addEgg(Egg egg) {

        int freeSpace = this.data.size();

        if (freeSpace < this.capacity) {
            data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        boolean isRemoved = false;

        for (Egg egg : data) {
            if (egg.getColor().equals(color)) {
                isRemoved = true;
                data.remove(egg);
                break;
            }
        }
        return isRemoved;
    }

    public Egg getStrongestEgg() {
        int strongest = 0;
        Egg strongestEgg = null;

        for (Egg egg : this.data) {
            if (egg.getStrength() > strongest) {
                strongest = egg.getStrength();
                strongestEgg = egg;
            }
        }
        return strongestEgg;
    }

    public Egg getEgg(String color) {

        Egg eggToReturn = null;

        for (Egg egg : this.data) {
            if (egg.getColor().equals(color)) {
                eggToReturn = egg;
                break;
            }
        }
        return eggToReturn;
    }

    public int getCount() {
        int eggs = this.data.size();
        return eggs;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s basket contains:%n", this.material));

        this.data.forEach(egg -> sb.append(egg.toString()).append(System.lineSeparator()));

        return sb.toString();
    }
}
