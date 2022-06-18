package com.exam.lk_04;

import com.exam.util.LK_Utils;
import com.exam.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LK_0437 {

    public static void main(String[] args) {
        Integer[] root1 = {10,5,-3,3,2,null,11,3,-2,null,1};
        int targetSum1 = 8;
        Integer[] root2 = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        int targetSum2 = 22;
        LK_0437 lk_0437 = new LK_0437();
        System.out.println(lk_0437.pathSum(LK_Utils.arrayToTree(root1), targetSum1));
        System.out.println(lk_0437.pathSum(LK_Utils.arrayToTree(root2), targetSum2));
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = calSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int calSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        if (root.val == targetSum) {
            ret++;
        }
        ret += calSum(root.left, targetSum - root.val);
        ret += calSum(root.right, targetSum - root.val);
        return ret;
    }
}
