package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * <p>
 * Example 2:
 * Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
 * Output: [4,2,6,5,7,1,3,9,8]
 * <p>
 * Example 3:
 * <p>
 * Input: root = []
 * <p>
 * Output: []
 * <p>
 * Example 4:
 * <p>
 * Input: root = [1]
 * <p>
 * Output: [1]
 */
public class A094BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        getList(root, list);
        return list;
    }

    public void getList(TreeNode root, List<Integer> list){
        if(root==null) return;
        if(root.left != null) getList(root.left, list);
        list.add(root.val);
        if(root.right != null) getList(root.right, list);
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
