package homework3;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSortUp implements Sort {
    public <T> void sort(T[] array, Comparator<T> comparator) {
        int sizeOfOnePeace = 1;
        while (sizeOfOnePeace < array.length << 1) {
            int i = 0;
            int lengthOfDivisiblePart = array.length - array.length % (sizeOfOnePeace << 1);
            while (i < lengthOfDivisiblePart) {
                merge(array, i,
                        Arrays.copyOfRange(array, i, i + sizeOfOnePeace),
                        Arrays.copyOfRange(array, i + sizeOfOnePeace, i + (sizeOfOnePeace << 1)),
                        comparator);
                i += sizeOfOnePeace << 1;
            }
            if (array.length - lengthOfDivisiblePart > sizeOfOnePeace) {
                merge(array, i, Arrays.copyOfRange(array, i, i + sizeOfOnePeace),
                        Arrays.copyOfRange(array, i + sizeOfOnePeace, array.length), comparator);
            }
            sizeOfOnePeace = sizeOfOnePeace << 1;
        }
    }

    private <T> void merge(T[] destArr, int destStart, T[] arr1, T[] arr2, Comparator<T> comparator) {
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
