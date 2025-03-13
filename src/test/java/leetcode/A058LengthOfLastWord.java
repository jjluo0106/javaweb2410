package leetcode;

import org.junit.Test;

import java.util.Arrays;


/**
 Example 1:

 Input: s = "Hello World"
 Output: 5
 Explanation: The last word is "World" with length 5.
 Example 2:

 Input: s = "   fly me   to   the moon  "
 Output: 4
 Explanation: The last word is "moon" with length 4.
 Example 3:

 Input: s = "luffy is still joyboy"
 Output: 6
 Explanation: The last word is "joyboy" with length 6.
 */
public class A058LengthOfLastWord {


    public int lengthOfLastWord( String s) {

        s=s.trim();
        int count =0;
        for(int i = s.length()-1; i >=0; i--){
            if(s.charAt(i) != ' ') count++;
            else break;
        }
        return count;
    }


    @Test
    public void test() {

        String s = "   fly me   to   the moon  ";

        String[] split = s.split(" ");


        System.out.println(Arrays.toString(split));


    }



}
