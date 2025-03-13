package leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 Example 1:

 Input: s = "()"

 Output: true

 Example 2:

 Input: s = "()[]{}"

 Output: true

 Example 3:

 Input: s = "(]"

 Output: false

 Example 4:

 Input: s = "([])"

 Output: true
 */

public class A020_ValidParentheses {


    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();


        for(int i = 0; i < s.length(); i++){
            Character c  = s.charAt(i);

            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else if(stack.isEmpty()){
                return false;
            }
            else{
                if( c== ')' && stack.peek() != '(' || c== ']' && stack.peek() != '[' || c== '}' && stack.peek() != '{') return false;
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return false;

        return true;
    }

    @Test
    public void test() {
        System.out.println(isValid("()"));
    }


    @Test
    public void test1(){
        System.out.println( -3/2);
    }


}