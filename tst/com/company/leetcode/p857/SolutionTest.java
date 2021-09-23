package com.company.leetcode.p857;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void exampleOne() {
        // quality = [10,20,5], wage = [70,50,30], k = 2
        int[] quality = new int[]{10, 20, 5};
        int[] wage = new int[]{70, 50, 30};
        int k = 2;
        Solution solution = new Solution();
        double result = solution.mincostToHireWorkers(quality, wage, k);
        assertEquals(105.0, result, 0.0001);
    }
}