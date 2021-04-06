package com.company.leetcode.p1578;

public class Solution {

    static class Result {
        int nextIdx;
        // note: could get int overflow here
        int costToDeleteThisSegment;
    }

    // aaabb
    public int minCost(String s, int[] cost) {
        int totalCost = 0;
        for (int i = 1; i < s.length();) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                Result r = findCostToKeepOneCharOnly(i - 1, s, cost);
                totalCost += r.costToDeleteThisSegment;
                i = r.nextIdx;
            } else {
                i++;
            }
        }
        return totalCost;
    }

    private Result findCostToKeepOneCharOnly(int i, String s, int[] cost) {
        char sameChar = s.charAt(i);

        Result r = new Result();
        int idxKept = i; // we could always keep first character. want to see if another character is more expensive than it.
        r.costToDeleteThisSegment = 0;

        for (int k = i + 1; k < s.length(); k++) {
            if (s.charAt(k) != sameChar) {
                // small optimization here of returning the first character that's different, so don't need to find it again.
                r.nextIdx = k;
                return r;
            }
            if (cost[k] > cost[idxKept]) {
                r.costToDeleteThisSegment += cost[idxKept];
                idxKept = k;
            } else {
                r.costToDeleteThisSegment += cost[k];
            }
        }

        r.nextIdx = s.length();
        return r;
    }
}
