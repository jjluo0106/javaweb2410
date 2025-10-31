package leetcode.practicing;

import leetcode.done.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class A257 {

    List<String> list = new ArrayList<>();


    public List<String> binaryTreePaths(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        makeStr(root, sb);
        return list;

    }

    private void makeStr(TreeNode node, StringBuilder sb){
        if(node==null) return;

        if(sb.length()==0) sb.append(node.val);
        else sb.append("->").append(node.val);

        if(node.left==null && node.right==null){
            list.add(sb.toString());
            return;
        }
        StringBuilder sb2 = new StringBuilder(sb);

        makeStr(node.left, sb);
        makeStr(node.right, sb2);

    }


}
