package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(5);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();
        arb.enqueue(4);
        arb.enqueue(5);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        int num4 = arb.dequeue();
        int num5 = arb.dequeue();
        int num1 = arb.dequeue();
        int num2 = arb.dequeue();
        int num3 = arb.dequeue();

        assertEquals(4, num4);
        assertEquals(5, num5);
        assertEquals(1, num1);
        assertEquals(2, num2);
        assertEquals(3, num3);

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
