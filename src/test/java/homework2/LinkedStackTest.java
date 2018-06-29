package homework2;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class LinkedStackTest {
    private Stack<String> stack;
    private List<String> data;

    @Before
    public void before() {
        data = Arrays.asList("first", "second", "third", "fourth", "fifth");
        stack = new LinkedStack<>();
        for (String aData : data) {
            stack.push(aData);
        }
    }

    @Test
    public void push() {
        assertEquals(stack.size(), data.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void pop() {
        for (int i = data.size() - 1; i >= 0; i--) {
            assertEquals(stack.pop(), data.get(i));
            assertEquals(stack.size(), i);
        }
        assertTrue(stack.isEmpty());
        assertNull(stack.pop());
    }
}
