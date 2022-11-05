package _3_GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class theBox <T>{
    private List<T> values;

    public theBox() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T temp = values.get(firstIndex);
        values.set(firstIndex, values.get(secondIndex));
        values.set(secondIndex, temp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : values) {
            sb.append(String.format("%s: %s%n",
                    value.getClass().getName(),
                    values.toString()));
        }
        return sb.toString();
    }
}
