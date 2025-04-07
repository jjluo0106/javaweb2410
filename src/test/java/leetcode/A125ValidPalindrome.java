package leetcode;

import com.alibaba.druid.sql.visitor.functions.Char;

public class A125ValidPalindrome {


    public boolean isPalindrome(String s) {

        if(s.isEmpty()) return false;

        StringBuilder sb = new StringBuilder();

        s=s.toLowerCase();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(Character.isLetterOrDigit(c)) sb.append(c);
        }

        int left=0;
        int right=sb.length()-1;

        while(left<right){
            if(sb.charAt(left) != sb.charAt(right) ) return false;

            left++;
            right--;
        }
        return true;
    }
}
