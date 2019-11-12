package synthesizer;
import static org.junit.Assert.*;

import org.junit.Test;
public class MyTest {
    @Test
    public void test1() {
        ArrayRingBuffer one = new ArrayRingBuffer(3);
        one.enqueue(1);
        one.enqueue(2);
        one.enqueue(3);
        assertEquals(1, one.dequeue());
        assertEquals(2, one.dequeue());
        assertEquals(3, one.dequeue());
        one.enqueue(1);
        assertEquals(1, one.dequeue());
        one.enqueue(10);
        assertEquals(10, one.peek());
        }
}
