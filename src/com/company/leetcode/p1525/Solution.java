package com.company.leetcode.p1525;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numSplits(String s) {
        Map<Character, Integer> frontMap = new HashMap<>();
        Map<Character, Integer> backMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            this.add(backMap, s.charAt(i));
        }

        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            this.add(frontMap, s.charAt(i));
            this.remove(backMap, s.charAt(i));
            if (frontMap.size() == backMap.size()) {
                result++;
            }
        }
        return result;
    }

    private void remove(Map<Character, Integer> map, Character c) {
        if (map.get(c) == 1) {
            map.remove(c);
        } else {
            map.put(c, map.get(c) - 1);
        }
    }

    private void add(Map<Character, Integer> map, Character c) {
        if (map.get(c) == null) {
            map.put(c, 0);
        }
        map.put(c, map.get(c) + 1);
    }
}
