package com.company.leetcode.p124;

import com.company.leetcode.tools.binarytrees.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void exampleTwo() {
        Solution solution = new Solution();
        int result = solution.maxPathSum(Utils.convertArrayToBinaryTree(new Integer[]{-10,9,20,null,null,15,7}));
        assertEquals(42, result);
    }
}