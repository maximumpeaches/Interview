package com.company.leetcode.p253;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void exampleOne() {
        // [[0,30],[5,10],[15,20]]
        Solution solution = new Solution();
        int[][] intervals = new int[3][2];

        intervals[0] = new int[]{0, 30};
        intervals[2] = new int[]{5, 10};
        intervals[1] = new int[]{15, 20};
        int result = solution.minMeetingRooms(intervals);
        assertEquals(2, result);
    }
}