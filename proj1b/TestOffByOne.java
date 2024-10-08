import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();


    // Your tests go here.
    @Test
    public void testOffByOne() {
        assertFalse(offByOne.equalChars('a', 'c'));
        assertTrue(offByOne.equalChars('b', 'c'));
        assertTrue(offByOne.equalChars('d', 'c'));
        assertFalse(offByOne.equalChars('a', 'z'));
        assertTrue(offByOne.equalChars('&', '%'));
        assertFalse(offByOne.equalChars('a', 'A'));
    }
}
