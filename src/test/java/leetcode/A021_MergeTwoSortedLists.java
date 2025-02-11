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
        ListNode a = new ListNode();
        ListNode b =a;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                b.next =list1;
                b = b.next;
                list1 = list1.next;
            }
            else{
                b.next =list2;
                b = b.next;
                list2 = list2.next;
            }
        }
        if(list1 != null) b.next = list1;
        if(list2 != null) b.next = list2;

        return a.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    @Test
    public void test(){
        // 測試案例：list1 = [1, 3, 5], list2 = [2, 4, 6]
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        // 呼叫 mergeTwoLists
        A021_MergeTwoSortedLists solution = new A021_MergeTwoSortedLists();
        ListNode merged = solution.mergeTwoLists(list1, list2);

        // 輸出合併後的鏈表
        printList(merged);
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
