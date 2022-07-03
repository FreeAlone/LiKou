package com.exam.lk_00;

import com.exam.util.LK_Utils;
import com.exam.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LK_0094 {

    public static void main(String[] args) {
        Integer[] root = {1,null,2,null,null,3};
        LK_0094 lk_0094 = new LK_0094();
        LK_Utils.printList(lk_0094.inorderTraversal(LK_Utils.arrayToTree(root)));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        visit(root, list);
        return list;
    }

    public void visit(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        visit(treeNode.left, list);
        list.add(treeNode.val);
        visit(treeNode.right, list);
    }
}
