package com.company.leetcode.p70;

import java.util.HashMap;
import java.util.Map;

// this solution works fine
public class SolutionA {
    private Map<Integer, Integer> memo = new HashMap<>(45);
    {
        memo.put(-1, 0);
        memo.put(0, 1);
    }
    public int climbStairs(int n) {
        if (memo.get(n) != null) {
            return memo.get(n);
        }
        int result = climbStairs(n - 1) + climbStairs(n - 2);
        memo.put(n, result);
        return result;
    }
}
