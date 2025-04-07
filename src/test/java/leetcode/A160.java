package leetcode;

public class A160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);

        while (lenA > lenB) {
            lenA--;
            headA=headA.next;
        }
        while (lenA < lenB) {
            lenB--;
            headB=headB.next;
        }

        while (headA != null && headB != null) {
            if(headA==headB) return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }

    private static int getLen(ListNode node) {
        int len = 0;
        while(node!=null){
            node=node.next;
            len++;
        }
        return len;
    }


}
