package com.company.leetcode.p45;

// Solution from August 17th
public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] aux = new int[nums.length];
        aux[aux.length - 1] = -2;
        for (int i = nums.length - 2; i >= 0; i--) {
            int numJumpsFromThisIndex = -1;
            for (int j = nums[i]; j > 0; j--) {
                if (i + j < nums.length) {
                    int x;
                    if (aux[i + j] == -2) {
                        x = 0;
                    } else {
                        x = aux[i + j];
                    }
                    if (x != -1) {
                        if (numJumpsFromThisIndex == -1) {
                            numJumpsFromThisIndex = x + 1;
                        } else {
                            numJumpsFromThisIndex = Math.min(x + 1, numJumpsFromThisIndex);
                        }
                    }
                }
            }
            aux[i] = numJumpsFromThisIndex;
        }
        return aux[0];
    }
}
