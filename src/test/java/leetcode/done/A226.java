package leetcode.practicing;

import leetcode.done.TreeNode;

public class A226 {


    public TreeNode invertTree(TreeNode root) {


        TreeNode temp = root.left;
        root.left=  root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }


}
