package com.company.leetcode.p1048;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    private Map<Integer, Set<String>> m;
    private int longestChainLength = 0;
    private Map<String, Integer> memo = new HashMap<>();
    public int longestStrChain(String[] words) {
        m = new HashMap<>(words.length);
        for (String word : words) {
            if (m.get(word.length()) == null) {
                m.put(word.length(), new HashSet<>());
            }
            m.get(word.length()).add(word);
        }

        for (String word : words) {
            findChainLength(word);
        }

        return longestChainLength;
    }

    private int findChainLength(String s) {
        if (memo.get(s) != null) {
            return memo.get(s);
        }
        Set<String> potentials = this.m.get(s.length() + 1);
        int chainLength = 1;
        if (potentials != null) {
            for (String potential : potentials) {
                if (isPredecessor(s, potential)) {
                    chainLength = Math.max(findChainLength(potential) + 1, chainLength);
                }
            }
        }
        memo.put(s, chainLength);
        longestChainLength = Math.max(chainLength, longestChainLength);
        return chainLength;
    }

    private boolean isPredecessor(String s, String l) {
        int mismatches = 0;
        int sC = 0;
        int lC = 0;
        while (lC < l.length()) {
            if (sC == s.length()) {
                lC++;
                mismatches++;
            } else if (s.charAt(sC) != l.charAt(lC)) {
                lC++;
                mismatches++;
            } else {
                sC++;
                lC++;
            }
        }
        return mismatches == 1;
    }
}
