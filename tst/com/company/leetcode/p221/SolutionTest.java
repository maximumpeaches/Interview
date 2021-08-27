package com.company.leetcode.p221;

import com.company.leetcode.p221.Solution;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void exampleOne() {
        Solution solution = new Solution();
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int max = solution.maximalSquare(matrix);
        System.out.println(max);
    }
}