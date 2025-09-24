package leetcode;

import java.util.ArrayList;
import java.util.List;

public class A145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return getList(list,root);
    }

    private List<Integer> getList(List<Integer> list, TreeNode root) {
        if(list==null) return list;

        getList(list, root.left);
        getList(list, root.right);
        list.add(root.val);
        return list;


    }


}
