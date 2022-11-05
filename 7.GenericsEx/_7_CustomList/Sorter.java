package _7_CustomList;

public class Sorter {
    public static <T extends Comparable<T>> void sort(Data<T> storage) {
        int sizeOfStorage = storage.getSize();
        for (int i = 0; i < sizeOfStorage; i++) {
            T element1 = storage.getElementOfStorage(i);
            for (int j = i + 1; j <= sizeOfStorage; j++) {
                T element2 = storage.getElementOfStorage(j);
                if(element1.compareTo(element2) < 0) {
                    storage.swap(i, j);
                }
            }
        }
    }
}
