package com.company.leetcode.p792;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    /*
    Math.max(len(s), len(word1)) + Math.max(len(s), len(word_2))....
    len(s) * (len(1) + len(2))
    len(s) * num_words * avg_length

    len(s) + each_character_in_words

    abcd

    cd

    cd
    */

    private static final class X {
        private int pos = 0;
        private String val;

        private X(String val) {
            this.val = val;
        }

        private Character currentChar() {
            if (pos == val.length()) {
                return null;
            }
            return this.val.charAt(pos);
        }

        private void incrementPos() {
            this.pos++;
        }


    }

    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Set<X>> m = new HashMap<>(26);
        for (String word : words) {
            X x = new X(word);
            char currentChar = x.currentChar();
            if (m.get(currentChar) == null) {
                m.put(currentChar, new HashSet<>());
            }
            m.get(currentChar).add(x);
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (m.get(c) != null && !m.get(c).isEmpty()) {
                Set<X> toRemove = new HashSet<>(m.get(c).size());
                for (X x : m.get(c)) {
                    x.incrementPos();
                    toRemove.add(x);
                }
                for (X x : toRemove) {
                    m.get(c).remove(x);
                }
                for (X x : toRemove) {
                    Character r = x.currentChar();
                    if (r == null) {
                        result++;
                    } else {
                        m.computeIfAbsent(r, k -> new HashSet<>());
                        m.get(r).add(x);
                    }
                }
            }
        }
        return result;
    }
}
