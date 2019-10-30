
public class Palindrome {

    public Deque<Character> wordToDeque(String word){

        Deque<Character> res = new LinkedListDeque();
        for (int i = 0; i < word.length(); i++){
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word){
        Deque wordDeque = wordToDeque(word);
        if (wordDeque.size() < 2){
            return false;
        }
        int checkSize = wordDeque.size() / 2;
        for (int i = 0; i < checkSize; i++){
            boolean checker = wordDeque.removeFirst().equals(wordDeque.removeLast());
            if (! checker){
                return false;
            }
        }
        return true;
    }

/** there are copy and paste in this reload, ugly, but haven't found a better way */

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque wordDeque = wordToDeque(word);
        if (wordDeque.size() < 2){
            return false;
        }
        int checkSize = wordDeque.size() / 2;
        for (int i = 0; i < checkSize; i++){
            boolean checker = cc.equalChars((char)wordDeque.removeFirst(),(char)wordDeque.removeLast());
            if (! checker){
                return false;
            }
        }
        return true;
    }
}
