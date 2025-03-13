package leetcode;

public class A700SearchInABinarySearchTree {





    public TreeNode searchBST(TreeNode root, int val) {

        while(root != null){
            if(root.val == val) return new TreeNode(root.val, root.left, root.right);
            if(root.val > val) root = root.left;
            else root = root.right;
        }
        return new TreeNode(root.val, root.left, root.right);
    }



    public class TreeNode {
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
}
