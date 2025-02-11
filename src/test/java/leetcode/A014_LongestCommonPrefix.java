package leetcode;

import org.junit.Test;

/**
 Example 1:

 Input: strs = ["flower","flow","flight"]
 Output: "fl"
 Example 2:

 Input: strs = ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.
 */
public class A014_LongestCommonPrefix {


    private String longestCommonPrefix(String[] strs) {

        String first = strs[0];


        // 第幾個字
        for(int i = 0; i < first.length() ; i++){
            // 第幾組字串
            for(int j =1; j < strs.length; j++){
                if(first.length() == 0 || strs[j].length() == 0) return "";

                if(strs[j].length() < i || first.charAt(i) != strs[j].charAt(i)) return first.substring(0 , i);

            }
        }
        return first;
    }


    @Test
    public void test(){

        String s = "12";

        System.out.println(s.substring(0,2));




    }


}
