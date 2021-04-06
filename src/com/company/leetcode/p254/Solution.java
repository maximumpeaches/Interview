package com.company.leetcode.p254;

import java.util.*;

public class Solution {

    /*
    9 = [3, 3]
    10 = [5, 2]
    18 = [9, 2], [3, 3, 2]
    180 = [10, 18], [5, 2, 2, 9], [5, 2, 3, 3, 2]
     */

    public List<List<Integer>> getFactors(int n) {
        return null;
    }

    private Set<Map<Integer, Integer>> getFactorsR(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                int a = i;
                int b = n / i;
                Set<Map<Integer, Integer>> factorsA = getFactorsR(a);
                Set<Map<Integer, Integer>> factorsB = getFactorsR(b);
                Set<Map<Integer, Integer>> factorsI = new HashSet<>();
                Map<Integer, Integer> j = new HashMap<>();
                j.put(a, 1);
                j.put(b, 1);
                factorsI.add(j);
                for (Map<Integer, Integer> mapA : factorsA) {
                    for (Map<Integer, Integer> mapB : factorsB) {
                        Map<Integer, Integer> mapI = new HashMap<>();

                    }
                }

            }
        }
        return null;
    }
}
