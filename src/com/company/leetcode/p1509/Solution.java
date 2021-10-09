package com.company.leetcode.p1509;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int minDifference(int[] nums) {
        if (nums.length < 5) {
            return 0;
        }
        Queue<Integer> big = new PriorityQueue<>(4);
        Queue<Integer> small = new PriorityQueue<>(4, (a, b) -> -Integer.compare(a, b));
        for (int num : nums) {
            if (small.size() < 4) {
                small.add(num);
            } else if (small.peek() > num) {
                small.remove();
                small.add(num);
            }
            if (big.size() < 4) {
                big.add(num);
            } else if (big.peek() < num) {
                big.remove();
                big.add(num);
            }
        }
        int[] bigA = new int[4];
        int[] smallA = new int[4];
        for (int i = 0; i < 4; i++) {
            bigA[i] = big.remove();
            smallA[3 - i] = small.remove();
        }
        int min = bigA[0] - smallA[0];
        for (int i = 1; i < 4; i++) {
            min = Math.min(min, bigA[i] - smallA[i]);
        }
        return min;
    }
}
