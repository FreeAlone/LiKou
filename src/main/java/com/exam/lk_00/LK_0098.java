package com.exam.lk_00;

import com.exam.util.LK_Utils;
import com.exam.util.TreeNode;

public class LK_0098 {

    public static void main(String[] args) {
        Integer[] root = {2,1,3};
        Integer[] root1 = {5,1,4,null,null,3,6};
        LK_0098 lk_0098 = new LK_0098();
        System.out.println(lk_0098.isValidBST(LK_Utils.arrayToTree(root)));
        System.out.println(lk_0098.isValidBST(LK_Utils.arrayToTree(root1)));
    }

    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (pre >= root.val) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

    public void dfs(TreeNode treeNode, boolean flag, int val) {

    }
}
