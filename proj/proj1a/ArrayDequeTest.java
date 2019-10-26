import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayDequeTest {

    @Test
    public void testarryDeque1() {
        ArrayDeque L = new ArrayDeque <Integer> ();
        L.addFirstArray(2);
        L.addLastArray(2);
        L.resizeTo(2);
        assertEquals(2,L.sizeArray());
        assertEquals(16, L.length);
        L.resizeTo(0.5);
        assertEquals(8, L.length);
    }


    @Test
    public void testarryDeque2() {
        ArrayDeque L = new ArrayDeque <Integer> ();
        L.addFirstArray(1);
        L.addLastArray(2);
//        L.addFirstArray(1);
//        L.resizeTo(2);
        assertEquals(6,L.nextFirst);
        assertEquals(1, L.nextLast);
        L.addFirstArray(1);
        L.addLastArray(2);
        assertEquals(5,L.nextFirst);
        assertEquals(2, L.nextLast);
    }


    @Test
    public void testarrayupdate() {
        ArrayDeque L = new ArrayDeque <Integer> ();
        L.addFirstArray(2);
        L.addLastArray(2);
        assertEquals(6, L.nextFirst);
        assertEquals(1, L.nextLast);
        assertEquals(5, L.getUpdateFirst(1));
        assertEquals(2, L.getUpdateLast(1));
        assertEquals(7, L.getUpdateFirst(-1));
        assertEquals(0, L.getUpdateLast(-1));
    }

    @Test
    public void testArrysize() {
        ArrayDeque L = new ArrayDeque <Integer> ();
        L.addFirstArray(1);
        L.addLastArray(2);
        L.addFirstArray(0);
        L.addLastArray(3);
        assertEquals(4, L.sizeArray());
    }

    @Test
    public void testArryGetAll() {
        ArrayDeque L = new ArrayDeque <Integer> ();
        L.addFirstArray(1);
        L.addLastArray(2);
        L.addFirstArray(0);
        L.addLastArray(3);
        L.resizeTo(2);
        Integer[] c = {0,1,2,3};
        assertEquals(c, L.getAllArray());
    }

    @Test
    public void testArryPrint() {
        ArrayDeque L = new ArrayDeque <Integer> ();
        L.addFirstArray(1);
        L.addLastArray(2);
        L.addFirstArray(0);
        L.addLastArray(3);
        L.resizeTo(2);
        L.arrayDequePrint();
    }

    @Test
    public void testArryRemove1() {
        ArrayDeque L = new ArrayDeque <Integer> ();
        L.addFirstArray(1);
        L.addLastArray(2);
        L.addFirstArray(0);
        L.addLastArray(3);
        L.resizeTo(2);
        L.arrayDequePrint();
        System.out.print("\n");
        System.out.println("After remove first:");
        L.arrayRemoveFirst();
        L.arrayDequePrint();
        System.out.print("\n");
        System.out.println("After remove last:");
        L.arrayRemoveLast();
        L.arrayDequePrint();
    }

    @Test
    public void testArryGet() {
        ArrayDeque L = new ArrayDeque <Integer> ();
        L.addFirstArray(1);
        L.addLastArray(2);
        L.addFirstArray(0);
        L.addLastArray(3);
//        L.resizeTo(2);
        assertEquals(0, L.arrayGet(0));
        assertEquals(1, L.arrayGet(1));
        assertEquals(2, L.arrayGet(2));
        assertEquals(3, L.arrayGet(3));
//        System.out.println(L.arrayGet(5));
    }
}
