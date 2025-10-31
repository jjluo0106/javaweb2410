package leetcode.done;

public class A141LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast =head;

        while(fast!=null && fast.next!=null && fast.next.next!=null) {
            slow=  slow.next;
            fast = fast.next.next;
            if(fast==slow) return true;
        }
        return false;
    }

}
