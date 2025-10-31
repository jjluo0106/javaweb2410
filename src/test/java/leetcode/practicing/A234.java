package leetcode.practicing;

import java.util.ArrayList;
import java.util.List;

public class A234 {


    public boolean isPalindrome(ListNode head) {

        List<Integer> list = new ArrayList<>();
        if(head==null) return false;
        while(head!=null) {
            list.add(head.val);
            head = head.next;
        }
        int start = 0;
        int end = list.size()-1;

        while(start<end) if(list.get(start++) != list.get(end--) ) return false;
        return true;
    }

}
