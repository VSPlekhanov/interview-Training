package homework2;

import org.junit.Test;

import static homework2.BracketsValidator.validate;
import static org.junit.Assert.assertEquals;


public class BracketsValidatorTest {


    @Test
    public void validateTest() {
        assertEquals(validate("{[}]") , 3);
        assertEquals(validate("([](){([])})"), -1);
        assertEquals(validate("()[]}"),5);
        assertEquals(validate("{{[()]]"), 7);
        assertEquals(validate("{{{[][][]"), 1);
        assertEquals(validate("{*{{}") , 1);
        assertEquals(validate("[[*") , 1);
        assertEquals(validate("{*}") , -1);
        assertEquals(validate("{{") , 1);
        assertEquals(validate("{}") , -1);
        assertEquals(validate("") , -1);
        assertEquals(validate("}") , 1);
        assertEquals(validate("*{}") , -1);
        assertEquals(validate("{{{**[][][]") , 1);
    }
}