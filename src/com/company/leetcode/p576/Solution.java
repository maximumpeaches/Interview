package com.company.leetcode.p576;

import java.util.HashMap;

public class Solution {
    private HashMap<Integer, Integer>[][] memo;
    public int findPaths(int y, int x, int maxMove, int startRow, int startColumn) {
        memo = new HashMap[y][x];
        for (int yI = 0; yI < y; yI++) {
            for (int xI = 0; xI < x; x++) {
                this.memo[yI][xI] = new HashMap<>();
            }
        }
        return helper(startRow, startColumn, maxMove);
    }

    private int helper(int y, int x, int maxMove) {
        if (y < 0 || y >= this.memo.length || x < 0 || x >= this.memo[0].length) {
            return 1;
        }
        if (this.memo[y][x].get(maxMove) != null) {
            return this.memo[y][x].get(maxMove);
        }
        int result = 0;
        if (maxMove == 0) {
            result = 0;
        } else {
            result = helper(y - 1, x, maxMove - 1) + helper(y + 1, x, maxMove - 1) + helper(y, x + 1, maxMove - 1) + helper(y, x - 1, maxMove - 1);
        }
        this.memo[y][x].put(maxMove, result);
        return result;
    }

}
