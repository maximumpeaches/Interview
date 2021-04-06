package com.company.leetcode.p139;

import java.util.*;

public class Solution2 implements Solution {
    private Map<Integer, List<String>> dict = new HashMap<>();
    private int longestString = 0;
    private String s;
    private Map<Integer, Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        for (String word : wordDict) {
            longestString = Math.max(s.length(), longestString);
            int wordHashCode = 0;
            for (int i = 0; i < word.length(); i++) {
                wordHashCode = wordHashCode * 31 + word.charAt(i);
            }
            if (dict.containsKey(wordHashCode)) {
                dict.get(wordHashCode).add(word);
            } else {
                List<String> value = new LinkedList<>();
                value.add(word);
                dict.put(wordHashCode, value);
            }
        }
        this.memo.put(this.s.length(), true);
        return wordBreakHelper(0);
    }

    private boolean wordBreakHelper(int startingIndex) {
        if (this.memo.containsKey(startingIndex)) {
            return this.memo.get(startingIndex);
        }
        boolean matches = false;
        int runningHashCode = 0;
        for (int i = startingIndex; i < this.s.length() && i <= longestString; i++) {
            runningHashCode = runningHashCode * 31 + this.s.charAt(i);
            List<String> potentialMatches = dict.get(runningHashCode);
            if (potentialMatches != null) {
                for (String potentialMatch : potentialMatches) {
                    if (potentialMatch.equals(this.s.substring(startingIndex, i))) {
                        if (wordBreakHelper(i + 1)) {
                            matches = true;
                            break;
                        }
                    }
                }
            }
            if (matches) {
                break;
            }
        }
        this.memo.put(startingIndex, matches);
        return matches;
    }
}
