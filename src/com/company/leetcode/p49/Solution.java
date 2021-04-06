package com.company.leetcode.p49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (String s : strs) {
            Map<Character, Integer> stringMap = convertString(s);
            if (map.containsKey(stringMap)) {
                map.get(stringMap).add(s);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(s);
                map.put(stringMap, strings);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Map<Character, Integer>, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private Map<Character, Integer> convertString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
}
