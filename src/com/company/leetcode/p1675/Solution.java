package com.company.leetcode.p1675;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer[], Integer> cache = new HashMap<>();
    public int minimumDeviation(int[] nums) {
        Arrays.sort(nums);
        Integer[] numsAsObjects = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsAsObjects[i] = nums[i];
        }
        return minimumDeviationRecursive(numsAsObjects);
    }

    private int minimumDeviationRecursive(Integer[] nums) {
        if (cache.containsKey(nums)) {
            return cache.get(nums);
        }
        int result;
        // nums is sorted when it first enters this function
        int bottom = nums[0];
        int top = nums[nums.length - 1];
        int currentMinDev = findMinimumDeviation(nums);
        if (isEven(bottom) && isOdd(top)) {
            result = currentMinDev;
        } else if (isEven(bottom)) {
            // can't multiply bottom element, so only care about top
            // we know top is even at this point in flow
            nums[nums.length - 1] = top / 2;
            // could implement an O(n + lgn) sort here (binary search for first element less than newTop, then do insertion sort)
            Arrays.sort(nums);
            // before passing nums to other functions, it is sorted
            int r = minimumDeviationRecursive(nums);
            result = Math.min(r, currentMinDev);
        } else if (isOdd(top)) {
            // can't divide the top element, so only care about bottom
            nums[0] = bottom * 2;
            // again could figure out an O(n + lgn) sort here
            Arrays.sort(nums);
            // before passing nums to other functions, it is sorted
            int r = minimumDeviationRecursive(nums);
            result = Math.min(r, currentMinDev);
        } else {
            Integer[] numsCopy = Arrays.copyOf(nums, nums.length);
            numsCopy[0] = bottom * 2;
            nums[nums.length - 1] = top / 2;
            // before passing nums to other functions, it is sorted
            Arrays.sort(numsCopy);
            Arrays.sort(nums);
            result = Math.min(currentMinDev, Math.min(minimumDeviationRecursive(nums), minimumDeviationRecursive(numsCopy)));
        }
        cache.put(nums, result);
        return result;
    }

    private int findMinimumDeviation(Integer[] nums) {
        return nums[nums.length - 1] - nums[0];
    }

    private boolean isOdd(int i) {
        return i % 2 == 1;
    }

    private boolean isEven(int i) {
        return !isOdd(i);
    }
}
