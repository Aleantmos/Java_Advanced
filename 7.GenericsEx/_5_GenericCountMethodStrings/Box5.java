package _5_GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class Box5 <T extends Comparable<T>>{
    private List<T> elements;

    public Box5() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public long countGreaterItems(T element) {
        return elements.stream()
                .filter(itemFromBox ->
                        itemFromBox.compareTo(element) > 0)
                .count();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element: elements) {
            sb.append(String.format("%s: %s%n",
                    element.getClass().getName(),
                    element));
        }
        return sb.toString();
    }
}
