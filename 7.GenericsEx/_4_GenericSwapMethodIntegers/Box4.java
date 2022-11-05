package _4_GenericSwapMethodIntegers;

import java.util.ArrayList;
import java.util.List;

public class Box4<T> {
    private List<T> elements;

    public Box4() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T temp = elements.get(secondIndex);
        elements.set(secondIndex, elements.get(firstIndex));
        elements.set(firstIndex, temp);
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : elements) {
            sb.append(String.format("%s: %s%n",
                    element.getClass().getName(),
                    element));
        }
        return sb.toString();
    }
}
