import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /*
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset. */
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

//    Uncomment this class once you've created your Palindrome class. */
    @Test
    public void testIsPalindrome(){
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("c"));
        assertFalse(palindrome.isPalindrome("recover"));
        assertTrue(palindrome.isPalindrome("cac"));
        assertTrue(palindrome.isPalindrome("caac"));
        assertTrue(palindrome.isPalindrome("doctorotcod"));
        assertTrue(palindrome.isPalindrome("goodluckculdoog"));

    }

    CharacterComparator offByOne = new OffByN(1);
    @Test
    public void testIsPalindromeNew() {
        assertFalse(palindrome.isPalindrome("cat", offByOne));
        assertFalse(palindrome.isPalindrome("recover",offByOne));
        assertTrue(palindrome.isPalindrome("cad",offByOne));
        assertTrue(palindrome.isPalindrome("cabd",offByOne));
        assertTrue(palindrome.isPalindrome("doctorpsbnc",offByOne));
        assertTrue(palindrome.isPalindrome("goodluckbvmeppf",offByOne));
    }

}
