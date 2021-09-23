package com.company.leetcode.p124;

import com.company.leetcode.tools.binarytrees.TreeNode;

public class Solution {

    private int maxSum = 0;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        int rootPlusLeft = root.val + leftSum;
        int rootPlusRight = root.val + rightSum;
        int rootPlusLeftAndRight = root.val + leftSum + rightSum;
        maxSum = varArgsMax(maxSum, root.val, rootPlusRight, rootPlusLeft, rootPlusLeftAndRight);
        return varArgsMax(rootPlusLeft, rootPlusRight, root.val);
    }

    private int varArgsMax(int... array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("array must be of length 1 at minimum");
        }
        int max = array[0];
        for (int i : array) {
            max = Math.max(i, max);
        }
        return max;
    }
}
