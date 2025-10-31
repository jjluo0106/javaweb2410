package leetcode;

public class A160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = getLen(headA);
        int lenB = getLen(headB);

        while(lenA>lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenA<lenB){
            headB = headB.next;
            lenB--;
        }

        while(headA!=null){
            if(headA==headB) return headA;
        }
        return null;
    }

    private int getLen(ListNode headA) {
        int l = 0;
        while(headA!=null) {
            l++;
            headA = headA.next;
        }
        return l;
    }


}
