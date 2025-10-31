package leetcode.practicing;


public class A203 {


    public ListNode removeElements(ListNode head, int val) {

        ListNode result = new ListNode(0);
        result.next= head;
        ListNode temp = result;

        while(temp.next!=null){
            if(temp.next.val==val) temp.next = temp.next.next;
            else temp = temp.next;
        }
        return result.next;
    }
}
