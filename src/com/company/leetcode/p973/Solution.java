package com.company.leetcode.p973;

import java.util.Deque;
import java.util.PriorityQueue;

public class Solution {
    private static final class Point implements Comparable {
        private int[] xy;
        private double distance;

        public Point(int[] xy) {
            this.xy = xy;
            this.distance = Math.pow(xy[0], 2) + Math.pow(xy[1], 2);
        }

        @Override
        public boolean equals(Object o) {
            Point other = (Point) o;
            return other.xy[0] == this.xy[0] && other.xy[1] == this.xy[1];
        }
        @Override
        public int hashCode() {
            return 31 * this.xy[0] + this.xy[1];
        }
        @Override
        public int compareTo(Object o) {
            return -Double.compare(this.distance, ((Point) o).distance);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        if (k == 0) {
            return new int[0][2];
        }
        PriorityQueue<Point> pq = new PriorityQueue<>(k);
        for (int[] point : points) {
            Point p = new Point(point);
            if (pq.size() < k) {
                pq.add(p);
            } else if (p.distance < pq.peek().distance) {
                pq.poll();
                pq.add(p);
            }
        }
        int[][] result = new int[pq.size()][2];
        int size = Math.min(pq.size(), k);
        for (int i = 0; i < size; i++) {
            result[i] = pq.poll().xy;
        }
        return result;
    }
}
