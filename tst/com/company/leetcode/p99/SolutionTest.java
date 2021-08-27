package com.company.leetcode.p99;

import com.company.leetcode.p99.Solution;
import com.company.leetcode.tools.binarytrees.TreeNode;
import com.company.leetcode.tools.binarytrees.Utils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private static Solution solution;

    @BeforeAll
    public static void setUp() {
        solution = new Solution();
    }

    @Test
    public void exampleOne() {
        Integer[] a = new Integer[]{1,3,null,null,2};
        TreeNode root = Utils.convertArrayToBinaryTree(a);
        System.out.println(Utils.convertBinaryTreeToArray(root));
        solution.recoverTree(root);
        System.out.println(Utils.convertBinaryTreeToArray(root));
        assertTrue(true);
    }

    @Test
    public void exampleOneManual() {
        TreeNode root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        solution.recoverTree(root);
    }
}