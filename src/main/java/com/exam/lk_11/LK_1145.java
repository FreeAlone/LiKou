package com.exam.lk_11;

import com.exam.util.LK_Utils;
import com.exam.util.TreeNode;

public class LK_1145 {

    public static void main(String[] args) {
        Integer[] root = {1,2,3,4,5,6,7,8,9,10,11};
        int n = 11;
        int x = 3;

        LK_1145 lk_1145 = new LK_1145();
        System.out.println(lk_1145.btreeGameWinningMove(LK_Utils.arrayToTree(root), n, x));

    }

    int leftCount = 0;
    int rightCount = 0;
    int target = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        target = x;
        dfs(root);
        int half = (n+1) / 2;
        return leftCount > half || rightCount > half || (leftCount + rightCount) < half;
    }

    public int dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = 0;
        int right= 0;
        if (treeNode.left != null) {
            left = dfs(treeNode.left);
        }
        if (treeNode.right != null) {
            right = dfs(treeNode.right);
        }
        if (target == treeNode.val) {
            leftCount = left;
            rightCount = right;
        }
        return 1 + left + right;
    }
}
