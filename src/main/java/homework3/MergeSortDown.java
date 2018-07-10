package homework3;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSortDown implements MergeSort{

    @Override
    public  <T> void sort(T[] array, Comparator<T> comparator){
        T[] arr1 = Arrays.copyOfRange(array, 0, array.length >> 1);
        T[] arr2 = Arrays.copyOfRange(array, array.length >> 1, array.length);
        if (array.length > 2){
            sort(arr1, comparator);
            sort(arr2, comparator);
        }
        merge(array, 0, arr1, arr2, comparator);
    }
}
