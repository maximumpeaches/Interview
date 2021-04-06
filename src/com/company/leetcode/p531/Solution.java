package com.company.leetcode.p531;

public class Solution {
    /*
    What about:

    W W W W
    W B W B
    W W W W
     */
    public int findLonelyPixel(char[][] picture) {
        int numRows = picture.length;
        int numCols = picture[0].length;

        int[] rowCount = new int[numRows];
        int[] colCount = new int[numCols];

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                char pixel = picture[rowIdx][colIdx];
                if (pixel == 'B') {
                    // could get int overflow here, but unlikely
                    rowCount[rowIdx]++;
                    colCount[colIdx]++;
                }
            }
        }

        // could get int overflow
        int count = 0;
        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                char pixel = picture[rowIdx][colIdx];
                if (pixel == 'B' && rowCount[rowIdx] == 1 && colCount[colIdx] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
