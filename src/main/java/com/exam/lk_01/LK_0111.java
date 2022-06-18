package com.exam.lk_01;

import com.exam.util.LK_Utils;
import com.exam.util.TreeNode;

public class LK_0111 {

    public static void main(String[] args) {
        Integer[] root = {3,9,20,null,null,15,7};
        LK_0111 lk_0111= new LK_0111();
        System.out.println(lk_0111.minDepth(LK_Utils.arrayToTree(root)));
    }

    public int minDepth(TreeNode root) {
        return dfs(root, 0, Integer.MAX_VALUE);
    }

    public int dfs (TreeNode treeNode, int depth, int min) {
        depth++;
        if (treeNode.left == null && treeNode.right == null) {
            min = Math.min(depth, min);
        }
        if (treeNode.left != null) {
            min = dfs(treeNode.left, depth, min);
        }
        if (treeNode.right != null) {
            min = dfs(treeNode.right, depth, min);
        }
        return min;
    }



}
