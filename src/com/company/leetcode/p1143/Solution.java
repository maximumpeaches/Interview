package com.company.leetcode.p1143;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
    "aaaaxa"
    "ax"
    2

    abcde
    ace

    e
    ace
    1

    de
    ace
    1

    cde
    ace
    2

    if match, (kind of greedy algorithm here) just add 1 + shave off the current front indices
    if don't match, then take max of either skipping char in y or skipping char in x
    if either string is empty then return 0


    */
    private String x;
    private String y;
    private static final class Pos {
        int xI;
        int yI;
        private Pos(int xI, int yI) {
            this.xI = xI;
            this.yI = yI;
        }
    }
    private final Map<Pos, Integer> memo = new HashMap<>();
    public int longestCommonSubsequence(String x, String y) {
        this.x = x;
        this.y = y;
        return helper(0, 0);
    }

    private int helper(int xI, int yI) {
        Pos p = new Pos(xI, yI);
        Integer result = this.memo.get(p);
        if (result != null) {
            return result;
        }
        if (xI == x.length() || yI == y.length()) {
            result = 0;
        } else if (x.charAt(xI) == y.charAt(yI)) {
            result = 1 + helper(xI + 1, yI + 1);
        } else {
            result = Math.max(helper(xI + 1, yI), helper(xI, yI + 1));
        }
        this.memo.put(p, result);
        return result;
    }
}
