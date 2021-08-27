package com.company.leetcode.p72;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void t() {
        Solution solution = new Solution();
        String a = "dinitrophenylhydrazine";
        String b = "acetylphenylhydrazine";
        int result = solution.minDistance(a, b);
        System.out.println(result);
    }
}