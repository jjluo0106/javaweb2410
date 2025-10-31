package leetcode.practicing;



import java.util.ArrayList;
import java.util.List;

public class A206 {



    public ListNode reverseList(ListNode head) {

        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        ListNode result = new ListNode();
        ListNode temp = result;
        for(int i = list.size()-1; i>=0; i++){
            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }
        return result.next;
    }
}
