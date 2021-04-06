package com.company.leetcode.p1072;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {

    public  int maxEqualRowsAfterFlips(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0].length == 1) {
            return matrix.length;
        }

        int[] a = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            a[row] = matrix[row][0];
        }

        int[] b = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            b[row] = matrix[row][0] == 0 ? 1 : 0;
        }

        Map<Key, Integer> cache = new HashMap<>();

        return Math.max(m(matrix, a, 1, cache), m(matrix, b, 1, cache));
    }

    private  final class Key {
        private int col;
        private int[] j;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return col == key.col && Arrays.equals(j, key.j);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(col);
            result = 31 * result + Arrays.hashCode(j);
            return result;
        }
    }

    private  int m(int[][] matrix, int[] j, int col, Map<Key, Integer> cache) {
        Key key = new Key();
        key.col = col;
        key.j = Arrays.copyOf(j, j.length);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (col >= matrix[0].length) {
            int sum = 0;
            for (int k : j) {
                sum += k == -1 ? 0 : 1;
            }
            if (sum == 4) {
                System.out.println("last: " + Arrays.toString(j));
            }

            return sum;
        }
        int[] copy = Arrays.copyOf(j, j.length);
        for (int t = 0; t < matrix.length; t++) {
            j[t] = j[t] == matrix[t][col] ? j[t] : -1;
        }
        for (int t = 0; t < matrix.length; t++) {
            copy[t] = copy[t] != matrix[t][col] ? copy[t] : -1;
        }
        int result = Math.max(m(matrix, j, col + 1, cache), m(matrix, copy, col + 1, cache));
        cache.put(key, result);
        return result;
    }
}
