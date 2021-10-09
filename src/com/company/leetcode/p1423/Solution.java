package com.company.leetcode.p1423;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = cardPoints.length - k; i < cardPoints.length; i++) {
            sum += cardPoints[i];
        }
        int max = sum;
        int i = cardPoints.length - k;
        int j = 0;
        while (i < cardPoints.length) {
            sum -= cardPoints[i];
            sum += cardPoints[j];
            j++;
            i++;
            max = Math.max(sum, max);
        }
        return max;
    }
}
