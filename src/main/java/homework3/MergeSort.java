package homework3;

import java.util.Comparator;

public interface MergeSort extends Sort{

    default <T> void merge(T[] destArr, int destStart, T[] arr1, T[] arr2, Comparator<T> comparator) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (j < arr1.length && k < arr2.length) {
            destArr[destStart + i++] = comparator.compare(arr1[j], arr2[k]) < 0
                    ? arr1[j++]
                    : arr2[k++];
        }
        while (j < arr1.length) {
            destArr[destStart + i++] = arr1[j++];
        }
        while (k < arr2.length) {
            destArr[destStart + i++] = arr2[k++];
        }
    }

}
