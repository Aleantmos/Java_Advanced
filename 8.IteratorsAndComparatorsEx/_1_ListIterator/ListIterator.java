package _1_ListIterator;

import java.util.Arrays;
import java.util.List;

public class ListIterator  {
    private List<String> elements;
    private int currentIndex;

    public ListIterator(String... data) {
        this.elements = Arrays.asList(data);
        currentIndex = 0;
    }



    public boolean move() {
        if (hasNext()) {
            currentIndex++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        int size = elements.size() - 1;
        if (currentIndex < size) {
            return true;
        }
        return false;
    }

    public void printElement() {
        if (elements.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            String element = this.elements.get(currentIndex);
            System.out.println(element);
        }
    }
}
