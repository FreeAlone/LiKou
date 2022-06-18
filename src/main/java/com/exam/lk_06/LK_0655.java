package com.exam.lk_06;

import com.exam.util.LK_Utils;
import com.exam.util.TreeNode;
import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class LK_0655 {

    public static void main(String[] args) {
        LK_0655 lk_0655 = new LK_0655();

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        List<List<String>> result = lk_0655.printTree(treeNode1);
        LK_Utils.printListList(result);

        TreeNode t = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t.left = t2;
        t.right = new TreeNode(3);
        t2.right = new TreeNode(4);
        LK_Utils.printListList(lk_0655.printTree(t));
        LK_Utils.printListList(lk_0655.printTree2(t));
    }

    public List<List<String>> printTree2(TreeNode root) {
        int height = getHeight2(root);
        int width = (1 << height) - 1;
        String[][] res = new String[height][width];
        for (String[] re : res) {
            Arrays.fill(re, "-");
        }
        fill(res, root,0, 0, res[0].length - 1);
        List<List<String>> list = new ArrayList<>();
        for (String[] re : res) {
            list.add(Arrays.asList(re));
        }
        return list;
    }

    public void fill(String[][] res, TreeNode treeNode, int i, int left, int right) {
        if (treeNode == null) {
            return;
        }
        res[i][(left + right) / 2] = treeNode.val + "";
        fill(res, treeNode.left, i+1, left,(left + right) / 2);
        fill(res, treeNode.right,i+1,  (left + right) / 2 + 1, right);
    }

    public int getHeight2(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return 1 + Math.max(getHeight2(treeNode.left), getHeight2(treeNode.right));
    }

    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        Map<Integer, List<String>> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode treeNode = pair.getKey();
            Integer level = pair.getValue();
            List<String> list = map.get(level);
            if (list == null) {
                list = new ArrayList<>();
            }
            if (treeNode != null) {
                list.add(String.valueOf(treeNode.val));
            } else {
                list.add(null);
            }
            map.put(level, list);
            if (level < height) {
                if (treeNode == null) {
                    queue.offer(new Pair<>(null, level + 1));
                    queue.offer(new Pair<>(null, level + 1));
                } else {
                    queue.offer(new Pair<>(treeNode.left, level + 1));
                    queue.offer(new Pair<>(treeNode.right, level + 1));
                }
            }
        }
        List<Integer> key = map.keySet().stream().sorted((Comparator.comparingInt(o -> o))).collect(Collectors.toList());
        int maxWidth = (1 << (height + 1)) - 1;
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i <= height; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < maxWidth; j++) {
                list.add("-");
            }
            result.add(list);
        }
        for (int i = 0; i < key.size(); i++) {
            int index = (1 << (key.size() - i - 1)) - 1;
            int interval = 1 << (key.size() - i);
            List<String> temp = map.get(key.get(i));
            List<String> res = result.get(i);
            for (String str : temp) {
                if (str != null) {
                    res.set(index, str);
                }
                index += interval;
            }
        }
        return result;
    }

    public int getHeight(TreeNode root) {
        int result = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode treeNode = pair.getKey();
            Integer level = pair.getValue();
            result = Math.max(result, level);
            if (treeNode.left != null) {
                queue.offer(new Pair<>(treeNode.left, level + 1));
            }
            if (treeNode.right != null) {
                queue.offer(new Pair<>(treeNode.right, level + 1));
            }
        }
        return result;
    }

}
