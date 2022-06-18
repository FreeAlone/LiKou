package com.exam.lk_08;

import com.exam.util.LK_Utils;
import com.exam.util.TreeNode;

import java.util.List;

public class LK_0814 {

    public static void main(String[] args) {
        Integer[] root1 = {1,null,0,null,null,0,1};
        Integer[] root2 = {1,0,1,0,0,0,1};
        Integer[] root3 = {1,1,0,1,1,null,1};
        LK_0814 lk_0814 = new LK_0814();
        LK_Utils.printTree(lk_0814.pruneTree(LK_Utils.arrayToTree(root1)));
        LK_Utils.printTree(lk_0814.pruneTree(LK_Utils.arrayToTree(root2)));
        LK_Utils.printTree(lk_0814.pruneTree(LK_Utils.arrayToTree(root3)));
    }


    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (pruneTree(root.left) == null) {
            root.left = null;
        }
        if (pruneTree(root.right) == null) {
            root.right = null;
        }
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
