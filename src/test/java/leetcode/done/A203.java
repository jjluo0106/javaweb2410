package leetcode.done;


import leetcode.practicing.ListNode;

public class A203 {


    public leetcode.practicing.ListNode removeElements(leetcode.practicing.ListNode head, int val) {

        leetcode.practicing.ListNode result = new leetcode.practicing.ListNode(0);
        result.next= head;
        ListNode temp = result;

        while(temp.next!=null){
            if(temp.next.val==val) temp.next = temp.next.next;
            else temp = temp.next;
        }
        return result.next;
    }
}
