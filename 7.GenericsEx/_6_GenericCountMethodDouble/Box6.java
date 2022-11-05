package _6_GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;

public class Box6 <T extends Comparable> {
    private List<T> elements;

    public Box6() {
        this.elements = new ArrayList<>();
    }

    public long getGreaterOf(double element) {
        return elements.stream()
                .filter(num -> num.compareTo(element) > 0)
                .count();
    }

    public void add(T element) {
        elements.add(element);
    }
}
