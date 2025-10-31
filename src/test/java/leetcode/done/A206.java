package leetcode.done;



import leetcode.practicing.ListNode;

import java.util.ArrayList;
import java.util.List;

public class A206 {



    public leetcode.practicing.ListNode reverseList(leetcode.practicing.ListNode head) {

        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        leetcode.practicing.ListNode result = new leetcode.practicing.ListNode();
        leetcode.practicing.ListNode temp = result;
        for(int i = list.size()-1; i>=0; i++){
            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }
        return result.next;
    }
}
