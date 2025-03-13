package leetcode;



public class A110BalancedBinaryTree {


    public boolean isBalanced(TreeNode root) {
        return getHigh(root) != -1;

    }

    public int getHigh(TreeNode root){
        TreeNode leftt = root.left;
        TreeNode rightt = root.right;
        if(root==null) return 0;
        if( Math.abs( getHigh(leftt) - getHigh(rightt))  > 1 ) return -1;
        if(getHigh(leftt)==-1 || getHigh(rightt)==-1) return -1;
        return Math.max( getHigh(leftt), getHigh(rightt)) +1;
    }






}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}