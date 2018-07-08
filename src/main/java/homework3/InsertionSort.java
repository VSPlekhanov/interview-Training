package homework3;

import java.util.Comparator;

public class InsertionSort implements Sort{

    public  <T> void sort(T[] array, Comparator<T> comparator){
        for (int i = 1; i < array.length ; i++) {
            if (comparator.compare(array[i - 1], array[i]) < 0){
                continue;
            }
            T currentValue = array[i];
            int newIndex = findIndex(array, i, comparator);
            for (int j = i - 1; j >= newIndex; j--) {
                array[j + 1] = array[j];
            }
            array[newIndex] = currentValue;
        }
    }

    static private <T> int findIndex(T[] array, int currentIndex, Comparator<T> comparator){
        int i = currentIndex;
        while (i > 0){
            if (comparator.compare(array[--i], array[currentIndex]) < 0){
                return i + 1;
            }
        }
        return i;
    }
}