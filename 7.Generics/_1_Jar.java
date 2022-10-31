package _1_Jar;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {

    private Deque<T> storage;

    public Jar() {
        this.storage = new ArrayDeque<>();
    }

    public void add(T element) {
        this.storage.push(element);
    }

    public T remove() {
        return this.storage.pop();
    }
}
