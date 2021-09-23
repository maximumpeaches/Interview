package com.company.leetcode.p253;

import java.util.Arrays;

public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
        return 0;
    }
}
