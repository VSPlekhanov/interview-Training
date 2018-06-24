package homework1;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class CyclicLinkedListTest {
    private CyclicLinkedList<String> linkedList;
    private List<String> data;
    @Before
    public void before(){
        linkedList= new CyclicLinkedList<String>();
        data = Arrays.asList("first", "second", "third", "fourth", "fifth");
        for (String aData : data) {
            linkedList.add(aData);
        }
    }

    @Test
    public void add() {
        assertEquals(linkedList.getLength(), 5);
    }

    @Test
    public void get() {
        for (int i = 0; i < linkedList.getLength(); i++) {
            assertEquals(linkedList.get(i), data.get(i));
        }
    }

    @Test
    public void delete() {
        for (int i = linkedList.getLength() - 1; i >= 0; i--) {
            assertEquals(linkedList.delete(i), data.get(i));
            assertEquals(linkedList.getLength(),  i);
        }
    }

    @Test
    public void getHeadAndGetTail() {
        assertEquals(linkedList.getHead(), data.get(0));
        for (int i = 0; i < data.size() - 1; i++) {
            linkedList.delete(0);
        }
        assertEquals(linkedList.getTail() ,linkedList.getHead());
        linkedList.delete(0);
        assertNull(linkedList.getHead());
        assertNull(linkedList.getTail());
    }
}
