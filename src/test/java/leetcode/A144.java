package leetcode;

import java.util.ArrayList;
import java.util.List;

public class A144 {



    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return getList(root, list);

    }

    public List<Integer> getList(TreeNode node, List<Integer> list){
        if(node==null) return list;
        list.add(node.val);
        getList(node.left,list);
        getList(node.right,list);
        return list;
    }





}
