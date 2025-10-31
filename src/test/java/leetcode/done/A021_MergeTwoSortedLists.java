package leetcode;


public class A021_MergeTwoSortedLists {



    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode myList = new ListNode();
        ListNode temp = myList;

        while(list1!=null && list2!=null){
            if(list1.val>list2.val){
                temp.next = list1;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if(list1==null) temp.next = list2;
        else temp.next = list1;
        return myList.next;
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
