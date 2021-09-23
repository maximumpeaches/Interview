package com.company.leetcode.tools.binarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Utils {

    public static TreeNode convertArrayToBinaryTree(Integer[] arr) {
        TreeNode root;
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0;
        root = arr[i] == null ? null : new TreeNode(arr[i]);
        q.add(root);
        i++;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode t1 = q.poll();
            if (t1 != null) {
                t1.left = arr[i] == null ? null : new TreeNode(arr[i]);
                q.add(t1.left);
                i++;
                if (i >= arr.length) {
                    break;
                }
                t1.right = arr[i] == null ? null : new TreeNode(arr[i]);
                q.add(t1.right);
                i++;
            }
        }
        printLevelOrder(root);
        return root;
    }

    // just printing level order
    private static void printLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            sb.append(t == null ? "null" : t.val).append(", ");
            if (t != null) {
                q.add(t.left);
                q.add(t.right);
            }
        }
        System.out.println(sb.toString());
    }

    public static Integer[] convertBinaryTreeToArray(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        return list.toArray(new Integer[0]);
    }
}
