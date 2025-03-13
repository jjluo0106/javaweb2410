package leetcode;


import org.junit.Test;

/**
 Example 1:

 Input: haystack = "sadbutsad", needle = "sad"
 Output: 0
 Explanation: "sad" occurs at index 0 and 6.
 The first occurrence is at index 0, so we return 0.
 Example 2:

 Input: haystack = "leetcode", needle = "leeto"
 Output: -1
 Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */
public class A028FindTheIndexOfTheFirstOccurrenceInAString {



    public int strStr(String haystack, String needle) {

        if( !haystack.contains(needle)) return -1;

        for(int i =0; i <= haystack.length() - needle.length(); i++){
            if(haystack.substring(i, i + needle.length()).equals(needle)) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        A028FindTheIndexOfTheFirstOccurrenceInAString a = new A028FindTheIndexOfTheFirstOccurrenceInAString();
        System.out.println(a.strStr("hello", "ll"));
        System.out.println(a.strStr("aaaaa", "bba"));
        System.out.println(a.strStr("", ""));
        System.out.println(a.strStr("mississippi", "issip"));
    }



    @Test
    public void test(){
        String s = "hello";

        System.out.println(s.substring(1,2));
    }
}
