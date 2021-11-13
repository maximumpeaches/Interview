package com.company.leetcode.p973;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution2 {
    private static final class Point {
        int x;
        int y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final class ReverseDistanceComparator implements Comparator<Point> {
        @Override
        public int compare(Point a, Point b) {
            double aP = Math.sqrt(Math.pow(a.x, 2) + Math.pow(a.y, 2));
            double bP = Math.sqrt(Math.pow(b.x, 2) + Math.pow(b.y, 2));
            return -Double.compare(aP, bP);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        Comparator<Point> comparator = new ReverseDistanceComparator();
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(k, comparator);
        for (int[] point : points) {
            Point p = new Point(point[0], point[1]);
            if (maxHeap.size() < k) {
                maxHeap.add(p);
            } else if (comparator.compare(maxHeap.peek(), p) < 0) {
                maxHeap.remove();
                maxHeap.add(p);
            }
        }
        int[][] result = new int[maxHeap.size()][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            Point p = maxHeap.remove();
            result[i] = new int[]{p.x, p.y};
            i++;
        }
        return result;
    }
}
