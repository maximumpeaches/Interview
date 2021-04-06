package com.company.leetcode.p561;

import java.util.Arrays;

public class Solution {
    /*
    1 3 5 7 9 11
    1, 11
    3, 9
    5, 7
    9

    1, 3
    5, 7
    9, 11
    15
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
