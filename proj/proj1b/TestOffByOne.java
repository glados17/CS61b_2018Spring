import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*  */
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOne() {
        assertFalse(offByOne.equalChars('a', 'a'));
        assertTrue(offByOne.equalChars('a', 'b'));

    }
    static Palindrome palindrome = new Palindrome();

//    @Test
//    public void testIsPalindrome() {
//        assertFalse(palindrome.isPalindrome("cat", offByOne));
//        assertFalse(palindrome.isPalindrome("c"));
//        assertFalse(palindrome.isPalindrome("recover"));
//        assertTrue(palindrome.isPalindrome("cac"));
//        assertTrue(palindrome.isPalindrome("caac"));
//        assertTrue(palindrome.isPalindrome("doctorotcod"));
//        assertTrue(palindrome.isPalindrome("goodluckculdoog"));
//    }

//    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
}
