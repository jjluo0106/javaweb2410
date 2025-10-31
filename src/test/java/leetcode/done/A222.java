package leetcode.practicing;

import leetcode.done.TreeNode;

public class A222 {

        public int countNodes(TreeNode root) {

            if(root==null) return 0;
            return countNodes(root.left) + countNodes(root.right) + 1;

        }
}
