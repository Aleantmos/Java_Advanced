import java.util.ArrayList;
import java.util.List;

public class Habitat {

    private List<Elephant> data;
    private long capacity;

    public Habitat(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Elephant elephant) {

        long spaceTaken = this.data.size();

        if (spaceTaken < this.capacity) {
            data.add(elephant);
        }
    }

    public boolean remove(String name) {
        boolean isRemoved = false;

        for (Elephant elephant : this.data) {
            if (elephant.getName().equals(name)) {
                this.data.remove(elephant);
                isRemoved = true;
                break;
            }
        }
        return isRemoved;
    }

    public Elephant getElephant(String retiredFrom) {

        Elephant elephantToGet = null;
        for (Elephant elephant : this.data) {
            if (elephant.getRetiredFrom().equals(retiredFrom)) {
                elephantToGet = elephant;
            }
        }
        return elephantToGet;
    }

    public Elephant getOldestElephant() {
        long oldest = 0;
        Elephant oldestElephant = null;

        for (Elephant elephant : this.data) {
            if (elephant.getAge() >= oldest) {
                oldest = elephant.getAge();
                oldestElephant = elephant;
                break;
            }
        }
        return oldestElephant;
    }

    public int getAllElephants() {
        return this.data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Saved elephants in the park:").append(System.lineSeparator());
        for (Elephant elephant : this.data) {
            sb.append(String.format("%s came from: %s", elephant.getName(), elephant.getRetiredFrom()))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
