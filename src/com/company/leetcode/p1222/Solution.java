package com.company.leetcode.p1222;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int NUM_ROWS = 8;
    private static final int NUM_COLS = 8;
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        // first index is row, second index is column

        int[][] board = new int[NUM_ROWS][NUM_COLS];
        for (int[] queen : queens) {
            board[queen[0]][queen[1]] = 1;
        }

        List<List<Integer>> result = new ArrayList<>();

        int kingRow = king[0];
        int kingCol = king[1];

        int row = kingRow;
        int col = kingCol;

        row += 1;
        while (row < NUM_ROWS) {
            if (board[row][col] == 1) {
                List<Integer> q = new ArrayList<>(2);
                q.add(row);
                q.add(col);
                result.add(q);
                break;
            }
            row++;
        }

        row = kingRow;
        while (row >= 0) {
            if (board[row][col] == 1) {
                List<Integer> q = new ArrayList<>(2);
                q.add(row);
                q.add(col);
                result.add(q);
                break;
            }
            row--;
        }

        row = kingRow;
        while (col < NUM_COLS) {
            if (board[row][col] == 1) {
                List<Integer> q = new ArrayList<>(2);
                q.add(row);
                q.add(col);
                result.add(q);
                break;
            }
            col++;
        }

        col = kingCol;
        while (col >= 0) {
            if (board[row][col] == 1) {
                List<Integer> q = new ArrayList<>(2);
                q.add(row);
                q.add(col);
                result.add(q);
                break;
            }
            col--;
        }


        row = kingRow + 1;
        col = kingCol + 1;
        while (!isOutOfBounds(row, col)) {
            if (board[row][col] == 1) {
                List<Integer> q = new ArrayList<>(2);
                q.add(row);
                q.add(col);
                result.add(q);
                break;
            }
            row++;
            col++;
        }

        row = kingRow + 1;
        col = kingCol - 1;
        while (!isOutOfBounds(row, col)) {
            if (board[row][col] == 1) {
                List<Integer> q = new ArrayList<>(2);
                q.add(row);
                q.add(col);
                result.add(q);
                break;
            }
            row++;
            col--;
        }

        row = kingRow - 1;
        col = kingCol - 1;
        while (!isOutOfBounds(row, col)) {
            if (board[row][col] == 1) {
                List<Integer> q = new ArrayList<>(2);
                q.add(row);
                q.add(col);
                result.add(q);
                break;
            }
            row--;
            col--;
        }

        row = kingRow - 1;
        col = kingCol + 1;
        while (!isOutOfBounds(row, col)) {
            if (board[row][col] == 1) {
                List<Integer> q = new ArrayList<>(2);
                q.add(row);
                q.add(col);
                result.add(q);
                break;
            }
            row--;
            col++;
        }

        return result;
    }

    private boolean isOutOfBounds(int row, int col) {
        if (row < 0 || col < 0) {
            return true;
        } else if (row >= NUM_ROWS || col >= NUM_COLS) {
            return true;
        } else {
            return false;
        }
    }
}
