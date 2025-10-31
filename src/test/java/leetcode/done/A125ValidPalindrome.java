package leetcode.done;

public class A125ValidPalindrome {


    public boolean isPalindrome(String s) {

        s=  s.toLowerCase().trim();
        StringBuilder sb=  new StringBuilder();


        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if( Character.isLetterOrDigit(c)  ) sb.append(c);
        }

        int start = 0;
        int end = sb.length()-1;

        while(start<end){
            if(sb.charAt(start++) != sb.charAt(end--)) return false;
        }
        return true;

    }
}
