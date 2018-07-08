package homework3;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertTrue;

public class SortTest {

    @Test
    public void insertionSortTest() throws Exception {
        sortTest(new InsertionSort());
    }

    @Test
    public void selectionSortTest() throws Exception {
        sortTest(new SelectionSort());
    }

    public void sortTest(Sort sort) throws Exception {

        Integer[] integerArray = new Integer[]{5, 6, 8, 1, 0, 3, 2, 4, 9, 7, 10};
        sort.sort(integerArray, Integer::compare);
        assertTrue(Arrays.equals(integerArray, new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));

        Integer[] reversedIntegerArray = new Integer[]{5, 6, 8, 1, 0, 3, 2, 4, 9, 7, 10};
        sort.sort(reversedIntegerArray, ((Comparator<Integer>)Integer::compare).reversed());
        assertTrue(Arrays.equals(reversedIntegerArray, new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));

        String[] stringArray = new String[]{"a", "abc", "def", "acd", "aaa", "123", "daa", "dab", "dba"};
        sort.sort(stringArray, String::compareTo);
        assertTrue(Arrays.equals(stringArray, new String[]{"123", "a", "aaa", "abc", "acd", "daa", "dab", "dba", "def"}));
    }

}
