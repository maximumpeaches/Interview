package com.company.leetcode.p56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
    [] -> []
    [[2,8]] -> [[2,8]]

    [[1,3],[2,6],[8,10],[15,18]]
    ->
    [[1,6],[8,10],[15,18]]

    [[1,20],[3,5],[4,9]]

    [[1, 5], [5, 7]] -> [[1, 7]]

    [[2, 7], [2, 9]]
    [[2, 9], [2, 7]]
     */
    public int[][] merge(int[][] intervals) {

        List<List<Integer[]>> buckets = new ArrayList<>();
        for (int i = 0; i < 10_001; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int[] interval : intervals) {
            Integer[] copy = new Integer[2];
            copy[0] = interval[0];
            copy[1] = interval[1];
            buckets.get(interval[0]).add(copy);
        }

        List<List<Integer>> resultL = new ArrayList<>();

        int resultIndex = 0;
        for (int i = 0; i < 10_001; i++) {
            List<Integer[]> bucket = buckets.get(i);
            for (Integer[] range : bucket) {
                if (resultL.isEmpty()) {
                    resultL.add(Arrays.asList(range[0], range[1]));
                } else {
                    // compare current range to resultL at resultIndex
                    int secondInList = resultL.get(resultIndex).get(1);
                    if (secondInList >= range[1]) {
                        continue;
                    } else if (secondInList >= range[0]) {
                        resultL.get(resultIndex).set(1, range[1]);
                    } else {
                        resultL.add(Arrays.asList(range[0], range[1]));
                        resultIndex++;
                    }
                }
            }
        }
        int[][] result = new int[resultL.size()][2];
        for (int i = 0; i < resultL.size(); i++) {
            List<Integer> list = resultL.get(i);
            result[i] = new int[]{list.get(0), list.get(1)};
        }

        return result;
    }
}
