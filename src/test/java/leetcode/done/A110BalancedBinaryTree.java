package leetcode.done;



public class A110BalancedBinaryTree {


    public boolean isBalanced(TreeNode root) {

       return getH(root)!= -1;

    }


    public int getH(TreeNode root){
        if(root==null) return 0;
        if( getH(root.left)==-1 || getH(root.right)==-1 ) return -1;
        if( Math.abs(  getH(root.left) - getH(root.right) ) > 1 ) return -1;

        return Math.max( getH(root.left), getH(root.right) ) +1;
    }


}

