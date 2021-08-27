package com.company.leetcode.p1071;

import com.company.leetcode.p1071.Solution;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void t() {
        Solution s = new Solution();
        String result = s.gcdOfStrings("ABCABC", "ABC");
        System.out.println(result);
    }
}