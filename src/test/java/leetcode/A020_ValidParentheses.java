package leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 250205
 */

public class A020_ValidParentheses {


    @Test
    public void test() {
        System.out.println(isValid("()"));
    }


    @Test
    public void test1(){
        System.out.println( -3/2);
    }


    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i=0; i < s.length(); i++){
//            System.out.println(stack);
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
                continue;
            }else if(stack.size() == 0) return false;

            if(     c == '}' && stack.peek() != '{' ||
                    c == ']' && stack.peek() != '[' ||
                    c == ')' && stack.peek() != '(') return false;

            stack.pop();
        }
        if(stack.size() == 0) return true;
        return false;
    }
}