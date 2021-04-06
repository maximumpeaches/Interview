package com.company.leetcode.p139;

import java.util.*;

public class Solution1 implements Solution {

    /*

    ["goo", "gle"]
    "google"

    "googlegoo"
    "googlego"

    ["a", "aa", "aaa"]
    "aaaaaaaa"

    ""

    One thing about this problem is that if you just get the substring of s and check if it's in the wordDict using
    s.substring(i, j) function, then it works but is still pretty inefficient because it has to generate the hash code
    for the substring each time. Even if you build the substring using a StringBuilder you have to iterate through
    the entire substring to generate the hash code.
    One better way to do this is to generate the hash code on the fly similar to the Rabin-Karp algorithm.
    Another solution is to use a trie.
    Actually now that I think about it, because of potential hash collisions, you have to check all the matches
    character by character against each other so the running hash code / Rabin-Karp algorithm isn't *always* more
    efficient, and in worst case has same runtime as just checking if the substring is in the dictionary.
    So then would need to use a trie for optimal runtime (if can't assume there are few dictionary matches, like you
    would if you have a real world dictionary).
    However trie takes comparable time (maybe worse) in the step where you create the trie.
     */

    private String s;
    private Set<String> wordDict;
    private Map<Integer, Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = new HashSet<>(wordDict);
        this.memo.put(this.s.length(), true);
        return wordBreakHelper(0);
    }

    private boolean wordBreakHelper(int startingIndex) {
        if (this.memo.containsKey(startingIndex)) {
            return this.memo.get(startingIndex);
        }
        boolean matches = false;
        for (int i = startingIndex; i < this.s.length(); i++) {
            String substring = this.s.substring(startingIndex, i);
            if (this.wordDict.contains(substring)) {
                if (wordBreakHelper(i + 1)) {
                    matches = true;
                    break;
                }
            }
        }
        this.memo.put(startingIndex, matches);
        return matches;
    }




}
