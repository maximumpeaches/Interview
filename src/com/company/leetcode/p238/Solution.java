package com.company.leetcode.p238;

public class Solution {
    /*
    [1, 2, 3, 4, 5, 6]
    [720, 360, 240, 180, 144, 120]
    [30, 30, 30, 30, 6, 1]

    [720, 720, 360, 120, 30, 6]
    [1, 2, 6, 24, 120, 720]

     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
        }

        int prefix = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            prefix = prefix * nums[i];
            result[i + 1] = prefix;
        }

        int suffix = 1;
        for (int j = nums.length - 1; j > 0; j--) {
            suffix = suffix * nums[j];
            result[j - 1] = result[j - 1] * suffix;
        }
        return result;
    }
}
