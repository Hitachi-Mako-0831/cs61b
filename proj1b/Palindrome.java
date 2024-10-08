public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    public boolean isPalindrome(String word) {
        return isPalindromeHelper(wordToDeque(word));
    }

    private boolean isPalindromeHelper(Deque<Character> wordDeque) {
        if (wordDeque.size() == 1 || wordDeque.isEmpty()) {
            return true;
        }
        Character last = wordDeque.removeLast();
        Character first = wordDeque.removeFirst();
        return last == first && isPalindromeHelper(wordDeque);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindromeCCHelper(wordToDeque(word), cc);
    }

    private boolean isPalindromeCCHelper(Deque<Character> wordDeque, CharacterComparator cc) {
        if (wordDeque.size() == 1 || wordDeque.isEmpty()) {
            return true;
        }
        Character last = wordDeque.removeLast();
        Character first = wordDeque.removeFirst();
        return cc.equalChars(last, first) && isPalindromeCCHelper(wordDeque, cc);
    }
}
