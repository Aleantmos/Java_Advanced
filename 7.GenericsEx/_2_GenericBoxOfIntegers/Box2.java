package _2_GenericBoxOfIntegers;

import java.util.ArrayList;
import java.util.List;

public class Box2 <T> {
    private List<T> elements;

    public Box2() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : elements) {
            sb.append(String.format("%s: %s%n",
                    element.getClass().getName(),
                    element.toString()));
        }
        return sb.toString();
    }
}
