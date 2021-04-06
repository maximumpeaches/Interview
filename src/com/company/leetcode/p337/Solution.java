package com.company.leetcode.p337;

import java.util.HashMap;
import java.util.Map;

class Solution {

    //Definition for a binary tree node.
    private static final class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static final class Key {
        private TreeNode treeNode;
        private boolean canRob;

        public Key(TreeNode treeNode, boolean canRob) {
            this.treeNode = treeNode;
            this.canRob = canRob;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (canRob != key.canRob) return false;
            return treeNode != null ? treeNode.equals(key.treeNode) : key.treeNode == null;
        }

        @Override
        public int hashCode() {
            int result = treeNode != null ? treeNode.hashCode() : 0;
            result = 31 * result + (canRob ? 1 : 0);
            return result;
        }
    }

    private final Map<Key, Integer> maxAtThatNode = new HashMap<>();

    public int rob(TreeNode root) {
        maxAtThatNode.put(new Key(null, true), 0);
        maxAtThatNode.put(new Key(null, false), 0);
        return robR(root, true);
    }

    private int robR(TreeNode root, boolean canRob) {
        Key key = new Key(root, canRob);
        Integer maxValue = maxAtThatNode.get(key);
        if (maxValue != null) {
            return maxValue;
        }
        int maxValueCanRobNext = robR(root.left, true) + robR(root.right, true);
        int maxValueRobThisOne = 0;
        if (canRob) {
            maxValueRobThisOne = root.val + robR(root.left, false) + robR(root.right, false);
        }
        maxValue = Math.max(maxValueCanRobNext, maxValueRobThisOne);
        maxAtThatNode.put(key, maxValue);
        return maxValue;
    }
}
