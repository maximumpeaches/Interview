package com.company.leetcode.p1208;

public class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] cost = getCost(s, t);
        return equalSubarray(cost, maxCost);
    }

    private int[] getCost(String s, String t) {
        int[] cost = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cost[i] = Math.abs((int) s.charAt(i) - (int) t.charAt(i));
        }
        return cost;
    }

    // 1 2 3 4 5 6 7 8
    // 3
    private int equalSubarray(int[] cost, int maxCost) {
        if (cost.length == 0) {
            return 0;
        }
        int maxLength = 0;
        int runningSum = cost[0];
        for (int back = 0, forward = 0; forward < cost.length;) {
            // at start of loop, runningSum will always equal what is in the subarray indicated by back & forward
            if (runningSum <= maxCost) {
                maxLength = Math.max(maxLength, forward - back + 1);
                forward++;
                if (forward != cost.length) {
                    runningSum += cost[forward];
                }
            } else {
                runningSum -= cost[back];
                if (forward == back) {
                    forward++;
                    if (forward != cost.length) {
                        runningSum += cost[forward];
                    }
                    back++;
                } else {
                    back++;
                }
            }
        }
        return maxLength;
    }
}
