package homework2;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class LinkedQueueTest {
    private Queue<String> queue;
    private List<String> data;

    @Before
    public void before() {
        data = Arrays.asList("first", "second", "third", "fourth", "fifth");
        queue = new LinkedQueue<>();
        for (String aData : data) {
            queue.offer(aData);
        }
    }

    @Test
    public void offer() {
        assertEquals(queue.size(), data.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    public void poll() {
        for (int i = 0; i < data.size(); i++) {
            assertEquals(queue.poll(), data.get(i));
            assertEquals(queue.size(), data.size() - i - 1);
        }
        assertTrue(queue.isEmpty());
        assertNull(queue.poll());
    }
}
