package leetcode.done;

import java.util.ArrayList;
import java.util.List;

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

        List<Character> list = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if( temp == '(' || temp == '[' || temp == '{' ){
                list.add(temp);
            }else if( temp == ')' || temp == ']' || temp == '}'){
                char c = list.get(list.size()-1);
                if(c == '(' && temp == ')') list.remove(list.size()-1 );
                if(c == '{' && temp == '}') list.remove(list.size()-1 );
                if(c == '[' && temp == ']') list.remove(list.size()-1 );
            }
            else return false;

        }
        if (list.isEmpty()) return true;
        return false;
    }


}