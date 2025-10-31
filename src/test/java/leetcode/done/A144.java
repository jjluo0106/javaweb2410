package leetcode.done;

import java.util.ArrayList;
import java.util.List;

public class A144 {



    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return getMyList(list, root);

    }

    private List<Integer> getMyList(List<Integer> list, TreeNode root) {
        if(list == null) return list;
        list.add(root.val);
        getMyList(list, root.left);
        getMyList(list, root.right);
        return list;
    }


}
