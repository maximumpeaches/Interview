package com.company.leetcode.p857;

import java.util.PriorityQueue;

public class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double[] ratio = new double[wage.length];
        for (int i = 0; i < wage.length; i++) {
            ratio[i] = (double) wage[i] / (double) quality[i];
        }

        double minCost = Integer.MAX_VALUE;
        for (double v : ratio) {
            PriorityQueue<Double> minHeap = new PriorityQueue<>(k);
            for (int j = 0; j < ratio.length; j++) {
                double r = v * quality[j];
                if (r >= ((double) wage[j] - 0.00001)) {
                    if (minHeap.size() < k) {
                        minHeap.add(r);
                    } else {
                        if (minHeap.peek() > r) {
                            minHeap.remove();
                            minHeap.add(r);
                        }
                    }
                }
            }
            double cost = 0;
            while (!minHeap.isEmpty()) {
                cost += minHeap.remove();
            }
            minCost = Math.min(cost, minCost);
        }
        return minCost;
    }
}
