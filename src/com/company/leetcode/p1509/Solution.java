package com.company.leetcode.p1509;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int minDifference(int[] nums) {
        if (nums.length < 5) {
            return 0;
        }
        Queue<Integer> big = new PriorityQueue<>();
        Queue<Integer> small = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));
        for (int num : nums) {
            if (small.size() < 4) {
                small.add(num);
            } else if (small.peek() < num) {
                small.add(num);
            }
            if (big.size() < 4) {
                big.add(num);
            }

        }
        return -1;
    }
}
