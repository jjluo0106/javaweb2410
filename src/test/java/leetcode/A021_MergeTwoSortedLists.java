package leetcode;

import org.junit.Test;

/**

 Example 1:
 Input: list1 = [1,2,4], list2 = [1,3,4]
 Output: [1,1,2,3,4,4]

 Example 2:

 Input: list1 = [], list2 = []
 Output: []


 Example 3:

 Input: list1 = [], list2 = [0]
 Output: [0]
 */
public class A021_MergeTwoSortedLists {



    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode head = result;

        while(list1!=null && list2!=null){

            if(list1.val<=list2.val){
                head.next = list1;
                list1=list1.next;
            }
            if(list2.val<list1.val){
                head.next = list2;
                list2=list2.next;
            }
            head=head.next;
        }
        if(list1!=null) head.next= list1;
        if(list2!=null) head.next= list2;
        return result.next;
    }






    // 輔助方法：列印鏈結串列
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }







}
