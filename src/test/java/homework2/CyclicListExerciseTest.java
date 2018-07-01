package homework2;

import org.junit.Test;

import static homework2.CyclicListExercise.isCyclic;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CyclicListExerciseTest {

    @Test
    public void isCyclicTest() {
        assertFalse(isCyclic(new CyclicListExercise.CyclicList(100, false)));
        assertTrue(isCyclic(new CyclicListExercise.CyclicList(100, true)));
        assertFalse(isCyclic(new CyclicListExercise.CyclicList(10000, false)));
        assertTrue(isCyclic(new CyclicListExercise.CyclicList(10000, true)));
        assertFalse(isCyclic(new CyclicListExercise.CyclicList(10_000_000, false)));
        assertTrue(isCyclic(new CyclicListExercise.CyclicList(10_000_000, true)));
    }
}