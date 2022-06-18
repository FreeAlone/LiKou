package com.exam.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LK_Utils {

    public static void printArr(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(arr[i]);
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    public static void printArr(Integer[] arr) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(arr[i]);
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    public static TreeNode buildTreeNode(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        List<TreeNode> nodes = new ArrayList<>(arr.length);
        for (Integer integer: arr) {
            if (integer == null) {
                nodes.add(null);
            } else {
                TreeNode treeNode = new TreeNode();
                treeNode.val = integer;
                nodes.add(treeNode);
            }
        }
        for (int i = 0; i < arr.length / 2 - 1; i++) {
            TreeNode node = nodes.get(i);
            node.left = nodes.get(i * 2 + 1);
            node.right = nodes.get(i * 2 + 2);
        }
        // 只有当总节点数是奇数时，最后一个父节点才有右子节点
        int lastPNodeIndex = arr.length / 2 - 1;
        if (lastPNodeIndex < arr.length && lastPNodeIndex > 0) {
            TreeNode lastPNode = nodes.get(lastPNodeIndex);
            lastPNode.left = nodes.get(lastPNodeIndex * 2 + 1);
            if (arr.length % 2 != 0) {
                lastPNode.right = nodes.get(lastPNodeIndex * 2 + 2);
            }
        }
        return nodes.get(0);
    }

    public static Integer[] treeToArr(TreeNode treeNode) {
        if (treeNode == null) {
            return new Integer[0];
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return list.toArray(new Integer[0]);
    }


}
