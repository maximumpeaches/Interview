package com.company.leetcode.p394;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void t() {
        Solution solution = new Solution();
        String result = solution.decodeString("3[a]2[bc]");
        System.out.println(result);
    }

    @Test
    public void r() {
        Solution solution = new Solution();
        String result = solution.decodeString("2[abc]3[cd]ef");
        System.out.println(result);
    }

    @Test
    public void u() {
        Solution solution = new Solution();
        String result = solution.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
        System.out.println(result);
    }
}