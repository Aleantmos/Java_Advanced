package _2_Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListIterator2 implements Iterable<String> {

    private List<String> elements;
    private int currIndex;

    public ListIterator2(String...elements) {
        this.elements = Arrays.asList(elements);
        currIndex = 0;
    }

    public boolean move() {
        if (elements.iterator().hasNext()) {
            currIndex++;
            return true;
        }
        return false;
    }

    public void print() {
        if (elements.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            String element = elements.get(currIndex);
            System.out.println(element);
        }
    }

    public void printAll() {
        if (elements.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println();
            int size = this.elements.size();

            for (int i = 0; i < size; i++) {
                String element = this.elements.get(i);
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int next = currIndex + 1;
            @Override
            public boolean hasNext() {
                int size = elements.size() - 2;
                if (next <= size) {
                    return true;
                }
                return false;
            }

            @Override
            public String next()  {
                String element = elements.get(next);
                return element;
            }
        };
    }
}
