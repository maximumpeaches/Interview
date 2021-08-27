package com.company.leetcode.p1143;

class Solution3 {
    /*
    "aaaaxa"
    "ax"
    2

    abcde
    ace

    */
    public int longestCommonSubsequence(String x, String y) {
        int[][] result = new int[y.length()][x.length()];
        for (int yI = y.length() - 1; yI >= 0; yI--) {
            for (int xI = x.length() - 1; xI >= 0; xI--) {
                int maxOther = Math.max(
                        xI <= x.length() - 2 ? result[yI][xI + 1] : 0,
                        yI <= y.length() - 2 ? result[yI + 1][xI] : 0
                );
                result[yI][xI] = x.charAt(xI) == y.charAt(yI) ? maxOther + 1 : maxOther;
            }
        }
        return result[0][0];
    }
}
