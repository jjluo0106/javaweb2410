package leetcode;

/**
 Input: head = [1,1,2]
 Output: [1,2]

 Input: head = [1,1,2,3,3]
 Output: [1,2,3]
 */
public class A083RemoveDuplicatesFormSortedList {


    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        ListNode a = new ListNode(head.val);
        ListNode b =a;

        while(head != null){
            if(b.val != head.val){
                b.next = new ListNode(head.val);
                b = b.next;
            }
            head = head.next;
        }
        return a;
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
