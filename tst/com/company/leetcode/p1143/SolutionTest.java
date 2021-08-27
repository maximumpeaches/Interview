package com.company.leetcode.p1143;

import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void t() {
        Solution solution = new Solution();
        int lcs = solution.longestCommonSubsequence("abcde", "ace");
        System.out.println(lcs);
    }

    @Test
    public void r() {
        // I got TLE on this input
        Solution solution = new Solution();
        int lcs = solution.longestCommonSubsequence("hofubmnylkra", "pqhgxgdofcvmr");
        System.out.println(lcs);
    }
}