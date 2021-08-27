package com.company.leetcode.p97;

import com.company.leetcode.p97.Solution;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private static Solution solution;

    @BeforeAll
    public static void setUp() {
        solution = new Solution();
    }

    @Test
    public void example1() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        boolean result = solution.isInterleave(s1, s2, s3);
        assertTrue(result);
    }

    @Test
    public void example2() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        boolean result = solution.isInterleave(s1, s2, s3);
        assertFalse(result);
    }
}