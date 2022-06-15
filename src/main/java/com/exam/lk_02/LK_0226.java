package com.exam.lk_02;

import com.exam.util.LK_Utils;
import com.exam.util.TreeNode;

public class LK_0226 {

    public static void main(String[] args) {
        LK_0226 lk_0226 = new LK_0226();
        Integer[] nums = {};
        TreeNode treeNode = lk_0226.invertTree(LK_Utils.buildTreeNode(nums));
        LK_Utils.printArr(LK_Utils.treeToArr(treeNode));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
