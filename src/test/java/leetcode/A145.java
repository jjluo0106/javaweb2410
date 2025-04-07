package leetcode;

import java.util.ArrayList;
import java.util.List;

public class A145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        return getList(root, list);
    }

    private List<Integer> getList(TreeNode root, List<Integer> list) {

        if(root==null)return list;
        getList(root.left, list);
        getList(root.right, list);
        list.add(root.val);
        return list;
    }


}
