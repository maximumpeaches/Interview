package com.company.leetcode.p942;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int[] diStringMatch(String s) {
        int[] result = new int[s.length() + 1];
        Set<Integer> remaining = new HashSet<>(s.length() + 1);
        for (int i = 0; i < s.length() + 1; i++) {
            remaining.add(i);
        }
        recursive(s, result, 0, remaining);
        return result;
    }

    private boolean recursive(String s, int[] result, int depth, Set<Integer> remaining) {
        if (depth == s.length()) {
            return true;
        }
        for (int i = 0; i < s.length() + 1; i++) {
            if (remaining.contains(i)) {
                result[depth] = i;
                remaining.remove(i);
                if (s.charAt(depth) == 'I') {
                    for (int j = i + 1; j < s.length() + 1; j++) {
                        if (recursive(s, result, depth + 1, remaining)) {
                            return true;
                        }
                    }
                } else {
                    for (int j = i - 1; j >= 0; j--) {
                        if (recursive(s, result, depth + 1, remaining)) {
                            return true;
                        }
                    }
                }
            }
            remaining.add(i);
        }
        return false;
    }
}