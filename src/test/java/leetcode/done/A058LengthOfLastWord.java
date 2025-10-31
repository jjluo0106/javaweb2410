package leetcode.done;


/**
 * Example 1:
 * <p>
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 * <p>
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * Example 3:
 * <p>
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 */
public class A058LengthOfLastWord {


    public int lengthOfLastWord(String s) {

        s = s.trim();
        int len = 0;

        while( s.charAt(s.length()-1-len) != ' '){
            len++;
        }
        return len;
    }


}
