package com.company.leetcode.p72;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private String word1;
    private String word2;
    private Map<List<Integer>, Integer> memo = new HashMap<>();
    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        return helper(0, 0);
    }

    private void putPositions(int pos1, int pos2, int value) {

        this.memo.put(Arrays.asList(pos1, pos2), value);
    }

    private Integer get(int pos1, int pos2) {
        return this.memo.get(Arrays.asList(pos1, pos2));
    }

    private int helper(int pos1, int pos2) {
        if (this.get(pos1, pos2) != null) {
            return this.get(pos1, pos2);
        }
        int result = 0;
        if (pos1 == word1.length()) {
            result = word2.length() - pos2;
        } else if (pos2 == word2.length()) {
            result = word1.length() - pos1;
        } else if (word1.charAt(pos1) == word2.charAt(pos2)) {
            result = helper(pos1 + 1, pos2 + 1);
        } else {
            result = Math.min(1 + helper(pos1 + 1, pos2), Math.min(1 + helper(pos1, pos2 + 1), 1 + helper(pos1 + 1, pos2 + 1)));
        }
        this.putPositions(pos1, pos2, result);
        return result;
    }
}
