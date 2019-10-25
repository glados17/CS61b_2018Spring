import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;


public class FlikTest {

    @Test
    public void testHS() {
        HorribleSteve.main(new String[]{"a"});
//        int b = 500;
//        assertEquals(a, b);
    }

    @Test
    public void testFlik() {
        int a = 1;
        int b = 2;
        assertTrue("Terrible",Flik.isSameNumber(3,3));
//        assertTrue(String, boolean)
//        assertEquals(true, Flik.isSameNumber(3,3));
    }


}
