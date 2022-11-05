package _7_CustomList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Data <T extends Comparable> {
    private List<T> storage;

    public Data() {
        this.storage = new ArrayList<>();
    }

    //void add(T element)
    public void add(T element){
        storage.add(element);
    }

    //T remove(int index)
    public void remove(T element) {
        storage.remove(element);
    }

    //Contains {element} - Prints if the list contains the given element
    public boolean contains(T element) {
        return storage.contains(element);
    }

    //Swaps the elements at the given indexes.
    public void swap(int firstIndex, int secondIndex) {
        T temp = storage.get(secondIndex);
        storage.set(secondIndex, storage.get(firstIndex));
        storage.set(firstIndex, temp);
    }

    //Counts the elements that are greater than the given element and prints their count
    public long greater(T element){
        return storage.stream()
                .filter(t -> t.compareTo(element) > 0)
                .count();
    }

    //Prints the maximum element in the list
    public T getMax() {
       return this.storage
               .stream()
               .max(T::compareTo)
               .orElse(null);
    }
    //Prints the minimum element in the list
    public T getMin() {
         return storage
                .stream()
                .min(T::compareTo)
                .orElse(null);
    }

    //Get Size
    public int getSize() {
        return this.storage.size();
    }

    public T getElementOfStorage(int index) {
        return storage.get(index);
    }

    @Override
    public String toString() {
        return storage
                .stream()
                .map(t -> t + "")
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
