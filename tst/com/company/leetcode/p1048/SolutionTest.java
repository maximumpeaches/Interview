package com.company.leetcode.p1048;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void t() {
        Solution solution = new Solution();
        String[] array = new String[]{"a","b","ba","bca","bda","bdca"};
        int r = solution.longestStrChain(array);
        System.out.println(r);
    }
}