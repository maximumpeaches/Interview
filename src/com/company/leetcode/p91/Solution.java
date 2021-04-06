package com.company.leetcode.p91;

public class Solution {
    /*
    1126
    AABF
    KBF
    AAZ
    KZ
     */
    private String s;
    public int numDecodings(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        this.s = s;
        return helper(0);
    }

    private int helper(int index) {
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) > 2 || s.charAt(index) == 0 || s.charAt(index + 1) == s.length()) {
            return helper(index + 1);
        }
        if (s.charAt(index) == 2 && s.charAt(index + 1) > 6) {
            return helper(index + 1);
        }
        return helper(index + 1) + helper(index + 2);
    }
}
