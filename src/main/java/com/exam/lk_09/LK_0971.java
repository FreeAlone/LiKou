package com.exam.lk_09;

import com.exam.util.LK_Utils;
import com.exam.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LK_0971 {

    public static void main(String[] args) {
        Integer[] root1 = {1,2};
        int[] voyage1 = {2,1};
        Integer[] root2 = {1,2,3};
        int[] voyage2 = {1,3,2};
        Integer[] root3 = {1,2,3};
        int[] voyage3 = {1,2,3};

        LK_0971 lk_0971 = new LK_0971();
        LK_Utils.printList(lk_0971.flipMatchVoyage(LK_Utils.arrayToTree(root1), voyage1));
        LK_Utils.printList(lk_0971.flipMatchVoyage(LK_Utils.arrayToTree(root2), voyage2));
        LK_Utils.printList(lk_0971.flipMatchVoyage(LK_Utils.arrayToTree(root3), voyage3));
    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> list = new ArrayList<>();
        List<Integer> total = new ArrayList<>();

        boolean res = flip(list, total, root, voyage);
        if (!res) {
            list.clear();
            list.add(-1);
        }
        return list;
    }

    public boolean flip(List<Integer> list, List<Integer> total, TreeNode root, int[] voyage) {
        if (root == null) {
            return true;
        }
        int base = voyage[total.size()];
        if (root.val != base) {
            return false;
        }
        total.add(root.val);
        if (flip(list, total, root.left, voyage) && flip(list, total, root.right, voyage)) {
            return true;
        } else if (flip(list, total, root.right, voyage) && flip(list, total, root.left, voyage)){
            list.add(root.val);
            return true;
        } else {
            return false;
        }
    }
}
