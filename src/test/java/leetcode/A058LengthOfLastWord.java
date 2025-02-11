package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class A058LengthOfLastWord {


    public int lengthOfLastWord(String s) {
        String[] split = s.trim().split(" ");

        return split[split.length - 1].length();
    }


    @Test
    public void test() {

        String s = "   fly me   to   the moon  ";

        String[] split = s.split(" ");


        System.out.println(Arrays.toString(split));


    }



}
