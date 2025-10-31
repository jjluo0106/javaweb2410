package leetcode;



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

        for(int i=0; i < haystack.length() - needle.length();i++){
            if(needle.equals(haystack.substring(i, i+ needle.length() ) )) return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println("s".substring(0,1));
    }



}
