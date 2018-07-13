package homework3;

import java.util.Comparator;

public class ShellSort implements Sort {

    @Override
    public  <T> void sort(T[] array, Comparator<T> comparator){
        int step = 1;
        while (step < array.length / 3){
            step = step * 3 + 1;
        }

        while (step > 0){
            for (int i = step; i < array.length; i += step) {
                if (comparator.compare(array[i - step], array[i]) < 0){
                    continue;
                }
                T currentValue = array[i];
                int newIndex = findIndex(array, i, comparator);
                for (int j = i - step; j >= newIndex; j -= step) {
                    array[j + step] = array[j];
                }
                array[newIndex] = currentValue;
            }
            step = --step / 3;
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
