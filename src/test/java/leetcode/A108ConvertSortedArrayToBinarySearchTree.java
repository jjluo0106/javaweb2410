package leetcode;

public class A108ConvertSortedArrayToBinarySearchTree {


    public TreeNode sortedArrayToBST(int[] nums) {

        return getTree(nums, 0, nums.length-1);
    }

    public TreeNode getTree(int[] nums, int start, int end){
        if(start>end) return null;
        TreeNode myTreeNode  = new TreeNode();
        int mid = start + (end-start)/2;
        myTreeNode.val = nums[mid];
        myTreeNode.left = getTree(nums,  start, mid-1);
        myTreeNode.right = getTree(nums, mid+1, end);
        return myTreeNode;
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
