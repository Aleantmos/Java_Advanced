package _2_GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator<T> {
    public static <T> T[] createArray(int length, T item) {
        @SuppressWarnings("unchecked")
        T[] arr = (T[]) Array.newInstance(item.getClass(), length);

        for (int i = 0; i < length; i++) {
            arr[i] = item;
        }
        return arr;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] createArray(Class<T> clazz, int length, T item) {
        T[] arr = (T[]) Array.newInstance(clazz, length);

        Arrays.fill(arr, item);


        return arr;
    }
}
