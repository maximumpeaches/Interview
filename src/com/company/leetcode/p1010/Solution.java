package com.company.leetcode.p1010;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /*
    34, 26
    1

    54, 6, 66
    6,  54, [-6, 54, 114, 174, etc.]



    60, 60, 60

    60 -> 0

    [] -> 0

    [30, 90]

    1 -> 0
    2 -> 1
    3 -> 3



     */
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int t : time) {
            int tMod60 = t % 60;
            Integer currentValue = cache.putIfAbsent(tMod60, 1);
            if (currentValue != null) {
                cache.put(tMod60, currentValue + 1);
            }
        }
        int result = 0;
        for (int i = 1; i < 30; i++) {
            if (cache.containsKey(i)) {
                int match = 60 - i;
                if (cache.containsKey(match)) {
                    int matchCount = cache.get(match);
                    result += matchCount * cache.get(i);
                }
            }
        }

        if (cache.containsKey(0)) {
            int value = cache.get(0);
            value--;
            while (value > 0) {
                result += value;
                value--;
            }
        }

        if (cache.containsKey(30)) {
            int value = cache.get(30);
            value--;
            while (value > 0) {
                result += value;
                value--;
            }
        }

        return result;
    }
}
