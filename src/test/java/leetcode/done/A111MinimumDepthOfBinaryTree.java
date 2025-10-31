package leetcode.done;

public class A111MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {

        if(root==null) return 0;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;


    }

    }
