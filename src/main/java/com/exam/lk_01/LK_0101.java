package com.exam.lk_01;

import com.exam.util.LK_Utils;
import com.exam.util.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class LK_0101 {

    public static void main(String[] args) {
        LK_0101 lk_0101 = new LK_0101();
        Integer[] nums = {1,2,2,3,4,4,3};
        Integer[] nums2 = {1,2,2,null,3,null,3};
        System.out.println(lk_0101.isSymmetric(LK_Utils.buildTreeNode(nums)));
        System.out.println(lk_0101.isSymmetric2(LK_Utils.buildTreeNode(nums)));
        System.out.println(lk_0101.isSymmetric(LK_Utils.buildTreeNode(nums2)));
        System.out.println(lk_0101.isSymmetric2(LK_Utils.buildTreeNode(nums2)));
    }

    public boolean isSymmetric(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Pair<TreeNode, Integer> pair = new Pair<>(root, 0);
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(pair);
        while (!queue.isEmpty()) {
            // 处理
            Pair<TreeNode, Integer> tempPair = queue.poll();
            TreeNode treeNode = tempPair.getKey();
            Integer level = tempPair.getValue();
            List<Integer> list = map.get(level);
            if (list == null) {
                list = new ArrayList<>();
            }
            if (treeNode == null) {
                list.add(null);
            } else {
                list.add(treeNode.val);
            }
            map.put(level, list);
            // 判断是否需要新增
            if (treeNode != null) {
                queue.add(new Pair<>(treeNode.left, level + 1));
                queue.add(new Pair<>(treeNode.right, level + 1));
            }
        }
        for (Integer integer : map.keySet()) {
            List<Integer> list = map.get(integer);
            for (int i = 0; i < (list.size() + 1) / 2; i++) {
                Integer s1 = list.get(i);
                Integer s2 = list.get(list.size() - i - 1);
                if (s1 != null && s2 == null) {
                    return false;
                }
                if (s1 == null && s2 != null) {
                    return false;
                }
                if (s1 != null && !s1.equals(s2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        return isMirror(root, root);
    }
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}
