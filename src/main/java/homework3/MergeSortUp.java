package homework3;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSortUp implements MergeSort {

    @Override
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
}
