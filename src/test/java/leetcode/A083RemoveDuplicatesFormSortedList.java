package leetcode;

/**
 Input: head = [1,1,2]
 Output: [1,2]

 Input: head = [1,1,2,3,3]
 Output: [1,2,3]
 */
public class A083RemoveDuplicatesFormSortedList {


    public ListNode deleteDuplicates(ListNode head) {

        if(head==null || head.next==null || head.next.next==null) return head;
        ListNode temp = head;

        while(temp!=null && temp.next!=null && temp.next.next!=null){
            if(temp.val== temp.next.val) temp.next= temp.next.next;
            else temp = temp.next;
        }
        return head;


    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
