package com.company.leetcode.tools.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static TreeNode convertArrayToBinaryTree(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode();
        return root;
    }

    public static Integer[] convertBinaryTreeToArray(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        return list.toArray(new Integer[0]);
    }
}
