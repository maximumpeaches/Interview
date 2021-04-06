package com.company.leetcode.p1269;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final class Data {
        private int stepsRemaining;
        private int arrayPosition;
        private Data(int stepsRemaining, int arrayPosition) {
            this.stepsRemaining = stepsRemaining;
            this.arrayPosition = arrayPosition;
        }

        @Override
        public boolean equals(Object o) {
            Data other = (Data) o;
            if (other.stepsRemaining == this.stepsRemaining && other.arrayPosition == this.arrayPosition) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return this.stepsRemaining * 31 + this.arrayPosition;
        }
    }

    private final Map<Data, Long> cache = new HashMap<>();

    /*
    s = 3, len = 4

    [0, 1, 2, 3]
     */
    private int arrLen;
    public int numWays(int steps, int arrLen) {
        this.arrLen = arrLen;
        return (int) (numWaysRecursive(steps, 0) % (Math.pow(10, 9) + 7));
    }

    private long numWaysRecursive(int stepsRemaining, int arrayPosition) {
        Data d = new Data(stepsRemaining, arrayPosition);
        Long numWays = cache.get(d);
        if (numWays != null) {
            return numWays;
        }
        if (arrayPosition == 0) {
            if (stepsRemaining == 0) {
                numWays = 1L;
            } else {
                numWays = numWaysRecursive(stepsRemaining - 1, 1) + numWaysRecursive(stepsRemaining - 1, 0);
            }
        } else if (stepsRemaining == 0) {
            numWays = 0L;
        } else {
            if (arrayPosition < 0 || arrayPosition >= arrLen) {
                numWays = 0L;
            } else {
                numWays = numWaysRecursive(stepsRemaining - 1, arrayPosition - 1) + numWaysRecursive(stepsRemaining - 1, arrayPosition + 1) + numWaysRecursive(stepsRemaining - 1, arrayPosition);
            }
        }
        this.cache.put(d, numWays);
        return numWays;
    }
}
