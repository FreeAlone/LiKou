package com.exam.lk_01;

import com.exam.util.LK_Utils;
import com.exam.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LK_0114 {

    public static void main(String[] args) {
        Integer[] root1 = {1,2,5,3,4,null,6};
        Integer[] root2 = {};
        Integer[] root3 = {0};
        TreeNode node1 = LK_Utils.arrayToTree(root1);
        TreeNode node2 = LK_Utils.arrayToTree(root2);
        TreeNode node3 = LK_Utils.arrayToTree(root3);
        LK_0114 lk_0114 = new LK_0114();
        lk_0114.flatten(node1);
        lk_0114.flatten(node2);
        lk_0114.flatten(node3);
        LK_Utils.printTree(node1);
        LK_Utils.printTree(node2);
        LK_Utils.printTree(node3);
    }

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode temp = list.get(i - 1);
            temp.right = list.get(i);
            temp.left = null;
        }
    }

    public void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
