package com.company.leetcode.p198;

import java.util.HashMap;
import java.util.Map;

class Solution {
    /*
    1 2 3 1

    a b c d e f g

    */

//     private static final class Range {
//         private int start;
//         private int end;
//         private Range(int start, int end) {
//             this.start = start;
//             this.end = end;
//         }
//         @Override
//         public int hashCode() {
//             return Objects.hash(this.start, this.end);
//         }

//         @Override
//         public boolean equals(Object o) {
//             Range other = (Range) o;
//             return this.start == other.start && this.end == other.start;
//         }
//     }

    private final Map<Integer[], Integer> cache = new HashMap<>();

    public int rob(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    private int helper(int[] nums, int start, int end) {
        if (start < 0) {
            start = 0;
        }
        if (end > nums.length) {
            end = nums.length;
        }
        if (start >= end) {
            return 0;
        }
        Integer[] key = new Integer[2];
        key[0] = start;
        key[1] = end;
        Integer x = this.cache.get(key);
        if (x != null) {
            return x;
        }
        int maxSum = 0;
        for (int i = start; i < end; i++) {
            int rightSum = helper(nums, i + 2, end);
            int sum = nums[i] + rightSum;
            maxSum = Math.max(maxSum, sum);
        }
        this.cache.put(key, maxSum);
        return maxSum;
    }
}