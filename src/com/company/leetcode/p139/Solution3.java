package com.company.leetcode.p139;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution3 implements Solution {
    private TrieNode root;
    private String s;
    private Set<String> wordDict;
    private Map<Integer, Boolean> memo = new HashMap<>();
    private static final class TrieNode {
        private boolean endsWord;
        private TrieNode[] next = new TrieNode[26];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;

        this.root = new TrieNode();
        for (String word : wordDict) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (current.next[c - 'a'] == null) {
                    current.next[c - 'a'] = new TrieNode();
                }
                current = current.next[c - 'a'];
                if (i == word.length() - 1) {
                    current.endsWord = true;
                }
            }
        }


        this.memo.put(this.s.length(), true);
        return wordBreakHelper(0);
    }

    /*
    abc
    root = [], false
    root1 = [], false
    current = root2 = [], false
    root3 = [], true

    a
     */

    private boolean wordBreakHelper(int startingIndex) {
        if (this.memo.containsKey(startingIndex)) {
            return this.memo.get(startingIndex);
        }
        boolean matches = false;
        TrieNode current = root;
        int i = 0;
        while (current != null) {
            char c = this.s.charAt(i);
            current = current.next[c - 'a'];
            i++;
            if (current != null && current.endsWord) {
                if (wordBreakHelper(i)) {
                    matches = true;
                    break;
                }
            }
        }
        this.memo.put(startingIndex, matches);
        return matches;
    }
}
