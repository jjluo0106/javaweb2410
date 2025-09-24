package leetcode;

public class A108ConvertSortedArrayToBinarySearchTree {


    public TreeNode sortedArrayToBST(int[] nums) {

       return getNode(nums, 0, nums.length-1);


    }


    public TreeNode getNode(int[] nums, int start, int end){
        if(start>end) return null;

        int mid = (start+end)/2;
        TreeNode node = new TreeNode();
        node.val = nums[mid];

        node.left = getNode(nums, start, mid-1);
        node.right = getNode(nums, mid+1, end);
        return node;
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
