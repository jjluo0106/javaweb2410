package leetcode;


/**
 Example 1:

 Input: x = 121
 Output: true
 Explanation: 121 reads as 121 from left to right and from right to left.
 Example 2:

 Input: x = -121
 Output: false
 Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 Example 3:

 Input: x = 10
 Output: false
 Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class A009_PalindromeNumber {

    public static boolean isPalindrome(int x) {

        if(x<0 || x/10==0) return false;
        int reverse = 0;

        while(x>reverse){
            reverse = reverse*10 + x%10;
            x/=10;
        }

        if(x==reverse || x==reverse/10) return true;
        return false;


    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(101));
    }



}


