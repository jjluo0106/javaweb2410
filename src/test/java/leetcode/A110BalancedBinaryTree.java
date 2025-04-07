package leetcode;



public class A110BalancedBinaryTree {


    public boolean isBalanced(TreeNode root) {
        return getHigh(root) != -1;

    }

    public int getHigh(TreeNode root){
        if(root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(  getHigh(left)==-1 || getHigh(right)==-1) return -1;
        if( Math.abs( getHigh(left) - getHigh(right)) > 1) return -1;

        return  Math.max( getHigh(left), getHigh(right)) +1;
    }






}

