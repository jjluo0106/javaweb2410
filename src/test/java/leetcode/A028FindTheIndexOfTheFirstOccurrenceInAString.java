package leetcode;


import org.junit.Test;

/**
 * 返回haystack中有needle的首個index，沒有返回-1
 */
public class A028FindTheIndexOfTheFirstOccurrenceInAString {



    public int strStr(String haystack, String needle) {

        if( !haystack.contains(needle)) return -1;

        for(int i=0; i < haystack.length() - needle.length(); i++){
            if(haystack.substring(i, needle.length() + i).equals(needle) ) return i;
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
