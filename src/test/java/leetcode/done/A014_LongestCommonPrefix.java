package leetcode;


import org.junit.jupiter.api.Test;

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

        StringBuilder sb = new StringBuilder();

        String first = strs[0];


        for(int i = 0; i < first.length(); i++){ // 每次字母
            char firstC = first.charAt(i);
            for(int j = 0; j < strs.length; j++){ // 美個單字
                if(strs.length-1 < i || firstC != strs[j].charAt(i)) return sb.toString();
            }
            sb.append(firstC);
        }
        return sb.toString();
    }


    @Test
    public void test(){

        String s = "12";

        System.out.println(s.substring(0,2));




    }


}
