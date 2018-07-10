package homework3;

import java.util.Comparator;

public class SelectionSort implements Sort {

    @Override
    public <T> void sort(T[] array, Comparator<T> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            int indexOfMin = i;
            for (int j = i; j < array.length; j++) {
                if (comparator.compare(array[j], array[indexOfMin]) < 0) {
                    indexOfMin = j;
                }
            }
            T tmp = array[indexOfMin];
            array[indexOfMin] = array[i];
            array[i] = tmp;
        }
    }
}
